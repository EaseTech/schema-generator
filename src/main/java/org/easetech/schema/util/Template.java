package org.easetech.schema.util;

import org.easetech.schema.SimpleContent;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.easetech.schema.All;
import org.easetech.schema.Annotation;
import org.easetech.schema.Any;
import org.easetech.schema.AnyAttribute;
import org.easetech.schema.AppInfo;
import org.easetech.schema.Attribute;
import org.easetech.schema.AttributeGroup;
import org.easetech.schema.Choice;
import org.easetech.schema.ComplexContent;
import org.easetech.schema.ComplexType;
import org.easetech.schema.Documentation;
import org.easetech.schema.Element;
import org.easetech.schema.ExtensionComplexContent;
import org.easetech.schema.ExtensionSimpleContent;
import org.easetech.schema.Field;
import org.easetech.schema.Group;
import org.easetech.schema.Import;
import org.easetech.schema.Include;
import org.easetech.schema.Key;
import org.easetech.schema.KeyRef;
import org.easetech.schema.List;
import org.easetech.schema.Notation;
import org.easetech.schema.Redefine;
import org.easetech.schema.RestrictionComplexContent;
import org.easetech.schema.RestrictionSimpleContent;
import org.easetech.schema.RestrictionSimpleType;
import org.easetech.schema.Schema;
import org.easetech.schema.Selector;
import org.easetech.schema.Sequence;
import org.easetech.schema.SimpleType;
import org.easetech.schema.Union;
import org.easetech.schema.Unique;

/**
 * 
 * Class responsible for decoupling the templates associated with various XSD elements
 * from their corresponding classes. 
 * This class defines a {@link Template} instance for each of the XSD Elements with 
 * placeholder tags that are resolved at runtime.
 *
 */
public class Template {
    
    /**
     * New Line character
     */
    private static final String LINE_SEPERATOR = System.getProperty("line.separator");
    
    /**
     * The text associated with the template
     */
    private final String templateText;
    
    /**
     * A Placeholder pattern within the template text string
     */
    private static Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\{.*\\}");

    /**
     * Specific attribute placeholder
     */
    private static final String ATTRIBUTE_PLACEHOLDER = "{attributes}";
    
    /**
     * A map of XSD class and it corresponding Template 
     */
    public static Map<Class , Template> classAndTemplateMap = new HashMap<Class, Template>();
    
    /**
     * Get the text associated with the template
     * @return the templateText the text associated with the template
     */
    public String getTemplateText() {
        return templateText;
    }
    

    /**
     * 
     * Construct a new Template. While constructing it will create a map
     * of classes representing an XSD element to their actual template
     * @param templateText the text associated with the template
     */
    public Template(String templateText) {
        super();
        this.templateText = templateText;
          
    }
   
