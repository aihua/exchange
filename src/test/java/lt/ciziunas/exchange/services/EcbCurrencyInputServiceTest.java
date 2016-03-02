package lt.ciziunas.exchange.services;

import org.junit.Test;

/**
 * Created by mciziunas on 3/2/16.
 */
public class EcbCurrencyInputServiceTest {

    private EcbCurrencyInputService testee;

    @Test
    public void testGetCurrencies() {
        testee = new EcbCurrencyInputService("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist-90d.xml");
        testee.getCurrencyList();
    }
}
