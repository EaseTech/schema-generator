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
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for complexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="complexType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annotation" type="{urn:org:easetech:easytest:schema}annotation" minOccurs="0"/>
 *         &lt;element name="simpleContent" type="{urn:org:easetech:easytest:schema}simpleContent" minOccurs="0"/>
 *         &lt;element name="complexContent" type="{urn:org:easetech:easytest:schema}complexContent" minOccurs="0"/>
 *         &lt;element name="group" type="{urn:org:easetech:easytest:schema}group" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="all" type="{urn:org:easetech:easytest:schema}all" minOccurs="0"/>
 *         &lt;element name="choice" type="{urn:org:easetech:easytest:schema}choice" minOccurs="0"/>
 *         &lt;element name="sequence" type="{urn:org:easetech:easytest:schema}sequence" minOccurs="0"/>
 *         &lt;element name="attribute" type="{urn:org:easetech:easytest:schema}attribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attributeGroup" type="{urn:org:easetech:easytest:schema}attributeGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="anyAttribute" type="{urn:org:easetech:easytest:schema}anyAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="abstract" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="block" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="final" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mixed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "complexType", propOrder = {
    "annotation",
    "simpleContent",
    "complexContent",
    "group",
    "all",
    "choice",
    "sequence",
    "attribute",
    "attributeGroup",
    "anyAttribute"
})
public class ComplexType {

    protected Annotation annotation;
    protected SimpleContent simpleContent;
    protected ComplexContent complexContent;
    protected List<Group> group;
    protected All all;
    protected Choice choice;
    protected Sequence sequence;
    protected List<Attribute> attribute;
    protected List<AttributeGroup> attributeGroup;
    protected List<AnyAttribute> anyAttribute;
    @XmlAttribute(name = "abstract")
    protected Boolean _abstract;
    @XmlAttribute(name = "block")
    protected String block;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "final")
    protected String _final;
    @XmlAttribute(name = "mixed")
    protected Boolean mixed;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;

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
     * Gets the value of the simpleContent property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleContent }
     *     
     */
    public SimpleContent getSimpleContent() {
        return simpleContent;
    }

    /**
     * Sets the value of the simpleContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleContent }
     *     
     */
    public void setSimpleContent(SimpleContent value) {
        this.simpleContent = value;
    }

    /**
     * Gets the value of the complexContent property.
     * 
     * @return
     *     possible object is
     *     {@link ComplexContent }
     *     
     */
    public ComplexContent getComplexContent() {
        return complexContent;
    }

    /**
     * Sets the value of the complexContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplexContent }
     *     
     */
    public void setComplexContent(ComplexContent value) {
        this.complexContent = value;
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
     * Gets the value of the all property.
     * 
     * @return
     *     possible object is
     *     {@link All }
     *     
     */
    public All getAll() {
        return all;
    }

    /**
     * Sets the value of the all property.
     * 
     * @param value
     *     allowed object is
     *     {@link All }
     *     
     */
    public void setAll(All value) {
        this.all = value;
    }

    /**
     * Gets the value of the choice property.
     * 
     * @return
     *     possible object is
     *     {@link Choice }
     *     
     */
    public Choice getChoice() {
        return choice;
    }

    /**
     * Sets the value of the choice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Choice }
     *     
     */
    public void setChoice(Choice value) {
        this.choice = value;
    }

    /**
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link Sequence }
     *     
     */
    public Sequence getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sequence }
     *     
     */
    public void setSequence(Sequence value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attribute }
     * 
     * 
     */
    public List<Attribute> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<Attribute>();
        }
        return this.attribute;
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
     * Gets the value of the anyAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anyAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnyAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnyAttribute }
     * 
     * 
     */
    public List<AnyAttribute> getAnyAttribute() {
        if (anyAttribute == null) {
            anyAttribute = new ArrayList<AnyAttribute>();
        }
        return this.anyAttribute;
    }

    /**
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAbstract() {
        if (_abstract == null) {
            return false;
        } else {
            return _abstract;
        }
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAbstract(Boolean value) {
        this._abstract = value;
    }

    /**
     * Gets the value of the block property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlock() {
        return block;
    }

    /**
     * Sets the value of the block property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlock(String value) {
        this.block = value;
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
     * Gets the value of the final property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinal() {
        return _final;
    }

    /**
     * Sets the value of the final property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinal(String value) {
        this._final = value;
    }

    /**
     * Gets the value of the mixed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMixed() {
        if (mixed == null) {
            return false;
        } else {
            return mixed;
        }
    }

    /**
     * Sets the value of the mixed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMixed(Boolean value) {
        this.mixed = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}