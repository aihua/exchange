package lt.ciziunas.exchange.entities;

import java.time.LocalDate;

/**
 * Currency DB representation. Currency items are equal when name and date fields are equal
 */
public class Currency {

    private float value;
    private LocalDate date;

    public Currency(float value, LocalDate date) {
        this.value = value;
        this.date = date;
    }

    public float getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Currency{" +
                ", value=" + value +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return date.equals(currency.date);

    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }
}
