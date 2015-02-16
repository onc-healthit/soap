//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.16 at 12:17:07 PM EST 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IVL_REAL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IVL_REAL">
 *   &lt;complexContent>
 *     &lt;extension base="{}SXCM_REAL">
 *       &lt;choice minOccurs="0">
 *         &lt;sequence>
 *           &lt;element name="low" type="{}IVXB_REAL"/>
 *           &lt;choice minOccurs="0">
 *             &lt;element name="width" type="{}REAL" minOccurs="0"/>
 *             &lt;element name="high" type="{}IVXB_REAL" minOccurs="0"/>
 *           &lt;/choice>
 *         &lt;/sequence>
 *         &lt;element name="high" type="{}IVXB_REAL"/>
 *         &lt;sequence>
 *           &lt;element name="width" type="{}REAL"/>
 *           &lt;element name="high" type="{}IVXB_REAL" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="center" type="{}REAL"/>
 *           &lt;element name="width" type="{}REAL" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IVL_REAL", propOrder = {
    "rest"
})
public class IVLREAL
    extends SXCMREAL
{

    @XmlElementRefs({
        @XmlElementRef(name = "low", type = JAXBElement.class),
        @XmlElementRef(name = "high", type = JAXBElement.class),
        @XmlElementRef(name = "center", type = JAXBElement.class),
        @XmlElementRef(name = "width", type = JAXBElement.class)
    })
    protected List<JAXBElement<? extends REAL>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "High" is used by two different parts of a schema. See: 
     * line 900 of file:/C:/DEV/Drajer/soap/XDRValidator/src/main/webapp/schemas/HL7V3/NE2008/coreschemas/datatypes.xsd
     * line 891 of file:/C:/DEV/Drajer/soap/XDRValidator/src/main/webapp/schemas/HL7V3/NE2008/coreschemas/datatypes.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link IVXBREAL }{@code >}
     * {@link JAXBElement }{@code <}{@link REAL }{@code >}
     * {@link JAXBElement }{@code <}{@link REAL }{@code >}
     * {@link JAXBElement }{@code <}{@link IVXBREAL }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends REAL>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<? extends REAL>>();
        }
        return this.rest;
    }

}
