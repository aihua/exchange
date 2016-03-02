package lt.ciziunas.exchange.services;

import lt.ciziunas.exchange.dao.CurrencyDao;
import lt.ciziunas.exchange.entities.Currency;
import lt.ciziunas.exchange.network.CurrencyExchangeClient;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Created by mciziunas on 3/2/16.
 */
//0 0 2 1/1 * ? *
public class DbUpdateService {

    private CurrencyExchangeClient currencyExchangeClient;
    private CurrencyDao currencyDao;

    @Scheduled(cron="*/5 * * * * MON-FRI")
    public void dailyDbUpdate() {
        System.out.println("DB updating job started at " + LocalDateTime.now());
        Map<String, List<Currency>> currencyList = currencyExchangeClient.getCurrencies();
        currencyDao.add(currencyList);
        System.out.println("DB updating job finished at " + LocalDateTime.now());
    }
}
