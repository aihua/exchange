package lt.ciziunas.exchange.services;

import lt.ciziunas.exchange.dao.CurrencyDao;
import lt.ciziunas.exchange.dao.CurrencyDaoImpl;
import lt.ciziunas.exchange.entities.Currency;
import lt.ciziunas.exchange.network.Connection;
import lt.ciziunas.exchange.network.CurrencyExchangeClient;
import lt.ciziunas.exchange.network.EcbCurrencyExchangeHttpClient;
import lt.ciziunas.exchange.network.EcbCurrencyExchangeConnection;

import java.util.List;
import java.util.Map;

/**
 * Created by mciziunas on 3/2/16.
 */
public class EcbCurrencyExchangeService {

    private Connection ecbServiceConnection = new EcbCurrencyExchangeConnection("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist-90d.xml");
    private CurrencyExchangeClient currencyExchange = new EcbCurrencyExchangeHttpClient(ecbServiceConnection);
    private CurrencyDao currencyDao = new CurrencyDaoImpl();


    public void updateDatabase() {
        Map<String, List<Currency>> currencies =  currencyExchange.getCurrencies();
        System.out.println(currencies);
        currencyDao.add(currencies);
    }


}
