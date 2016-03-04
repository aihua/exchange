package lt.ciziunas.exchange.controllers;

import lt.ciziunas.exchange.dao.CurrencyDao;
import lt.ciziunas.exchange.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by mciziunas on 2/29/16.
 */
@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyDao currencyDao;

    @RequestMapping(value = "/exchange/currencies", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public Set<String> getCurrencyList() {
        return currencyDao.findAllCurrencies();
    }

    @RequestMapping(value = "/exchange/rate-history", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Currency> getCurrencyList(@RequestParam String currency) {
        return currencyDao.findHistoryRates(currency);
    }
}
