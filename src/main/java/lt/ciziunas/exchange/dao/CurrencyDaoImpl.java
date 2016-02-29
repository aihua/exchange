package lt.ciziunas.exchange.dao;

import lt.ciziunas.exchange.db.Database;
import lt.ciziunas.exchange.entities.Currency;

import java.time.LocalDate;
import java.util.Set;

/**
 * Class for acessing DB. Avoiding direct calls to DB
 */
public class CurrencyDaoImpl implements CurrencyDao {

    private Database db = Database.getInstance();

    @Override
    public boolean add(Set<Currency> currencyList) {
        return db.add(currencyList);
    }

    @Override
    public boolean add(Currency currency) {
        return db.add(currency);
    }

    @Override
    public Set<Currency> findAll() {
        return db.findAll();
    }

    @Override
    public Currency find(String name, LocalDate date) {
        return db.find(name, date);
    }

    @Override
    public Currency findPresent(String name) {
        return db.findPresent(name);
    }
}
