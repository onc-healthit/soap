//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.26 at 08:48:51 AM EDT 
//


package org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NorthernCaddoan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NorthernCaddoan">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="x-ARI"/>
 *     &lt;enumeration value="x-PAW"/>
 *     &lt;enumeration value="x-WIC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NorthernCaddoan")
@XmlEnum
public enum NorthernCaddoan {

    @XmlEnumValue("x-ARI")
    X_ARI("x-ARI"),
    @XmlEnumValue("x-PAW")
    X_PAW("x-PAW"),
    @XmlEnumValue("x-WIC")
    X_WIC("x-WIC");
    private final String value;

    NorthernCaddoan(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NorthernCaddoan fromValue(String v) {
        for (NorthernCaddoan c: NorthernCaddoan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
