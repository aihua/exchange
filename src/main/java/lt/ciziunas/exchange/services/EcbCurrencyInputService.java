package lt.ciziunas.exchange.services;

import lt.ciziunas.exchange.CurrencyConverter;
import lt.ciziunas.exchange.dto.EcbEnvelope;
import lt.ciziunas.exchange.entities.Currency;
import lt.ciziunas.exchange.network.EcbConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.List;

/**
 * Created by mciziunas on 3/2/16.
 */
public class EcbCurrencyInputService implements CurrencyInputService {

    private EcbConnection connection;
    private String url;

    public EcbCurrencyInputService(String url) {
        this.url = url;
    }

    @Override
    public List<Currency> getCurrencyList() {
        connection = new EcbConnection(url);
        try {
            JAXBContext jc = JAXBContext.newInstance(EcbEnvelope.class);
            Unmarshaller u = null;
            u = jc.createUnmarshaller();
            connection.createConnection();
            EcbEnvelope envelope = (EcbEnvelope) u.unmarshal( connection.getInputStream() );
            CurrencyConverter converter = new CurrencyConverter();
            return converter.convert(envelope);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Unexpected ecxeption while parsing xml data from Ecb service");
        } finally {
            connection.closeConnection();
        }

        return null;
    }

}
