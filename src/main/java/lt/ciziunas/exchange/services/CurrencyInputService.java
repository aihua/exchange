package lt.ciziunas.exchange.services;

import lt.ciziunas.exchange.entities.Currency;

import java.util.Set;

/**
 * Created by mciziunas on 3/1/16.
 */
public interface CurrencyInputService {

    public Set<Currency> getCurrencyList();
}
