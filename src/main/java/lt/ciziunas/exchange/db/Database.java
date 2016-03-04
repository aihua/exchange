package lt.ciziunas.exchange.db;

import lt.ciziunas.exchange.entities.Currency;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Database representation
 */
public class Database {

    private static Database instance = new Database();

    private Map<String, List<Currency>> currencies = new HashMap<>();

    private Database() {}

    public static Database getInstance() {
        return instance;
    }

    public void add(String name, Currency currency) {
        name = name.toUpperCase();
        List<Currency> result = currencies.get(name);
        if (result != null) {
            result.add(currency);
        } else {
            List<Currency> list = new ArrayList<>();
            list.add(currency);
            currencies.put(name, list);
        }
    }

    public void add(Map<String, List<Currency>> entities) {
        currencies.putAll(entities);
    }

    public List<Currency> findHistoryRates(String currencyName) {
        if (!StringUtils.isEmpty(currencyName)) {
            currencyName = currencyName.toUpperCase();
        }
        return currencies.get(currencyName) == null ? new ArrayList<>() :  currencies.get(currencyName);
    }

    public Set<String> findAllCurrencies() {
        return currencies.keySet().isEmpty() ? new HashSet<>() : currencies.keySet();
    }

}