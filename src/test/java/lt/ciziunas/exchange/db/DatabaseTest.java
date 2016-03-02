package lt.ciziunas.exchange.db;

import lt.ciziunas.exchange.entities.Currency;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by mciziunas on 2/29/16.
 */
public class DatabaseTest {

    private static final String CURRENCY_USD = "usd";
    private static final String CURRENCY_NOK = "nok";


    private Currency curUsdToday = new Currency(1.2f, LocalDate.now());
    private Currency curUsdYesterday = new Currency(1.3f, LocalDate.now().minus(1, ChronoUnit.DAYS));
    private Currency curUsdLastWeek = new Currency(1.3f, LocalDate.now().minus(7, ChronoUnit.DAYS));

    private Currency curNokToday = new Currency(7f, LocalDate.now());
    private Currency curNokYesterday = new Currency( 8f, LocalDate.now().minus(1, ChronoUnit.DAYS));
    private Currency curNokLastWeek = new Currency( 9f, LocalDate.now().minus(8, ChronoUnit.DAYS));


    private Database testee = Database.getInstance();

    @Before
    public void setup() {
        populateData();
    }

//    @Test
//    public void testFindAll() {
//        Set<Currency> result = testee.findAll();
//        Assert.assertEquals(6, result.size());
//    }

    @Test
    public void testFindHistory() {
        List<Currency> result = testee.findHistoryRates(CURRENCY_USD);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(LocalDate.now(), result.get(0).getDate());
        Assert.assertEquals(LocalDate.now().minus(1, ChronoUnit.DAYS), result.get(1).getDate());
        Assert.assertEquals(LocalDate.now().minus(7, ChronoUnit.DAYS), result.get(2).getDate());
    }

    @Test
    public void testFindHistoryNull() {
        List<Currency> result = testee.findHistoryRates(null);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testFindHistoryEmpty() {
        List<Currency> result = testee.findHistoryRates("");
        Assert.assertEquals(0, result.size());
    }

//    @Test
//    public void testFind() {
//        Currency result = testee.find(CURRENCY_USD, LocalDate.now().minus(1, ChronoUnit.DAYS));
//        Assert.assertEquals(CURRENCY_USD, result.getName());
//    }

//    @Test
//    public void testFindNoResults() {
//        Currency result = testee.find(CURRENCY_USD, LocalDate.now().minus(2, ChronoUnit.DAYS));
//        Assert.assertNull(result);
//    }

//    @Test
//    public void testFindNoCurrencyFound() {
//        Currency result = testee.find("aaa", LocalDate.now().minus(2, ChronoUnit.DAYS));
//        Assert.assertNull(result);
//    }

//    @Test
//    public void testFindPresent() {
//        Currency result = testee.findPresent(CURRENCY_NOK);
//        Assert.assertEquals(CURRENCY_NOK, result.getName());
//    }

    private void populateData() {
        testee.add(CURRENCY_USD, curUsdToday);
        testee.add(CURRENCY_USD, curUsdYesterday);
        testee.add(CURRENCY_USD, curUsdLastWeek);
        testee.add(CURRENCY_NOK, curNokToday);
        testee.add(CURRENCY_NOK, curNokYesterday);
        testee.add(CURRENCY_NOK, curNokLastWeek);
    }
}
