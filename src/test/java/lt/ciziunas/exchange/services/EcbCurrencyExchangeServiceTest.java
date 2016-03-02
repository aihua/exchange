package lt.ciziunas.exchange.services;

import lt.ciziunas.exchange.dao.CurrencyDaoImpl;
import lt.ciziunas.exchange.entities.Currency;
import org.junit.Test;

import java.util.List;

/**
 * Created by mciziunas on 3/2/16.
 */
public class EcbCurrencyExchangeServiceTest {

    private EcbCurrencyExchangeService testee = new EcbCurrencyExchangeService();
    private CurrencyDaoImpl dao = new CurrencyDaoImpl();

    @Test
    public void testUpdateDb() {
        testee.updateDatabase();
        List<Currency> results = dao.findHistoryRates("CHF");
//        Assert.assertEquals(90, results.size());
        for (Currency c : results) {
            System.out.println(c);
        }
    }
}
