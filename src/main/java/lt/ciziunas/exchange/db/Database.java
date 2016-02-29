package lt.ciziunas.exchange.db;

import lt.ciziunas.exchange.entities.Currency;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Database representation
 */
public class Database {

    private static Database instance = new Database();

    private Set<Currency> currencySet = new HashSet<>();

    private Database() {}

    public static Database getInstance() {
        return instance;
    }

    public boolean add(Set<Currency> currencyList) {
        return this.currencySet.addAll(currencyList);
    }

    public boolean add(Currency currency) {
        Stream<Integer> stream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
        stream.

        return this.currencySet.add(currency);
    }

    public Set<Currency> findAll() {
        return this.currencySet;
    }

    public Set<Currency> findHistory(String name) {
        return this.currencySet.stream().filter(p -> name.equals(p.getName())).collect(Collectors.toSet());
    }


}
