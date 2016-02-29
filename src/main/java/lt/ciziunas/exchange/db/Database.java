package lt.ciziunas.exchange.db;

import lt.ciziunas.exchange.entities.Currency;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Database representation
 */
public class Database {

    private static Database instance = new Database();

    private Set<Currency> currencySet = new HashSet<>();

    private Database() {
    }

    public static Database getInstance() {
        return instance;
    }

    public boolean add(Set<Currency> currencyList) {
        return this.currencySet.addAll(currencyList);
    }

    public boolean add(Currency currency) {
        return this.currencySet.add(currency);
    }

    public Set<Currency> findAll() {
        return this.currencySet;
    }

    public Set<Currency> findHistory(String name) {
        return this.currencySet.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toSet());
    }

    public Currency find(String name, LocalDate date) {
        Optional<Currency> result = this.currencySet.stream().filter(p -> p.getName().equals(name) && p.getDate().equals(date)).findFirst();
        return result.isPresent() ? result.get() : null;
    }

    public Currency findPresent(String name) {
        return find(name, LocalDate.now());
    }


}
