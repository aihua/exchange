package lt.ciziunas.exchange.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope", namespace = "http://www.gesmes.org/xml/2002-08-01")
@XmlAccessorType(XmlAccessType.FIELD)
public class EcbEnvelope {

    @XmlElement(name = "Cube")
    private CurrencyRecordsWrapper currencyRecordsWrapper;

    public CurrencyRecordsWrapper getCurrencyRecordsWrapper() {
        return currencyRecordsWrapper;
    }

    public void setCurrencyRecordsWrapper(CurrencyRecordsWrapper currencyRecordsWrapper) {
        this.currencyRecordsWrapper = currencyRecordsWrapper;
    }
}
