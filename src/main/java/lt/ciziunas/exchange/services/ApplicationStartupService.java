package lt.ciziunas.exchange.services;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupService
        implements ApplicationListener<ContextRefreshedEvent> {

    private EcbCurrencyExchangeService exchangeService = new EcbCurrencyExchangeService();

    /*
     * This method is called during Spring's startup.
     *
     * @param event Event raised when an ApplicationContext gets initialized or
     * refreshed.
     */
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        exchangeService.updateDatabase();

    }

}