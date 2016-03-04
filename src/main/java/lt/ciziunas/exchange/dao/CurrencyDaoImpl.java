package lt.ciziunas.exchange.dao;

import lt.ciziunas.exchange.db.Database;
import lt.ciziunas.exchange.entities.Currency;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class for acessing DB. Avoiding direct calls to DB
 */
@Component
public class CurrencyDaoImpl implements CurrencyDao {

    private Database db = Database.getInstance();

    @Override
    public void add(String name, Currency currency) {
        db.add(name, currency);
    }

    @Override
    public void add(Map<String, List<Currency>> entities) {
        db.add(entities);
    }

    @Override
    public List<Currency> findHistoryRates(String currencyName) {
        return db.findHistoryRates(currencyName);
    }

    @Override
    public Set<String> findAllCurrencies() {
        return db.findAllCurrencies();
    }
}
