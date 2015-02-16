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
 * <p>Java class for ActInvoiceDetailGenericProviderCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInvoiceDetailGenericProviderCode">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CANCAPT"/>
 *     &lt;enumeration value="DSC"/>
 *     &lt;enumeration value="ESA"/>
 *     &lt;enumeration value="FFSTOP"/>
 *     &lt;enumeration value="FNLFEE"/>
 *     &lt;enumeration value="FRSTFEE"/>
 *     &lt;enumeration value="MARKUP"/>
 *     &lt;enumeration value="MISSAPT"/>
 *     &lt;enumeration value="PERMBNS"/>
 *     &lt;enumeration value="PERFEE"/>
 *     &lt;enumeration value="RESTOCK"/>
 *     &lt;enumeration value="TRAVEL"/>
 *     &lt;enumeration value="URGENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActInvoiceDetailGenericProviderCode")
@XmlEnum
public enum ActInvoiceDetailGenericProviderCode {

    CANCAPT,
    DSC,
    ESA,
    FFSTOP,
    FNLFEE,
    FRSTFEE,
    MARKUP,
    MISSAPT,
    PERMBNS,
    PERFEE,
    RESTOCK,
    TRAVEL,
    URGENT;

    public String value() {
        return name();
    }

    public static ActInvoiceDetailGenericProviderCode fromValue(String v) {
        return valueOf(v);
    }

}
