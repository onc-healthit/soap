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
 * <p>Java class for LocalRemoteControlState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LocalRemoteControlState">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="L"/>
 *     &lt;enumeration value="R"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LocalRemoteControlState")
@XmlEnum
public enum LocalRemoteControlState {

    L,
    R;

    public String value() {
        return name();
    }

    public static LocalRemoteControlState fromValue(String v) {
        return valueOf(v);
    }

}
