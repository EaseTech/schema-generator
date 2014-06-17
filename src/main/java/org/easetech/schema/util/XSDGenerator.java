
package org.easetech.schema.util;

import static org.reflections.ReflectionUtils.getAllFields;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withName;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlAttribute;
import org.easetech.schema.Annotation;
import org.easetech.schema.ComplexType;
import org.easetech.schema.Documentation;
import org.easetech.schema.Element;
import org.easetech.schema.Schema;
import org.easetech.schema.UseValues;
import org.easetech.schemagenerator.XSDUtil;

/**
 * Class that is responsible for generating the XSD String from the {@link Schema} instance
 *
 */
public class XSDGenerator {

    /**
     * static string for equal
     */
    private static final String EQUAL = "=";

    /**
     * static string for space
     */
    private static final String SPACE = " ";

    /**
     * static string for attribute placeholder in a template string
     */
    private static final String ATTRIBUTE_PLACEHOLDER = "{attributes}";

    /**
     * static string for line seperator
     */
    private static final String LINE_SEPERATOR = System.getProperty("line.separator");

    /**
     * Given an XSD Class instance, 
     * <li> fetch all the attributes of the class, as identified by {@link XmlAttribute} annotation</li>
     * <li> Get the values of the attributes as entered by the user</li>
     * <li> Create a string like this : {attributeName}="attributeValue"</li>
     * 
     * @param xsdClassInstance the xsd class whose attributes are to be fetched
     * @return string representation of the attributes or empty string in case none of the attribute value is specified by the user
     * @throws IllegalAccessException - if this {@link Field} object is enforcing Java language access control and the underlying field is inaccessible.
     * @throws  IllegalArgumentException - if the specified object is not an instance of the class or interface declaring the underlying field (or a subclass or implementor thereof).
     */
    @SuppressWarnings("unchecked")
    private static String generateAttributeStringFor(Object xsdClassInstance) throws IllegalArgumentException, IllegalAccessException  {
        Set<Field> fields = getAllFields(xsdClassInstance.getClass(), withAnnotation(XmlAttribute.class));
        StringBuilder attributesBuilder = new StringBuilder();

        if (fields != null) {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getAnnotation(XmlAttribute.class).name();
                Object fieldvalue = field.get(xsdClassInstance);
                if (field.getType().isEnum() && fieldvalue != null) {
                    if (UseValues.class.isAssignableFrom(field.getType())) {
                        fieldvalue = ((UseValues) fieldvalue).value();
                    }
                }
                if (fieldvalue != null) {
                    attributesBuilder.append(fieldName).append(EQUAL).append('"').append(fieldvalue.toString())
                        .append('"').append(SPACE);
                }
            }
        }

