package lt.ciziunas.exchange.services;

import lt.ciziunas.exchange.dao.CurrencyDao;
import lt.ciziunas.exchange.dao.CurrencyDaoImpl;
import lt.ciziunas.exchange.entities.Currency;
import lt.ciziunas.exchange.network.CurrencyExchangeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Created by mciziunas on 3/2/16.
 */
@Component
public class DbUpdateService {

    @Autowired
    private CurrencyExchangeClient currencyExchangeClient;
    private CurrencyDao currencyDao = new CurrencyDaoImpl();

    @Scheduled(cron="15 5 * * * *")
    public void dailyDbUpdate() {
        System.out.println("DB updating job started at " + LocalDateTime.now());
        Map<String, List<Currency>> currencyList = currencyExchangeClient.getCurrencies("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
        currencyDao.add(currencyList);
        System.out.println("DB updating job finished at " + LocalDateTime.now());
    }
}
