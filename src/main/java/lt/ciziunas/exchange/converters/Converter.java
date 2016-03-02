package lt.ciziunas.exchange.converters;

/**
 * Created by mciziunas on 3/2/16.
 */
public interface Converter<T,S> {

    public S convert(T source);
}
