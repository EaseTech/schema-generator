package org.easetech.schemagenerator;

import org.easetech.schema.UseValues;

import java.math.BigInteger;

import org.easetech.schema.Sequence;

import org.easetech.schema.Attribute;

import org.easetech.schema.ComplexType;

import javax.xml.namespace.QName;

import org.easetech.schema.Element;

public final class XSDUtil {
    
    private static final String PREFIX = "et:";
    
    public static Element generateElement(String name , String type) {
        Element rootElement = new Element();
        rootElement.setName(name);
        rootElement.setType(new QName(null, type == null ? PREFIX.concat(name) : PREFIX.concat(type), PREFIX));
        return rootElement; 
    }
    
    public static ComplexType generateComplexType(String name, Element... elements) {
        ComplexType complexType = new ComplexType();
        complexType.setName(name);
        return addElementToComplexType(complexType, elements);
    }
    
    public static ComplexType generateComplexType(QName name, Element... elements) {
        ComplexType complexType = new ComplexType();
        complexType.setName(name.getLocalPart());
        return addElementToComplexType(complexType, elements);
    }
    
    public static ComplexType addElementToComplexType(ComplexType complexType, Element... elements) {

        Sequence sequence = new Sequence();
        for( Element element : elements) {
            sequence.getElement().add(element);
        }        
        complexType.setSequence(sequence);
        return complexType;
    }
    
    public static void addAttributesToComplexType(ComplexType type , Attribute... attributes) {
        
        for(Attribute attribute : attributes) {
            type.getAttribute().add(attribute);
        }
    }
    
    public static void addAttributesToElement(Element element , Attribute... attributes) {       
        for(Attribute attribute : attributes) {
            if(element.getComplexType() == null) {
                element.setComplexType(new ComplexType());
            } 
            element.getComplexType().getAttribute().add(attribute);
        }
    }
    
    public static Attribute getAttribute(String name , QName type , UseValues use, String _default) {
        Attribute attribute = new Attribute();
        attribute.setName(name);
        attribute.setType(type);
        attribute.setUse(use);
        attribute.setDefault(_default);
        return attribute;
    }
    
    
   public static Element generateElement(String name, String type , String minOccurs , String maxOccurs) {
       Element element = generateElement(name, type);
       element.setMinOccurs(new BigInteger(minOccurs));
       element.setMaxOccurs(maxOccurs);
       return element;    
   }

}