    /**
     * Get the template associated with the class parameter or null if none exists
     * @param clazz the class for which a template instance is required
     * @return a template instance or null if none exists
     */
    public static Template getTemplateFor(Class<?> clazz) {
        if (classAndTemplateMap.isEmpty()) {
            classAndTemplateMap.put(All.class, XSD_ALL_TEMPLATE);
            classAndTemplateMap.put(Annotation.class, XSD_ANNOTATION_TEMPLATE);
            classAndTemplateMap.put(Any.class, XSD_ANY_TEMPLATE);
            classAndTemplateMap.put(AnyAttribute.class, XSD_ANY_ATTRIBUTE_TEMPLATE);
            classAndTemplateMap.put(AppInfo.class, XSD_APP_INFO_TEMPLATE);
            classAndTemplateMap.put(Attribute.class, XSD_ATTRIBUTE_TEMPLATE);
            classAndTemplateMap.put(AttributeGroup.class, XSD_ATTRIBUTE_GROUP_TEMPLATE);
            classAndTemplateMap.put(Choice.class, XSD_CHOICE_TEMPLATE);
            classAndTemplateMap.put(ComplexContent.class, XSD_COMPLEX_CONTENT_WITH_RESTRICTION_TEMPLATE);
            //TODO:classAndTemplateMap.put(ExtensionComplexContent.class, XSD_COMPLEX_CONTENT_WITH_EXTENSION_TEMPLATE);
            classAndTemplateMap.put(ComplexType.class, XSD_COMPLEX_TYPE_TEMPLATE);
            classAndTemplateMap.put(Documentation.class, XSD_DOCUMENTATION_TEMPLATE);
            classAndTemplateMap.put(Element.class, XSD_ELEMENT_TEMPLATE);
            classAndTemplateMap.put(Enum.class, XSD_ENUM_TEMPLATE);
            classAndTemplateMap.put(ExtensionComplexContent.class, XSD_EXTENSION_COMPLEX_CONTENT_TEMPLATE);
            classAndTemplateMap.put(ExtensionSimpleContent.class, XSD_EXTENSION_SIMPLE_CONTENT_TEMPLATE);
            classAndTemplateMap.put(Field.class, XSD_FIELD_TEMPLATE);
            classAndTemplateMap.put(Group.class, XSD_GROUP_TEMPLATE);
            classAndTemplateMap.put(Import.class, XSD_IMPORT_TEMPLATE);
            classAndTemplateMap.put(Include.class, XSD_INCLUDE_TEMPLATE);
            classAndTemplateMap.put(Key.class, XSD_KEY_TEMPLATE);
            classAndTemplateMap.put(KeyRef.class, XSD_KEY_REF_TEMPLATE);
            classAndTemplateMap.put(List.class, XSD_LIST_TEMPLATE);
            classAndTemplateMap.put(Notation.class, XSD_NOTATION_TEMPLATE);
            classAndTemplateMap.put(Redefine.class, XSD_REDEFINE_TEMPLATE);
            classAndTemplateMap.put(RestrictionComplexContent.class, XSD_RESTRICTION_COMPLEX_CONTENT_TEMPLATE);
            classAndTemplateMap.put(RestrictionSimpleContent.class, XSD_RESTRICTION_SIMPLE_CONTENT_TEMPLATE);
            classAndTemplateMap.put(RestrictionSimpleType.class, XSD_RESTRICTION_SIMPLE_TYPE_TEMPLATE);
            classAndTemplateMap.put(Schema.class, XSD_SCHEMA_TEMPLATE);
            classAndTemplateMap.put(Selector.class, XSD_SELECTOR_TEMPLATE);
            classAndTemplateMap.put(Sequence.class, XSD_SEQUENCE_TEMPLATE);
            classAndTemplateMap.put(SimpleContent.class, XSD_SIMPLE_CONTENT);
            classAndTemplateMap.put(SimpleType.class, XSD_SIMPLE_TYPE_TEMPLATE);
            classAndTemplateMap.put(Union.class, XSD_UNION_TEMPLATE);
            classAndTemplateMap.put(Unique.class, XSD_UNIQUE_TEMPLATE); 
            
        }
        return classAndTemplateMap.get(clazz);
    }

    /**
     * Template for {@link All}
     */
    public static final Template XSD_ALL_TEMPLATE = new Template("<xsd:all {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{element}" + LINE_SEPERATOR
        + "</xsd:all>");

    /**
     * Template for {@link Annotation}
     */
    public static final Template XSD_ANNOTATION_TEMPLATE = new Template("<xsd:annotation {attributes}>" + LINE_SEPERATOR 
        + "{appInfo}" + LINE_SEPERATOR
        + "{documentation}" + LINE_SEPERATOR
        + "</xsd:annotation>");

    /**
     * Template for {@link Any}
     */
    public static final Template XSD_ANY_TEMPLATE = new Template("<xsd:any {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR  
        + "</xsd:any>");
    
    /**
     * Template for {@link AnyAttribute}
     */
    public static final Template XSD_ANY_ATTRIBUTE_TEMPLATE = new Template("<xsd:anyAttribute {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR  
        + "</xsd:anyAttribute>");

