//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.18 at 10:59:00 AM EST 
//


package org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfidentialityByAccessKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConfidentialityByAccessKind">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="L"/>
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="V"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConfidentialityByAccessKind")
@XmlEnum
public enum ConfidentialityByAccessKind {

    B,
    D,
    I,
    L,
    N,
    R,
    V;

    public String value() {
        return name();
    }

    public static ConfidentialityByAccessKind fromValue(String v) {
        return valueOf(v);
    }

}
