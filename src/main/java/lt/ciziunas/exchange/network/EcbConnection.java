package lt.ciziunas.exchange.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;

/**
 * Created by mciziunas on 3/2/16.
 */
public class EcbConnection {

    private static final String ECB_SERVICE_TIMEOUT = "ecb.service.timeout";
    private static final String ECB_SERVICE_MAX_RETRY_COUNT = "ecb.service.maxretry.count";

    private URL url;
    private int timeout = 1000;
    private HttpURLConnection connection;
    private int maxRetryCounter = 10;
    private int retryCounter = maxRetryCounter;

    @Autowired
    private Environment env;

    public EcbConnection(String uri) {
        populateUrl(uri);
//        populateProperties();
    }


    public void createConnection() {
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
            createConnection();
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

    private void populateProperties() {
        Integer timeout = env.getProperty(ECB_SERVICE_TIMEOUT, Integer.class);
        if (timeout != null) {
            this.timeout = timeout;
        }
        Integer maxRetryCounter = env.getProperty(ECB_SERVICE_MAX_RETRY_COUNT, Integer.class);
        if (maxRetryCounter != null) {
            this.maxRetryCounter = maxRetryCounter;
        }
    }
}
