package lt.ciziunas.exchange.network;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;

/**
 * Created by mciziunas on 3/2/16.
 */
@Component
public class EcbCurrencyExchangeConnection implements Connection {

    private static final String ECB_SERVICE_TIMEOUT = "ecb.service.timeout";
    private static final String ECB_SERVICE_MAX_RETRY_COUNT = "ecb.service.maxretry.count";

    private URL url;
    private int timeout = 1000;
    private HttpURLConnection connection;
    private int maxRetryCounter = 10;
    private int retryCounter = maxRetryCounter;

    public void createConnection(String uri) {
        populateUrl(uri);
        while (true) {
            try {
                if (retryCounter == 0) {
                    try {
                        System.out.println("Sleeping... Retry after " + timeout + "ms");
                        retryCounter = maxRetryCounter;
                        Thread.currentThread().sleep(timeout);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Accept", "application/xml");
                connection.getResponseCode();
                System.out.println("Connection to " + url + " succesful.");
                return;
            } catch (IOException e) {
                retryCounter--;
                System.out.println("Connection error. Retrying " + retryCounter + " to URL: " + url);
            }

        }
    }

    public InputStream getInputStream() {
        if (connection == null) {
            createConnection(url.toString());
        }
        try {
            return connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void closeConnection() {
        if (connection != null) {
            connection.disconnect();
        }
    }

    private void populateUrl(String uri) {
        try {
            url = new URL(uri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new InvalidParameterException("Invalid Ecb Service URL: " + url);
        }
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxRetryCounter() {
        return maxRetryCounter;
    }

    public void setMaxRetryCounter(int maxRetryCounter) {
        this.maxRetryCounter = maxRetryCounter;
    }
}
