//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.16 at 12:17:07 PM EST 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_RoleClassCredentialedEntity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_RoleClassCredentialedEntity">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="ASSIGNED"/>
 *     &lt;enumeration value="QUAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "x_RoleClassCredentialedEntity")
@XmlEnum
public enum XRoleClassCredentialedEntity {

    ASSIGNED,
    QUAL;

    public String value() {
        return name();
    }

    public static XRoleClassCredentialedEntity fromValue(String v) {
        return valueOf(v);
    }

}
