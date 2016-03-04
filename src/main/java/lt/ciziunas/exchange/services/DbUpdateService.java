package lt.ciziunas.exchange.services;

import lt.ciziunas.exchange.dao.CurrencyDao;
import lt.ciziunas.exchange.entities.Currency;
import lt.ciziunas.exchange.network.CurrencyExchangeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    private static final String ECB_SERVICE_DAILY_URL = "ecb.service.daily.url";

    @Autowired
    private Environment env;

    @Autowired
    private CurrencyExchangeClient currencyExchangeClient;
    @Autowired
    private CurrencyDao currencyDao;

    /**
     * Daily job at midnight in local server time
     */
    @Scheduled(cron="0 0 * * * *")
    public void dailyDbUpdate() {
        System.out.println("DB updating job started at " + LocalDateTime.now());
        Map<String, List<Currency>> currencyList = currencyExchangeClient.getCurrencies(getServiceUrl());
        currencyDao.add(currencyList);
        System.out.println("DB updating job finished at " + LocalDateTime.now());
    }

    private String getServiceUrl() {
        return env.getProperty(ECB_SERVICE_DAILY_URL);
    }
}
