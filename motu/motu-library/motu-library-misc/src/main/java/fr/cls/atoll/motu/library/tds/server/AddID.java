//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3268 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.03.25 at 11:44:51 AM CET 
//


package fr.cls.atoll.motu.library.tds.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addID element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="addID">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="crawlableDatasetLabelerImpl" type="{http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0}UserImplType" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "crawlableDatasetLabelerImpl"
})
@XmlRootElement(name = "addID")
public class AddID {

    @XmlElement(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0")
    protected UserImplType crawlableDatasetLabelerImpl;

    /**
     * Gets the value of the crawlableDatasetLabelerImpl property.
     * 
     * @return
     *     possible object is
     *     {@link UserImplType }
     *     
     */
    public UserImplType getCrawlableDatasetLabelerImpl() {
        return crawlableDatasetLabelerImpl;
    }

    /**
     * Sets the value of the crawlableDatasetLabelerImpl property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserImplType }
     *     
     */
    public void setCrawlableDatasetLabelerImpl(UserImplType value) {
        this.crawlableDatasetLabelerImpl = value;
    }

}