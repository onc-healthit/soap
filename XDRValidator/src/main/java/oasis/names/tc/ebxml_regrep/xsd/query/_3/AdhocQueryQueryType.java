//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.18 at 10:59:00 AM EST 
//


package oasis.names.tc.ebxml_regrep.xsd.query._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdhocQueryQueryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdhocQueryQueryType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}RegistryObjectQueryType">
 *       &lt;sequence>
 *         &lt;element name="QueryExpressionBranch" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0}QueryExpressionBranchType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdhocQueryQueryType", propOrder = {
    "queryExpressionBranch"
})
public class AdhocQueryQueryType
    extends RegistryObjectQueryType
{

    @XmlElement(name = "QueryExpressionBranch")
    protected QueryExpressionBranchType queryExpressionBranch;

    /**
     * Gets the value of the queryExpressionBranch property.
     * 
     * @return
     *     possible object is
     *     {@link QueryExpressionBranchType }
     *     
     */
    public QueryExpressionBranchType getQueryExpressionBranch() {
        return queryExpressionBranch;
    }

    /**
     * Sets the value of the queryExpressionBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryExpressionBranchType }
     *     
     */
    public void setQueryExpressionBranch(QueryExpressionBranchType value) {
        this.queryExpressionBranch = value;
    }

}
