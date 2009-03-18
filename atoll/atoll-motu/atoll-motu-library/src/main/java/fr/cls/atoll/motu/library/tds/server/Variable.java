//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3268 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.01.16 at 12:27:53 PM CET 
//

package fr.cls.atoll.motu.library.tds.server;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java class for variable element declaration.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 *  &lt;element name=&quot;variable&quot;&gt;
 *    &lt;complexType&gt;
 *      &lt;complexContent&gt;
 *        &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *          &lt;sequence&gt;
 *            &lt;element ref=&quot;{http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2}attribute&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *            &lt;element ref=&quot;{http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2}values&quot; minOccurs=&quot;0&quot;/&gt;
 *            &lt;element ref=&quot;{http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2}variable&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *            &lt;element ref=&quot;{http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2}logicalView&quot; minOccurs=&quot;0&quot;/&gt;
 *            &lt;element ref=&quot;{http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2}remove&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *          &lt;/sequence&gt;
 *          &lt;attribute name=&quot;name&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}token&quot; /&gt;
 *          &lt;attribute name=&quot;orgName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *          &lt;attribute name=&quot;shape&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}token&quot; /&gt;
 *          &lt;attribute name=&quot;type&quot; type=&quot;{http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2}DataType&quot; /&gt;
 *        &lt;/restriction&gt;
 *      &lt;/complexContent&gt;
 *    &lt;/complexType&gt;
 *  &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "attribute", "values", "variable", "logicalView", "remove" })
@XmlRootElement(name = "variable", namespace = "http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2")
public class Variable {

    @XmlElement(namespace = "http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2", required = true)
    protected List<Attribute> attribute;
    @XmlElement(namespace = "http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2")
    protected Values values;
    @XmlElement(namespace = "http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2", required = true)
    protected List<Variable> variable;
    @XmlElement(namespace = "http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2")
    protected LogicalView logicalView;
    @XmlElement(namespace = "http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2", required = true)
    protected List<Remove> remove;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String name;
    @XmlAttribute
    protected String orgName;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String shape;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification
     * you make to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE>
     * method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Attribute }
     * 
     * 
     */
    public List<Attribute> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<Attribute>();
        }
        return this.attribute;
    }

    /**
     * Gets the value of the values property.
     * 
     * @return possible object is {@link Values }
     * 
     */
    public Values getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     * 
     * @param value allowed object is {@link Values }
     * 
     */
    public void setValues(Values value) {
        this.values = value;
    }

    /**
     * Gets the value of the variable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification
     * you make to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE>
     * method for the variable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getVariable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Variable }
     * 
     * 
     */
    public List<Variable> getVariable() {
        if (variable == null) {
            variable = new ArrayList<Variable>();
        }
        return this.variable;
    }

    /**
     * Gets the value of the logicalView property.
     * 
     * @return possible object is {@link LogicalView }
     * 
     */
    public LogicalView getLogicalView() {
        return logicalView;
    }

    /**
     * Sets the value of the logicalView property.
     * 
     * @param value allowed object is {@link LogicalView }
     * 
     */
    public void setLogicalView(LogicalView value) {
        this.logicalView = value;
    }

    /**
     * Gets the value of the remove property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification
     * you make to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE>
     * method for the remove property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getRemove().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Remove }
     * 
     * 
     */
    public List<Remove> getRemove() {
        if (remove == null) {
            remove = new ArrayList<Remove>();
        }
        return this.remove;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the orgName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * Sets the value of the orgName property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setOrgName(String value) {
        this.orgName = value;
    }

    /**
     * Gets the value of the shape property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getShape() {
        return shape;
    }

    /**
     * Sets the value of the shape property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setShape(String value) {
        this.shape = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setType(String value) {
        this.type = value;
    }

}
