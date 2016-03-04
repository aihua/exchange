package lt.ciziunas.exchange.tasks;

import lt.ciziunas.exchange.dao.CurrencyDao;
import lt.ciziunas.exchange.dao.CurrencyDaoImpl;
import lt.ciziunas.exchange.entities.Currency;
import lt.ciziunas.exchange.network.Connection;
import lt.ciziunas.exchange.network.CurrencyExchangeClient;

import java.util.List;
import java.util.Map;

/**
 * Created by mciziunas on 3/2/16.
 */
public class PopulateDbTask implements Runnable {

    private Connection ecbServiceConnection;
    private CurrencyExchangeClient currencyExchange;
    private CurrencyDao currencyDao = new CurrencyDaoImpl();

    public PopulateDbTask(Connection ecbServiceConnection, CurrencyExchangeClient currencyExchange) {
        this.ecbServiceConnection = ecbServiceConnection;
        this.currencyExchange = currencyExchange;
    }

    public void updateDatabase() {
        Map<String, List<Currency>> currencies =  currencyExchange.getCurrencies("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist-90d.xml");
        System.out.println(currencies);
        currencyDao.add(currencies);
    }


    @Override
    public void run() {
        updateDatabase();
    }
}
