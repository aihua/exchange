package lt.ciziunas.exchange.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mciziunas on 2/29/16.
 */
@RestController
public class CurrencyExchangeController {

    @RequestMapping("/exchange")
    public String index() {
        return "exchange";
    }
}
