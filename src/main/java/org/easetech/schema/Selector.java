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
import javax.xml.namespace.QName;


/**
 * <p>Java class for selector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="selector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annotation" type="{urn:org:easetech:easytest:schema}annotation" minOccurs="0"/>
 *         &lt;element name="attribute" type="{urn:org:easetech:easytest:schema}attribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attributeGroup" type="{urn:org:easetech:easytest:schema}attributeGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="anyAttribute" type="{urn:org:easetech:easytest:schema}anyAttribute" minOccurs="0"/>
 *         &lt;element name="group" type="{urn:org:easetech:easytest:schema}group" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="all" type="{urn:org:easetech:easytest:schema}all" minOccurs="0"/>
 *         &lt;element name="choice" type="{urn:org:easetech:easytest:schema}choice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sequence" type="{urn:org:easetech:easytest:schema}sequence" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="base" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "selector", propOrder = {
    "annotation",
    "attribute",
    "attributeGroup",
    "anyAttribute",
    "group",
    "all",
    "choice",
    "sequence"
})
public class Selector {

    protected Annotation annotation;
    protected List<Attribute> attribute;
    protected List<AttributeGroup> attributeGroup;
    protected AnyAttribute anyAttribute;
    protected List<Group> group;
    protected All all;
    protected List<Choice> choice;
    protected List<Sequence> sequence;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "base", required = true)
    protected QName base;

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
     * @return
     *     possible object is
     *     {@link AnyAttribute }
     *     
     */
    public AnyAttribute getAnyAttribute() {
        return anyAttribute;
    }

    /**
     * Sets the value of the anyAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyAttribute }
     *     
     */
    public void setAnyAttribute(AnyAttribute value) {
        this.anyAttribute = value;
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the choice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChoice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Choice }
     * 
     * 
     */
    public List<Choice> getChoice() {
        if (choice == null) {
            choice = new ArrayList<Choice>();
        }
        return this.choice;
    }

    /**
     * Gets the value of the sequence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sequence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSequence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sequence }
     * 
     * 
     */
    public List<Sequence> getSequence() {
        if (sequence == null) {
            sequence = new ArrayList<Sequence>();
        }
        return this.sequence;
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
     * Gets the value of the base property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getBase() {
        return base;
    }

    /**
     * Sets the value of the base property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setBase(QName value) {
        this.base = value;
    }

}
