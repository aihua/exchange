package lt.ciziunas.exchange.network;

import lt.ciziunas.exchange.converters.CurrencyConverter;
import lt.ciziunas.exchange.dto.EcbEnvelope;
import lt.ciziunas.exchange.entities.Currency;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.List;
import java.util.Map;

/**
 * Created by mciziunas on 3/2/16.
 */
public class EcbCurrencyExchangeHttpClient implements CurrencyExchangeClient {

    private Connection connection;

    public EcbCurrencyExchangeHttpClient(Connection ecbCurrencyConnection) {
        this.connection = ecbCurrencyConnection;
    }

    @Override
    public Map<String, List<Currency>> getCurrencies() {
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
