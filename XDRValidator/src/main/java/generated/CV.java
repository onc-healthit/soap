//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.16 at 12:17:07 PM EST 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Coded data, consists of a code, display name, code system,
 *             and original text. Used when a single code value must be sent.
 *          
 * 
 * <p>Java class for CV complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CV">
 *   &lt;complexContent>
 *     &lt;restriction base="{}CE">
 *       &lt;sequence>
 *         &lt;element name="originalText" type="{}ED" minOccurs="0"/>
 *         &lt;element name="translation" type="{}CD" maxOccurs="0" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="code" type="{}cs" />
 *       &lt;attribute name="codeSystem" type="{}uid" />
 *       &lt;attribute name="codeSystemName" type="{}st" />
 *       &lt;attribute name="codeSystemVersion" type="{}st" />
 *       &lt;attribute name="displayName" type="{}st" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CV")
@XmlSeeAlso({
    PQR.class,
    CS.class,
    CO.class
})
public class CV
    extends CE
{


}
