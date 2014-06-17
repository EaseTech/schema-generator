//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.28 at 02:40:28 PM CEST 
//


package org.easetech.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for schema complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="schema">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="include" type="{urn:org:easetech:easytest:schema}include" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="import" type="{urn:org:easetech:easytest:schema}import" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="annotation" type="{urn:org:easetech:easytest:schema}annotation" minOccurs="0"/>
 *         &lt;element name="redefine" type="{urn:org:easetech:easytest:schema}redefine" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attribute" type="{urn:org:easetech:easytest:schema}attribute" minOccurs="0"/>
 *         &lt;element name="attributeGroup" type="{urn:org:easetech:easytest:schema}attributeGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="element" type="{urn:org:easetech:easytest:schema}element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="group" type="{urn:org:easetech:easytest:schema}group" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="notation" type="{urn:org:easetech:easytest:schema}notation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="simpleType" type="{urn:org:easetech:easytest:schema}simpleType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="complexType" type="{urn:org:easetech:easytest:schema}complexType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="attributeFormDefault" type="{urn:org:easetech:easytest:schema}AttributeFormDefaultValues" default="unqualified" />
 *       &lt;attribute name="blockDefault" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="elementFormDefault" type="{urn:org:easetech:easytest:schema}AttributeFormDefaultValues" />
 *       &lt;attribute name="finalDefault" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="targetNamespace" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="xml-lang" type="{http://www.w3.org/2001/XMLSchema}language" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "schema", propOrder = {
    "include",
    "_import",
    "annotation",
    "redefine",
    "attribute",
    "attributeGroup",
    "element",
    "group",
    "notation",
    "simpleType",
    "complexType"
})
public class Schema {

    protected List<Include> include;
    @XmlElement(name = "import")
    protected List<Import> _import;
    protected Annotation annotation;
    protected List<Redefine> redefine;
    protected Attribute attribute;
    protected List<AttributeGroup> attributeGroup;
    protected List<Element> element;
    protected List<Group> group;
    protected List<Notation> notation;
    protected List<SimpleType> simpleType;
    protected List<ComplexType> complexType;
    @XmlAttribute(name = "attributeFormDefault")
    protected AttributeFormDefaultValues attributeFormDefault;
    @XmlAttribute(name = "blockDefault")
    protected String blockDefault;
    @XmlAttribute(name = "elementFormDefault")
    protected AttributeFormDefaultValues elementFormDefault;
    @XmlAttribute(name = "finalDefault")
    protected String finalDefault;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "targetNamespace")
    @XmlSchemaType(name = "anyURI")
    protected String targetNamespace;
    @XmlAttribute(name = "version")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String version;
    @XmlAttribute(name = "xml:lang")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String xmlLang;

    /**
     * Gets the value of the include property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the include property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInclude().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Include }
     * 
     * 
     */
    public List<Include> getInclude() {
        if (include == null) {
            include = new ArrayList<Include>();
        }
        return this.include;
    }

    /**
     * Gets the value of the import property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the import property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Import }
     * 
     * 
     */
    public List<Import> getImport() {
        if (_import == null) {
            _import = new ArrayList<Import>();
        }
        return this._import;
    }

    /**
     * Gets the value of the annotation property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation }
     *     
     */
    public Annotation getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation }
     *     
     */
    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    /**
     * Gets the value of the redefine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the redefine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRedefine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Redefine }
     * 
     * 
     */
    public List<Redefine> getRedefine() {
        if (redefine == null) {
            redefine = new ArrayList<Redefine>();
        }
        return this.redefine;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * @return
     *     possible object is
     *     {@link Attribute }
     *     
     */
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * Sets the value of the attribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link Attribute }
     *     
     */
    public void setAttribute(Attribute value) {
        this.attribute = value;
    }

    /**
     * Gets the value of the attributeGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeGroup }
     * 
     * 
     */
    public List<AttributeGroup> getAttributeGroup() {
        if (attributeGroup == null) {
            attributeGroup = new ArrayList<AttributeGroup>();
        }
        return this.attributeGroup;
    }

    /**
     * Gets the value of the element property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the element property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<Element> getElement() {
        if (element == null) {
            element = new ArrayList<Element>();
        }
        return this.element;
    }

    /**
     * Gets the value of the group property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the group property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Group }
     * 
     * 
     */
    public List<Group> getGroup() {
        if (group == null) {
            group = new ArrayList<Group>();
        }
        return this.group;
    }

    /**
     * Gets the value of the notation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Notation }
     * 
     * 
     */
    public List<Notation> getNotation() {
        if (notation == null) {
            notation = new ArrayList<Notation>();
        }
        return this.notation;
    }

    /**
     * Gets the value of the simpleType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simpleType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimpleType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleType }
     * 
     * 
     */
    public List<SimpleType> getSimpleType() {
        if (simpleType == null) {
            simpleType = new ArrayList<SimpleType>();
        }
        return this.simpleType;
    }

    /**
     * Gets the value of the complexType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complexType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplexType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComplexType }
     * 
     * 
     */
    public List<ComplexType> getComplexType() {
        if (complexType == null) {
            complexType = new ArrayList<ComplexType>();
        }
        return this.complexType;
    }

    /**
     * Gets the value of the attributeFormDefault property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeFormDefaultValues }
     *     
     */
    public AttributeFormDefaultValues getAttributeFormDefault() {
        if (attributeFormDefault == null) {
            return AttributeFormDefaultValues.UNQUALIFIED;
        } else {
            return attributeFormDefault;
        }
    }

    /**
     * Sets the value of the attributeFormDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeFormDefaultValues }
     *     
     */
    public void setAttributeFormDefault(AttributeFormDefaultValues value) {
        this.attributeFormDefault = value;
    }

    /**
     * Gets the value of the blockDefault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockDefault() {
        return blockDefault;
    }

    /**
     * Sets the value of the blockDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockDefault(String value) {
        this.blockDefault = value;
    }

    /**
     * Gets the value of the elementFormDefault property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeFormDefaultValues }
     *     
     */
    public AttributeFormDefaultValues getElementFormDefault() {
        return elementFormDefault;
    }

    /**
     * Sets the value of the elementFormDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeFormDefaultValues }
     *     
     */
    public void setElementFormDefault(AttributeFormDefaultValues value) {
        this.elementFormDefault = value;
    }

    /**
     * Gets the value of the finalDefault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalDefault() {
        return finalDefault;
    }

    /**
     * Sets the value of the finalDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalDefault(String value) {
        this.finalDefault = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the targetNamespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetNamespace() {
        return targetNamespace;
    }

    /**
     * Sets the value of the targetNamespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetNamespace(String value) {
        this.targetNamespace = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the xmlLang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlLang() {
        return xmlLang;
    }

    /**
     * Sets the value of the xmlLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlLang(String value) {
        this.xmlLang = value;
    }

}