    /**
     * Template for {@link AppInfo}
     */
    public static final Template XSD_APP_INFO_TEMPLATE = new Template("<xsd:appinfo {attributes}>" + LINE_SEPERATOR 
        + "{content}" + LINE_SEPERATOR  
        + "</xsd:appinfo>");

    /**
     * Template for {@link Attribute}
     */
    public static final Template XSD_ATTRIBUTE_TEMPLATE = new Template("<xsd:attribute {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR
        + "{simpleType}" + LINE_SEPERATOR                                           
        + "</xsd:attribute>");

    /**
     * Template for {@link AttributeGroup}
     */
    public static final Template XSD_ATTRIBUTE_GROUP_TEMPLATE = new Template("<xsd:attributeGroup {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR
        + "{attribute}" + LINE_SEPERATOR
        + "{attributeGroup}" + LINE_SEPERATOR
        + "{anyAttribute}" + LINE_SEPERATOR                                           
        + "</xsd:attributeGroup>");

    /**
     * Template for {@link Choice}
     */
    public static final Template XSD_CHOICE_TEMPLATE = new Template("<xsd:choice {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{element}" + LINE_SEPERATOR
        + "{choice}" + LINE_SEPERATOR
        + "{sequence}" + LINE_SEPERATOR
        + "{group}" + LINE_SEPERATOR 
        + "{any}" + LINE_SEPERATOR
        + "</xsd:choice>");

    /**
     * Template for {@link ComplexContent}
     */
    public static final Template XSD_COMPLEX_CONTENT_WITH_RESTRICTION_TEMPLATE = new Template("<xsd:complexContent {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{restriction}" + LINE_SEPERATOR
        + "</xsd:complexContent>");

    /**
     * Template for {@link ComplexContent}
     */
    public static final Template XSD_COMPLEX_CONTENT_WITH_EXTENSION_TEMPLATE = new Template("<xsd:complexContent {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{extension}" + LINE_SEPERATOR
        + "</xsd:complexContent>");

    /**
     * Template for {@link ComplexType}
     */
    public static final Template XSD_COMPLEX_TYPE_TEMPLATE = new Template("<xsd:complexType {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR  
        + "{simpleContent}" + LINE_SEPERATOR 
        + "{complexContent}" + LINE_SEPERATOR 
        + "{group}" + LINE_SEPERATOR 
        + "{all}" + LINE_SEPERATOR
        + "{choice}" + LINE_SEPERATOR
        + "{sequence}" + LINE_SEPERATOR
        + "{attribute}" + LINE_SEPERATOR
        + "{attributeGroup}" + LINE_SEPERATOR
        + "{anyAttribute}" + LINE_SEPERATOR
        + "</xsd:complexType>");

    /**
     * Template for {@link Documentation}
     */
    public static final Template XSD_DOCUMENTATION_TEMPLATE = new Template("<xsd:documentation {attributes}>" + LINE_SEPERATOR 
        + "{content}" + LINE_SEPERATOR  
        + "</xsd:documentation>");

    /**
     * Template for {@link Element}
     */
    public static final Template XSD_ELEMENT_TEMPLATE = new Template("<xsd:element {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR
        + "{simpleType}" + LINE_SEPERATOR 
        + "{complexType}" + LINE_SEPERATOR                                           
        + "{key}" + LINE_SEPERATOR
        + "{keyref}" + LINE_SEPERATOR
        + "{unique}" + LINE_SEPERATOR                                           
        + "</xsd:element>");
    
    public static final Template XSD_ENUM_TEMPLATE = new Template("<xsd:enumeration value={value} />" + LINE_SEPERATOR);

    /**
     * Template for {@link ExtensionComplexContent}
     */
    public static final Template XSD_EXTENSION_COMPLEX_CONTENT_TEMPLATE = new Template("<xsd:extension {attributes}>" + LINE_SEPERATOR
        + "{annotation}" + LINE_SEPERATOR
        + "{attribute}" + LINE_SEPERATOR
        + "{attributeGroup}" + LINE_SEPERATOR
        + "{anyAttribute}" + LINE_SEPERATOR
        + "{group}" + LINE_SEPERATOR 
        + "{all}" + LINE_SEPERATOR
        + "{choice}" + LINE_SEPERATOR
        + "{sequence}" + LINE_SEPERATOR
        + "</xsd:extension>");

