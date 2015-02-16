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
 * <p>Java class for TransdermalPatch.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransdermalPatch">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="TPATCH"/>
 *     &lt;enumeration value="TPATH16"/>
 *     &lt;enumeration value="TPATH24"/>
 *     &lt;enumeration value="TPATH72"/>
 *     &lt;enumeration value="TPATH2WK"/>
 *     &lt;enumeration value="TPATHWK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransdermalPatch")
@XmlEnum
public enum TransdermalPatch {

    TPATCH("TPATCH"),
    @XmlEnumValue("TPATH16")
    TPATH_16("TPATH16"),
    @XmlEnumValue("TPATH24")
    TPATH_24("TPATH24"),
    @XmlEnumValue("TPATH72")
    TPATH_72("TPATH72"),
    @XmlEnumValue("TPATH2WK")
    TPATH_2_WK("TPATH2WK"),
    TPATHWK("TPATHWK");
    private final String value;

    TransdermalPatch(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransdermalPatch fromValue(String v) {
        for (TransdermalPatch c: TransdermalPatch.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
