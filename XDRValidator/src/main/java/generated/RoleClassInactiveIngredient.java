//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.18 at 10:59:00 AM EST 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassInactiveIngredient.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassInactiveIngredient">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="IACT"/>
 *     &lt;enumeration value="COLR"/>
 *     &lt;enumeration value="FLVR"/>
 *     &lt;enumeration value="PRSV"/>
 *     &lt;enumeration value="STBL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassInactiveIngredient")
@XmlEnum
public enum RoleClassInactiveIngredient {

    IACT,
    COLR,
    FLVR,
    PRSV,
    STBL;

    public String value() {
        return name();
    }

    public static RoleClassInactiveIngredient fromValue(String v) {
        return valueOf(v);
    }

}
