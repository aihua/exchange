package lt.ciziunas.exchange.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

/**
 * Currency DB representation. Currency items are equal when name and date fields are equal
 */
public class Currency {

    private String name;
    private float value;
    @JsonIgnore
    private LocalDate date;

    public Currency(String name, float value, LocalDate date) {
        this.name = name;
        this.value = value;
        this.date = date;
    }

    public String getName() {
        return name;
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
                "name='" + name + '\'' +
                ", value=" + value +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (!name.equals(currency.name)) return false;
        return date.equals(currency.date);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
