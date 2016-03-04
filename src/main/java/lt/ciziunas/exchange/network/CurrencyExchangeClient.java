package lt.ciziunas.exchange.network;

import lt.ciziunas.exchange.entities.Currency;

import java.util.List;
import java.util.Map;

/**
 * Created by mciziunas on 3/1/16.
 */
public interface CurrencyExchangeClient {

    public Map<String, List<Currency>> getCurrencies(String url);
}
