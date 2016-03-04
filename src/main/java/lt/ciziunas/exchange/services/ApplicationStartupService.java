package lt.ciziunas.exchange.services;

import lt.ciziunas.exchange.network.Connection;
import lt.ciziunas.exchange.network.CurrencyExchangeClient;
import lt.ciziunas.exchange.tasks.PopulateDbTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupService
        implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Connection ecbServiceConnection;

    @Autowired
    private CurrencyExchangeClient currencyExchange;

    /*
     * This method is called during Spring's startup.
     *
     * @param event Event raised when an ApplicationContext gets initialized or
     * refreshed.
     */
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        PopulateDbTask exchangeService = new PopulateDbTask(ecbServiceConnection, currencyExchange);
        new Thread(exchangeService).start();
    }

}