    /**
     * Template for {@link ExtensionSimpleContent}
     */
    public static final Template XSD_EXTENSION_SIMPLE_CONTENT_TEMPLATE = new Template("<xsd:extension {attributes}>" + LINE_SEPERATOR
        + "{annotation}" + LINE_SEPERATOR
        + "{attribute}" + LINE_SEPERATOR
        + "{attributeGroup}" + LINE_SEPERATOR
        + "{anyAttribute}" + LINE_SEPERATOR
        + "</xsd:extension>");

    /**
     * Template for {@link Field}
     */
    public static final Template XSD_FIELD_TEMPLATE = new Template("<xsd:field {attributes}>" + LINE_SEPERATOR
        + "{annotation}" + LINE_SEPERATOR
        + "</xsd:field>");

    /**
     * Template for {@link Group}
     */
    public static final Template XSD_GROUP_TEMPLATE = new Template("<xsd:group {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR
        + "{all}" + LINE_SEPERATOR 
        + "{choice}" + LINE_SEPERATOR                                           
        + "{sequence}" + LINE_SEPERATOR                                           
        + "</xsd:group>");

    /**
     * Template for {@link Import}
     */
    public static final Template XSD_IMPORT_TEMPLATE = new Template("<xsd:import {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR
        + "</xsd:import>");

    /**
     * Template for {@link Include}
     */
    public static final Template XSD_INCLUDE_TEMPLATE = new Template("<xsd:include {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR
        + "</xsd:include>");

    /**
     * Template for {@link Key}
     */
    public static final Template XSD_KEY_TEMPLATE = new Template("<xsd:key {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR  
        + "{field}" + LINE_SEPERATOR
        + "{selector}" + LINE_SEPERATOR
        + "</xsd:key>");

    /**
     * Template for {@link KeyRef}
     */
    public static final Template XSD_KEY_REF_TEMPLATE = new Template("<xsd:keyref {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR  
        + "</xsd:keyref>");

    /**
     * Template for {@link List}
     */
    public static final Template XSD_LIST_TEMPLATE = new Template("<xsd:list {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{simpleType}" + LINE_SEPERATOR
        + "</xsd:list>");

    /**
     * Template for {@link Notation}
     */
    public static final Template XSD_NOTATION_TEMPLATE = new Template("<xsd:notation {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR                                       
        + "</xsd:notation>");

    /**
     * Template for {@link Redefine}
     */
    public static final Template XSD_REDEFINE_TEMPLATE = new Template("<xsd:redefine {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR
        + "{attributeGroup}" + LINE_SEPERATOR
        + "{complexType}" + LINE_SEPERATOR
        + "{simpleType}" + LINE_SEPERATOR
        + "{group}" + LINE_SEPERATOR                                            
        + "</xsd:redefine>");


    /**
     * Template for {@link RestrictionComplexContent}
     */
    public static final Template XSD_RESTRICTION_COMPLEX_CONTENT_TEMPLATE = new Template("<xsd:restriction {attributes}>" + LINE_SEPERATOR
        + "{annotation}" + LINE_SEPERATOR
        + "{attribute}" + LINE_SEPERATOR
        + "{attributeGroup}" + LINE_SEPERATOR
        + "{anyAttribute}" + LINE_SEPERATOR
        + "{group}" + LINE_SEPERATOR 
        + "{all}" + LINE_SEPERATOR
        + "{choice}" + LINE_SEPERATOR
        + "{sequence}" + LINE_SEPERATOR
        + "</xsd:restriction>");

