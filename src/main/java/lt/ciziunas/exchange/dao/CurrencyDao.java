package lt.ciziunas.exchange.dao;

import lt.ciziunas.exchange.entities.Currency;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by mciziunas on 2/29/16.
 */
public interface CurrencyDao {

    public boolean add(Set<Currency> currencyList);

    public boolean add(Currency currency);

    public Set<Currency> findAll();

    public Currency find(String name, LocalDate date);

    public Currency findPresent(String name);
}
