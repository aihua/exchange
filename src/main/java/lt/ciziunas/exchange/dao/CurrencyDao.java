package lt.ciziunas.exchange.dao;

import lt.ciziunas.exchange.entities.Currency;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mciziunas on 2/29/16.
 */
public interface CurrencyDao {

    public void add(String name, Currency currency);

    public void add(Map<String, List<Currency>> entities);

    public List<Currency> findHistoryRates(String currencyName);

    public Set<String> findAllCurrencies();
}
