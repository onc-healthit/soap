//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.18 at 10:59:00 AM EST 
//


package org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="NPPD&lt;IVL&lt;PQ>>"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities")
@XmlEnum
public enum DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities {

    @XmlEnumValue("NPPD<IVL<PQ>>")
    NPPD_IVL_PQ("NPPD<IVL<PQ>>");
    private final String value;

    DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities fromValue(String v) {
        for (DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities c: DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
