package lt.ciziunas.exchange.controllers;

import lt.ciziunas.exchange.entities.Currency;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mciziunas on 2/29/16.
 */
@RestController
public class CurrencyExchangeController {

    @RequestMapping("/exchange")
    public String index() {
        return "exchange";
    }

    @RequestMapping(value = "/exchange/currencies", method = RequestMethod.GET)
    public List<Currency> getCurrencyList() {
        System.out.println("inside controller");
        Currency c = new Currency("usd", 1.5f, LocalDate.now());
        Currency c2 = new Currency("gbp", 1.8f, LocalDate.now());
        List<Currency> list = new ArrayList<>();
        list.add(c);
        list.add(c2);
        return list;

    }
}