    /**
     * Template for {@link RestrictionSimpleContent}
     */
    public static final Template XSD_RESTRICTION_SIMPLE_CONTENT_TEMPLATE = new Template("<xsd:restriction {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{simpleType}" + LINE_SEPERATOR
        + "{fractionDigits}" + LINE_SEPERATOR
        + "{enumeration}" + LINE_SEPERATOR
        + "{length}" + LINE_SEPERATOR
        + "{maxExclusive}" + LINE_SEPERATOR
        + "{maxInclusive}" + LINE_SEPERATOR
        + "{maxLength}" + LINE_SEPERATOR
        + "{minExclusive}" + LINE_SEPERATOR
        + "{minInclusive}" + LINE_SEPERATOR
        + "{minLength}" + LINE_SEPERATOR
        + "{pattern}" + LINE_SEPERATOR
        + "{totalDigits}" + LINE_SEPERATOR
        + "{whiteSpace}" + LINE_SEPERATOR
        + "{attribute}" + LINE_SEPERATOR
        + "{attributeGroup}" + LINE_SEPERATOR
        + "{anyAttribute}" + LINE_SEPERATOR
        + "</xsd:restriction>");

    /**
     * Template for {@link RestrictionSimpleType}
     */
    public static final Template XSD_RESTRICTION_SIMPLE_TYPE_TEMPLATE = new Template("<xsd:restriction {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{simpleType}" + LINE_SEPERATOR
        + "{fractionDigits}" + LINE_SEPERATOR
        + "{enumeration}" + LINE_SEPERATOR
        + "{length}" + LINE_SEPERATOR
        + "{maxExclusive}" + LINE_SEPERATOR
        + "{maxInclusive}" + LINE_SEPERATOR
        + "{maxLength}" + LINE_SEPERATOR
        + "{minExclusive}" + LINE_SEPERATOR
        + "{minInclusive}" + LINE_SEPERATOR
        + "{minLength}" + LINE_SEPERATOR
        + "{pattern}" + LINE_SEPERATOR
        + "{totalDigits}" + LINE_SEPERATOR
        + "{whiteSpace}" + LINE_SEPERATOR
        + "</xsd:restriction>");


    /**
    * The template for {@link XSDSchema} class
    */
    public static final Template XSD_SCHEMA_TEMPLATE = new Template("<?xml version='1.0' encoding='UTF-8'?>" + LINE_SEPERATOR 
        + "<xsd:schema xmlns:xsd='http://www.w3.org/2001/XMLSchema' targetNamespace='urn:org:easetech:easytest:schema'"
        + " xmlns:et='urn:org:easetech:easytest:schema' {attributes}>" + LINE_SEPERATOR 
        + "{include}" + LINE_SEPERATOR
        + "{_import}" + LINE_SEPERATOR
        + "{annotation}" + LINE_SEPERATOR
        + "{redefine}" + LINE_SEPERATOR
        + "{attribute}" + LINE_SEPERATOR
        + "{attributeGroup}" + LINE_SEPERATOR
        + "{element}" + LINE_SEPERATOR
        + "{group}" + LINE_SEPERATOR
        + "{notation}" + LINE_SEPERATOR
        + "{simpleType}" + LINE_SEPERATOR
        + "{complexType}"+ LINE_SEPERATOR
        + "</xsd:schema>");


    /**
     * Template for {@link Selector}
     */
    public static final Template XSD_SELECTOR_TEMPLATE = new Template("<xsd:selector {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR
        + "</xsd:selector>");

    /**
     * Template for {@link Sequence}
     */
    public static final Template XSD_SEQUENCE_TEMPLATE = new Template("<xsd:sequence {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{element}" + LINE_SEPERATOR
        + "{choice}" + LINE_SEPERATOR
        + "{sequence}" + LINE_SEPERATOR
        + "{group}" + LINE_SEPERATOR
        + "{any}" + LINE_SEPERATOR
        + "</xsd:sequence>");


    /**
     * Template for {@link SimpleContent} wit hrestriction
     */
    public static final Template XSD_SIMPLE_CONTENT_WITH_RESTRICTION_TEMPLATE = new Template("<xsd:simpleContent {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{restriction}" + LINE_SEPERATOR
        + "</xsd:simpleContent>");

