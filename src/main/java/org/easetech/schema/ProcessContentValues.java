//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.28 at 02:40:28 PM CEST 
//


package org.easetech.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessContentValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProcessContentValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="lax"/>
 *     &lt;enumeration value="skip"/>
 *     &lt;enumeration value="strict"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProcessContentValues")
@XmlEnum
public enum ProcessContentValues {

    @XmlEnumValue("lax")
    LAX("lax"),
    @XmlEnumValue("skip")
    SKIP("skip"),
    @XmlEnumValue("strict")
    STRICT("strict");
    private final String value;

    ProcessContentValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProcessContentValues fromValue(String v) {
        for (ProcessContentValues c: ProcessContentValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
