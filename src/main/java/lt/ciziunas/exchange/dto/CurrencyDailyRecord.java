package lt.ciziunas.exchange.dto;

import lt.ciziunas.exchange.adapters.XmlDateTypeAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cube" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="rate" type="{http://www.w3.org/2001/XMLSchema}float" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "currencyItems", "time"
    })
public class CurrencyDailyRecord {

    @XmlElement(name = "Cube")
    protected List<CurrencyItem> currencyItems;
    @XmlAttribute(name = "time")
//    @XmlSchemaType(name = "date")
//    @XmlElement(name = "time", required = true)
    @XmlJavaTypeAdapter(XmlDateTypeAdapter.class)
    protected LocalDate time;

    /**
     * Gets the value of the cube property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cube property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrencyItem().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrencyItem }
     *
     *
     */
    public List<CurrencyItem> getCurrencyItem() {
        if (currencyItems == null) {
            currencyItems = new ArrayList<CurrencyItem>();
        }
        return this.currencyItems;
    }

    /**
     * Gets the value of the time property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public LocalDate getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setTime(LocalDate value) {
        this.time = value;
    }

}
