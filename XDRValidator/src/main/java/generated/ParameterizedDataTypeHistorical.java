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
 * <p>Java class for ParameterizedDataTypeHistorical.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParameterizedDataTypeHistorical">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="HXIT&lt;T>"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParameterizedDataTypeHistorical")
@XmlEnum
public enum ParameterizedDataTypeHistorical {

    @XmlEnumValue("HXIT<T>")
    HXIT_T("HXIT<T>");
    private final String value;

    ParameterizedDataTypeHistorical(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParameterizedDataTypeHistorical fromValue(String v) {
        for (ParameterizedDataTypeHistorical c: ParameterizedDataTypeHistorical.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