    /**
     * Template for {@link SimpleContent} with Extension 
     */
    public static final Template XSD_SIMPLE_CONTENT = new Template("<xsd:simpleContent {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{extension}" + LINE_SEPERATOR
        + "{restriction}" + LINE_SEPERATOR
        + "</xsd:simpleContent>");

    /**
     * Template for {@link SimpleType}
     */
    public static final Template XSD_SIMPLE_TYPE_TEMPLATE = new Template("<xsd:simpleType {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR  
        + "{restriction}" + LINE_SEPERATOR 
        + "{list}" + LINE_SEPERATOR 
        + "{union}" + LINE_SEPERATOR 
        + "</xsd:simpleType>");


    /**
     * Template for {@link Union}
     */
    public static final Template XSD_UNION_TEMPLATE = new Template("<xsd:union {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR 
        + "{simpleType}" + LINE_SEPERATOR
        + "</xsd:union>");

    /**
     * Template for {@link Unique}
     */
    public static final Template XSD_UNIQUE_TEMPLATE = new Template("<xsd:unique {attributes}>" + LINE_SEPERATOR 
        + "{annotation}" + LINE_SEPERATOR  
        + "</xsd:unique>"); 
    
    /**
     * Replace all occurrences of a substring within a string with
     * another string.
     * @param oldPattern String to replace
     * @param withTemplate {@link Template} to insert
     * @return a Template with the replacements
     */
    public Template replace(String oldPattern, Template withTemplate) {
        if (!hasLength(templateText) || !hasLength(oldPattern) || withTemplate == null) {
            return this;
        }
        StringBuilder sb = new StringBuilder();
        int pos = 0; // our position in the old string
        int index = templateText.indexOf(oldPattern);
        // the index of an occurrence we've found, or -1
        int patLen = oldPattern.length();
        while (index >= 0) {
            sb.append(templateText.substring(pos, index));
            sb.append(withTemplate.getTemplateText());
            pos = index + patLen;
            index = templateText.indexOf(oldPattern, pos);
        }
        sb.append(templateText.substring(pos));
        // remember to append any characters to the right of a match
        return new Template(sb.toString());
    }
    
    /**
     * Create a template by replacing the oldPattern within the template string
     * @param oldPattern pattern to replace
     * @param withTemplate within template
     * @return template instance with the modified template text
     */
    public Template replace(String oldPattern, String withTemplate) {
        if (!hasLength(templateText) || !hasLength(oldPattern) || withTemplate == null) {
            return this;
        }
        StringBuilder sb = new StringBuilder();
        int pos = 0; // our position in the old string
        int index = templateText.indexOf(oldPattern);
        // the index of an occurrence we've found, or -1
        int patLen = oldPattern.length();
        while (index >= 0) {
            sb = sb.append(templateText.substring(pos, index));
            sb = sb.append(withTemplate);
            pos = index + patLen;
            index = templateText.indexOf(oldPattern, pos);
        }
        sb = sb.append(templateText.substring(pos));
        // remember to append any characters to the right of a match
        return new Template(sb.toString());
    }
    
    /**
     * Check that the given CharSequence is neither <code>null</code> nor of length 0.
     * Note: Will return <code>true</code> for a CharSequence that purely consists of whitespace.
     * <p><pre>
     * StringUtils.hasLength(null) = false
     * StringUtils.hasLength("") = false
     * StringUtils.hasLength(" ") = true
     * StringUtils.hasLength("Hello") = true
     * </pre>
     * @param str the CharSequence to check (may be <code>null</code>)
     * @return <code>true</code> if the CharSequence is not null and has length
     */
    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }
    
    public static java.util.List<String> getPlaceHolders(Template template) {
        java.util.List<String> results = new ArrayList<String>();
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(template.getTemplateText());
        while(matcher.find()) {
            results.add(matcher.group());
        }
        results.remove(ATTRIBUTE_PLACEHOLDER);
        return results;
    }


    /**
     * @return
     */
    @Override
    public String toString() {
        return getTemplateText();
    }
    

}
