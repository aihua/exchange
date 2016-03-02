package lt.ciziunas.exchange;

import lt.ciziunas.exchange.dto.CurrencyDailyRecord;
import lt.ciziunas.exchange.dto.CurrencyItem;
import lt.ciziunas.exchange.dto.EcbEnvelope;
import lt.ciziunas.exchange.entities.Currency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mciziunas on 3/2/16.
 */
public class CurrencyConverter {

    public List<Currency> convert(EcbEnvelope source) {
        List<Currency> result = new ArrayList<>();

        for(CurrencyDailyRecord record : source.getCurrencyRecordsWrapper().getCurrencyDailyRecordList()) {
            LocalDate date = record.getDate();
            for(CurrencyItem currency : record.getCurrencyItems()) {
                Currency entity = new Currency(currency.getCurrency(), currency.getRate(), date);
                result.add(entity);
            }
        }

        return result;
    }
}
