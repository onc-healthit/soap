//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.26 at 08:48:51 AM EDT 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeNonParametricProbabilityDistribution.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeNonParametricProbabilityDistribution">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="NPPD&lt;ANY>"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DataTypeNonParametricProbabilityDistribution")
@XmlEnum
public enum DataTypeNonParametricProbabilityDistribution {

    @XmlEnumValue("NPPD<ANY>")
    NPPD_ANY("NPPD<ANY>");
    private final String value;

    DataTypeNonParametricProbabilityDistribution(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataTypeNonParametricProbabilityDistribution fromValue(String v) {
        for (DataTypeNonParametricProbabilityDistribution c: DataTypeNonParametricProbabilityDistribution.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
