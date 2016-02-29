package lt.ciziunas.exchange.db;

import lt.ciziunas.exchange.entities.Currency;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

/**
 * Created by mciziunas on 2/29/16.
 */
public class DatabaseTest {

    private static final String CURRENCY_USD = "usd";
    private static final String CURRENCY_NOK = "nok";


    private Currency curUsdToday = new Currency(CURRENCY_USD, 1.2f, LocalDate.now());
    private Currency curUsdYesterday = new Currency(CURRENCY_USD, 1.3f, LocalDate.now().minus(1, ChronoUnit.DAYS));
    private Currency curUsdLastWeek = new Currency(CURRENCY_USD, 1.3f, LocalDate.now().minus(7, ChronoUnit.DAYS));

    private Currency curNokToday = new Currency(CURRENCY_NOK, 7f, LocalDate.now());
    private Currency curNokYesterday = new Currency(CURRENCY_NOK, 8f, LocalDate.now().minus(1, ChronoUnit.DAYS));
    private Currency curNokLastWeek = new Currency(CURRENCY_NOK, 9f, LocalDate.now().minus(8, ChronoUnit.DAYS));


    private Database testee = Database.getInstance();

    @Before
    public void setup() {
        populateData();
    }

    @Test
    public void testFindAll() {
        Set<Currency> result = testee.findAll();
        Assert.assertEquals(6, result.size());
    }

    @Test
    public void testFindHistory() {
        Set<Currency> result = testee.findHistory(CURRENCY_USD);
        Assert.assertEquals(3, result.size());
        for (Currency currency : result) {
            Assert.assertEquals(CURRENCY_USD, currency.getName());
        }
    }

    @Test
    public void testFindHistoryNull() {
        Set<Currency> result = testee.findHistory(null);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testFindHistoryEmpty() {
        Set<Currency> result = testee.findHistory(null);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testFind() {
        Currency result = testee.find(CURRENCY_USD, LocalDate.now().minus(1, ChronoUnit.DAYS));
        Assert.assertEquals(CURRENCY_USD, result.getName());
    }

    @Test
    public void testFindNoResults() {
        Currency result = testee.find(CURRENCY_USD, LocalDate.now().minus(2, ChronoUnit.DAYS));
        Assert.assertNull(result);
    }

    @Test
    public void testFindNoCurrencyFound() {
        Currency result = testee.find("aaa", LocalDate.now().minus(2, ChronoUnit.DAYS));
        Assert.assertNull(result);
    }

    @Test
    public void testFindPresent() {
        Currency result = testee.findPresent(CURRENCY_NOK);
        Assert.assertEquals(CURRENCY_NOK, result.getName());
    }

    private void populateData() {
        testee.add(curUsdToday);
        testee.add(curUsdYesterday);
        testee.add(curUsdLastWeek);
        testee.add(curNokToday);
        testee.add(curNokYesterday);
        testee.add(curNokLastWeek);
    }
}
