package lt.ciziunas.exchange.network;

import lt.ciziunas.exchange.converters.CurrencyConverter;
import lt.ciziunas.exchange.dto.EcbEnvelope;
import lt.ciziunas.exchange.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.List;
import java.util.Map;

/**
 * Created by mciziunas on 3/2/16.
 */
@Component
public class EcbCurrencyExchangeHttpClient implements CurrencyExchangeClient {

    @Autowired
    private Connection connection;

    @Override
    public Map<String, List<Currency>> getCurrencies(String url) {
        try {
            JAXBContext jc = JAXBContext.newInstance(EcbEnvelope.class);
            Unmarshaller u = null;
            u = jc.createUnmarshaller();
            connection.createConnection(url);
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
