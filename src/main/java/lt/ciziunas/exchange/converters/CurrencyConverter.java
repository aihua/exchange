package lt.ciziunas.exchange.converters;

import lt.ciziunas.exchange.dto.CurrencyDailyRecord;
import lt.ciziunas.exchange.dto.CurrencyItem;
import lt.ciziunas.exchange.dto.EcbEnvelope;
import lt.ciziunas.exchange.entities.Currency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mciziunas on 3/2/16.
 */
public class CurrencyConverter implements Converter<EcbEnvelope, Map<String, List<Currency>>> {

    public Map<String, List<Currency>> convert(EcbEnvelope source) {
        Map<String, List<Currency>> result = new HashMap<>();

        for(CurrencyDailyRecord record : source.getCurrencyRecordsWrapper().getCurrencyDailyRecordList()) {
            LocalDate date = record.getDate();
            for(CurrencyItem currency : record.getCurrencyItems()) {
                Currency entity = new Currency(currency.getRate(), date);
                String currencyName = currency.getCurrency().toUpperCase();
                List<Currency> existingEntry = result.get(currencyName);
                if (existingEntry != null) {
                    existingEntry.add(entity);
                } else {
                    List<Currency> list = new ArrayList<>();
                    list.add(entity);
                    result.put(currencyName, list);
                }

            }
        }

        return result;
    }

}
