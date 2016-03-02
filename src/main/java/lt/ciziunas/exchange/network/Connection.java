package lt.ciziunas.exchange.network;

import java.io.InputStream;

/**
 * Created by mciziunas on 3/2/16.
 */
public interface Connection {

    public void createConnection();
    public InputStream getInputStream();
    public void closeConnection();
}
