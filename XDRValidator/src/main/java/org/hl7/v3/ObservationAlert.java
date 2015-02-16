//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.16 at 12:17:07 PM EST 
//


package org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationAlert.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationAlert">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="OBSA"/>
 *     &lt;enumeration value="AGE"/>
 *     &lt;enumeration value="COND"/>
 *     &lt;enumeration value="GEND"/>
 *     &lt;enumeration value="GEN"/>
 *     &lt;enumeration value="LAB"/>
 *     &lt;enumeration value="REACT"/>
 *     &lt;enumeration value="RREACT"/>
 *     &lt;enumeration value="CREACT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ObservationAlert")
@XmlEnum
public enum ObservationAlert {

    OBSA,
    AGE,
    COND,
    GEND,
    GEN,
    LAB,
    REACT,
    RREACT,
    CREACT;

    public String value() {
        return name();
    }

    public static ObservationAlert fromValue(String v) {
        return valueOf(v);
    }

}
