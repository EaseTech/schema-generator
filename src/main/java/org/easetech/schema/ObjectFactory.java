//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.28 at 02:40:28 PM CEST 
//


package org.easetech.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.easetech.easytest.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Schema_QNAME = new QName("urn:org:easetech:easytest:schema", "schema");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.easetech.easytest.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Schema }
     * 
     */
    public Schema createSchema() {
        return new Schema();
    }

    /**
     * Create an instance of {@link Selector }
     * 
     */
    public Selector createSelector() {
        return new Selector();
    }

    /**
     * Create an instance of {@link ComplexType }
     * 
     */
    public ComplexType createComplexType() {
        return new ComplexType();
    }

    /**
     * Create an instance of {@link Unique }
     * 
     */
    public Unique createUnique() {
        return new Unique();
    }

    /**
     * Create an instance of {@link ExtensionSimpleContent }
     * 
     */
    public ExtensionSimpleContent createExtensionSimpleContent() {
        return new ExtensionSimpleContent();
    }

    /**
     * Create an instance of {@link AppInfo }
     * 
     */
    public AppInfo createAppInfo() {
        return new AppInfo();
    }

    /**
     * Create an instance of {@link Choice }
     * 
     */
    public Choice createChoice() {
        return new Choice();
    }

    /**
     * Create an instance of {@link ComplexContent }
     * 
     */
    public ComplexContent createComplexContent() {
        return new ComplexContent();
    }

    /**
     * Create an instance of {@link Attribute }
     * 
     */
    public Attribute createAttribute() {
        return new Attribute();
    }

    /**
     * Create an instance of {@link AnyAttribute }
     * 
     */
    public AnyAttribute createAnyAttribute() {
        return new AnyAttribute();
    }

    /**
     * Create an instance of {@link RestrictionSimpleContent }
     * 
     */
    public RestrictionSimpleContent createRestrictionSimpleContent() {
        return new RestrictionSimpleContent();
    }

    /**
     * Create an instance of {@link Annotation }
     * 
     */
    public Annotation createAnnotation() {
        return new Annotation();
    }

    /**
     * Create an instance of {@link KeyRef }
     * 
     */
    public KeyRef createKeyRef() {
        return new KeyRef();
    }

    /**
     * Create an instance of {@link Any }
     * 
     */
    public Any createAny() {
        return new Any();
    }

    /**
     * Create an instance of {@link Union }
     * 
     */
    public Union createUnion() {
        return new Union();
    }

    /**
     * Create an instance of {@link RestrictionComplexContent }
     * 
     */
    public RestrictionComplexContent createRestrictionComplexContent() {
        return new RestrictionComplexContent();
    }

    /**
     * Create an instance of {@link Import }
     * 
     */
    public Import createImport() {
        return new Import();
    }

    /**
     * Create an instance of {@link AttributeGroup }
     * 
     */
    public AttributeGroup createAttributeGroup() {
        return new AttributeGroup();
    }

    /**
     * Create an instance of {@link Notation }
     * 
     */
    public Notation createNotation() {
        return new Notation();
    }

    /**
     * Create an instance of {@link Key }
     * 
     */
    public Key createKey() {
        return new Key();
    }

    /**
     * Create an instance of {@link All }
     * 
     */
    public All createAll() {
        return new All();
    }

    /**
     * Create an instance of {@link Redefine }
     * 
     */
    public Redefine createRedefine() {
        return new Redefine();
    }

    /**
     * Create an instance of {@link Element }
     * 
     */
    public Element createElement() {
        return new Element();
    }

    /**
     * Create an instance of {@link List }
     * 
     */
    public List createList() {
        return new List();
    }

    /**
     * Create an instance of {@link RestrictionSimpleType }
     * 
     */
    public RestrictionSimpleType createRestrictionSimpleType() {
        return new RestrictionSimpleType();
    }

    /**
     * Create an instance of {@link SimpleContent }
     * 
     */
    public SimpleContent createSimpleContent() {
        return new SimpleContent();
    }

    /**
     * Create an instance of {@link Include }
     * 
     */
    public Include createInclude() {
        return new Include();
    }

    /**
     * Create an instance of {@link Field }
     * 
     */
    public Field createField() {
        return new Field();
    }

    /**
     * Create an instance of {@link ExtensionComplexContent }
     * 
     */
    public ExtensionComplexContent createExtensionComplexContent() {
        return new ExtensionComplexContent();
    }

    /**
     * Create an instance of {@link Sequence }
     * 
     */
    public Sequence createSequence() {
        return new Sequence();
    }

    /**
     * Create an instance of {@link SimpleType }
     * 
     */
    public SimpleType createSimpleType() {
        return new SimpleType();
    }

    /**
     * Create an instance of {@link Documentation }
     * 
     */
    public Documentation createDocumentation() {
        return new Documentation();
    }

    /**
     * Create an instance of {@link Group }
     * 
     */
    public Group createGroup() {
        return new Group();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Schema }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:org:easetech:easytest:schema", name = "schema")
    public JAXBElement<Schema> createSchema(Schema value) {
        return new JAXBElement<Schema>(_Schema_QNAME, Schema.class, null, value);
    }

}
