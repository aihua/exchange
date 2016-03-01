package lt.ciziunas.exchange.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by mciziunas on 3/1/16.
 */
public class XmlDateTypeAdapter extends XmlAdapter<String, LocalDate> {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public LocalDate unmarshal(String stringDate) throws Exception {
        synchronized (DATE_FORMAT) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            return LocalDate.parse(stringDate, formatter);
        }
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        synchronized (DATE_FORMAT) {
            return date.toString();
        }
    }
}
