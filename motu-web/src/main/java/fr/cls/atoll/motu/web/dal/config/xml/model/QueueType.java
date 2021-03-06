//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.08 at 03:14:08 PM CET 
//


package fr.cls.atoll.motu.web.dal.config.xml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A Queue Settings
 * 
 * <p>Java class for queueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="maxPoolSize" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;minInclusive value="-1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="maxThreads" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dataThreshold">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *               &lt;minInclusive value="1.0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="lowPriorityWaiting">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/all>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="batch" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queueType", propOrder = {

})
public class QueueType {

    @XmlElement(defaultValue = "-1")
    protected Short maxPoolSize;
    @XmlElement(defaultValue = "1")
    protected Integer maxThreads;
    protected float dataThreshold;
    protected short lowPriorityWaiting;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "batch")
    protected Boolean batch;

    /**
     * Gets the value of the maxPoolSize property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getMaxPoolSize() {
        return maxPoolSize;
    }

    /**
     * Sets the value of the maxPoolSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setMaxPoolSize(Short value) {
        this.maxPoolSize = value;
    }

    /**
     * Gets the value of the maxThreads property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxThreads() {
        return maxThreads;
    }

    /**
     * Sets the value of the maxThreads property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxThreads(Integer value) {
        this.maxThreads = value;
    }

    /**
     * Gets the value of the dataThreshold property.
     * 
     */
    public float getDataThreshold() {
        return dataThreshold;
    }

    /**
     * Sets the value of the dataThreshold property.
     * 
     */
    public void setDataThreshold(float value) {
        this.dataThreshold = value;
    }

    /**
     * Gets the value of the lowPriorityWaiting property.
     * 
     */
    public short getLowPriorityWaiting() {
        return lowPriorityWaiting;
    }

    /**
     * Sets the value of the lowPriorityWaiting property.
     * 
     */
    public void setLowPriorityWaiting(short value) {
        this.lowPriorityWaiting = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the batch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean getBatch() {
        if (batch == null) {
            return false;
        } else {
            return batch;
        }
    }

    /**
     * Sets the value of the batch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBatch(Boolean value) {
        this.batch = value;
    }

}
