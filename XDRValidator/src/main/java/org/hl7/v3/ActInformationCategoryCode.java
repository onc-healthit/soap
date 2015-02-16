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
 * <p>Java class for ActInformationCategoryCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInformationCategoryCode">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ALLGCAT"/>
 *     &lt;enumeration value="COBSCAT"/>
 *     &lt;enumeration value="DEMOCAT"/>
 *     &lt;enumeration value="DICAT"/>
 *     &lt;enumeration value="IMMUCAT"/>
 *     &lt;enumeration value="LABCAT"/>
 *     &lt;enumeration value="MEDCCAT"/>
 *     &lt;enumeration value="RXCAT"/>
 *     &lt;enumeration value="PSVCCAT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActInformationCategoryCode")
@XmlEnum
public enum ActInformationCategoryCode {

    ALLGCAT,
    COBSCAT,
    DEMOCAT,
    DICAT,
    IMMUCAT,
    LABCAT,
    MEDCCAT,
    RXCAT,
    PSVCCAT;

    public String value() {
        return name();
    }

    public static ActInformationCategoryCode fromValue(String v) {
        return valueOf(v);
    }

}