        return attributesBuilder.toString();
    }

    /**
     * Assign the attributes as generated using {@link #generateAttributeStringFor(Object)} method to the {@link Template}
     * @param template the template whose attributes will be assigned
     * @param xsdClassInstance the xsd class whose attributes needs to be assigned
     * @return a template with attributes properly filled
     * @throws IllegalAccessException - if this {@link Field} object is enforcing Java language access control and the underlying field is inaccessible.
     * @throws  IllegalArgumentException - if the specified object is not an instance of the class or interface declaring the underlying field (or a subclass or implementor thereof).
     */
    private static Template assignAttributes(Template template, Object xsdClassInstance)
        throws IllegalArgumentException, IllegalAccessException {
        String attributes = generateAttributeStringFor(xsdClassInstance);
        if (attributes != null) {
            template = template.replace(ATTRIBUTE_PLACEHOLDER, attributes);
        }
        return template;
    }

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Schema schema = new Schema();
        Annotation annotation = new Annotation();
        Documentation documentation = new Documentation();
        documentation.setContent("This is the content");
        annotation.getDocumentation().add(documentation);
        schema.setAnnotation(annotation);
        schema.getElement().add(
        XSDUtil.generateElement("simpleList", null));
            Element element = XSDUtil.generateElement("simpleName", "simpleName",
                "1", "unbounded");

        ComplexType rootComplexType = XSDUtil.generateComplexType(
        "simpleList", element);
    schema.getComplexType().add(rootComplexType);
        System.out.println(fillTemplate(schema));
        // generateAttributeStringFor(schema);
    }

    /**
     * Normalize the placeholders inside the template. Remove "{" and "}" 
     * @param ph the placeholder text
     * @return normalized text
     */
    private static String normalizePlaceHolder(String ph) {
        ph = ph.replace("{", "");
        ph = ph.replace("}", "");
        return ph;
    }

    /**
     * Method that a user should call to create a String representation of the Schema as defined by the user using {@link Schema} instance.
     * Please see the README file for some examples of defining the Schema.
     * @param schema the Schema instance that will be converted to a string representation
     * @return String representation of the schema instance
     * @throws IllegalAccessException - if this {@link Field} object is enforcing Java language access control and the underlying field is inaccessible.
     * @throws  IllegalArgumentException - if the specified object is not an instance of the class or interface declaring the underlying field (or a subclass or implementor thereof).
     */
    public static String generateSchema(Schema schema) throws IllegalArgumentException, IllegalAccessException {
        return fillTemplate(schema);
    }

    /**
     * Method to save the generated schema from {@link #generateSchema(Schema)} method to an appropriate location
     * @param schemaString the string representation of the schema file
     * @param path the path where the file should be created
     * @param nameOfSchemaFile the name of the schema file, without the xsd extension
     * @param deleteFileIfAlreadyPresent option whether to delete the already existing file with the same name at teh same path, if any.
     * @throws IOException If an I/O error occurred
     */
    public static void saveSchema(String schemaString, String path, String nameOfSchemaFile , Boolean deleteFileIfAlreadyPresent) throws IOException {
        String filePath = path.endsWith("/") ? path.concat(nameOfSchemaFile).concat(".xsd") : path.concat("/").concat(nameOfSchemaFile).concat(".xsd");
        File xsdFile = new File(filePath);
        if (xsdFile.exists()) {
            if(deleteFileIfAlreadyPresent) {
                xsdFile.delete();
            } else {
                throw new RuntimeException("File with path :" + filePath +" already exists");
            }
            
        }
        xsdFile.createNewFile();
        Writer writer = null;
        try {
            if (xsdFile.exists()) {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xsdFile), "utf-8"));
                writer.write(schemaString);
            }
            
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (Exception ex) {
                throw new RuntimeException("Exception occurred while trying to close the writer instance", ex);
            }
        }
    }
    /**
     * Method that will, recursively, fetch the templates associated with each XSD related Class instance and fill them with values as defined in the classes. 
     * @param instance the xsd class instance. Normally it is the instance of {@link Schema} class at the start.
     * @return filled template string representation
     * @throws IllegalAccessException - if this {@link Field} object is enforcing Java language access control and the underlying field is inaccessible.
     * @throws  IllegalArgumentException - if the specified object is not an instance of the class or interface declaring the underlying field (or a subclass or implementor thereof).
     */
    @SuppressWarnings("unchecked")
    private static String fillTemplate(Object instance) throws IllegalArgumentException, IllegalAccessException {
        String result = "";
        if (instance != null) {
            Class<?> instanceClazz = instance.getClass();
            if (List.class.isAssignableFrom(instanceClazz)) {
                instanceClazz = (Class<?>) ((ParameterizedType) instanceClazz.getGenericSuperclass())
                    .getActualTypeArguments()[0];
            }
            Template template = Template.getTemplateFor(instanceClazz);

            if (template == null) {
                // Assume that we can simply call to string on the value and put it as placeholder value
                StringBuilder sb = new StringBuilder();
                return sb.append('"').append(instance.toString()).append('"').toString();

            } else {

                template = assignAttributes(template, instance);
                List<String> placeHolders = Template.getPlaceHolders(template);
                for (String placeHolderWithBrcket : placeHolders) {
                    String placeHolder = normalizePlaceHolder(placeHolderWithBrcket);
                    Boolean isEnum = "{enumeration}".equals(placeHolderWithBrcket);
                    Set<Field> fields = getAllFields(instance.getClass(), withName(placeHolder));
                    Field field = fields.iterator().next();
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    if (List.class.isAssignableFrom(fieldType)) {
                        StringBuilder filledTemplateString = new StringBuilder("");

                        List fieldInstances = (List) field.get(instance);
                        if (fieldInstances == null || fieldInstances.isEmpty()) {
                            template = template.replace(placeHolderWithBrcket + LINE_SEPERATOR, "");
                        } else {
                            Template enumTemplate = null;

                            for (Object fieldInstance : fieldInstances) {
                                if (isEnum) {
                                    enumTemplate = Template.getTemplateFor(Enum.class);

                                }
                                if (enumTemplate != null) {
                                    StringBuilder fieldValue = new StringBuilder().append('"')
                                        .append(fieldInstance.toString()).append('"');
                                    enumTemplate = enumTemplate.replace("{value}", fieldValue.toString());
                                    filledTemplateString.append(enumTemplate.getTemplateText()).append(LINE_SEPERATOR);
                                } else {
                                    String filledTemplate = fillTemplate(fieldInstance);
                                    filledTemplateString.append(filledTemplate).append(LINE_SEPERATOR);
                                }

                            }
                            template = template.replace(placeHolderWithBrcket, filledTemplateString.toString());
                        }

                    } else {
                        Object fieldInstance = field.get(instance);
                        String filledTemplate = fillTemplate(fieldInstance);
                        if (filledTemplate == null || "".equals(filledTemplate)) {
                            template = template.replace(placeHolderWithBrcket + LINE_SEPERATOR, filledTemplate);
                        } else {
                            template = template.replace(placeHolderWithBrcket, filledTemplate);
                        }

                    }

                }
            }
            result = template.getTemplateText();
        }

        return result;

    }
}
