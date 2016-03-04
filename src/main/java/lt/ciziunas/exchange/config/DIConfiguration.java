package lt.ciziunas.exchange.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mciziunas on 3/3/16.
 */
@Configuration
@ComponentScan(value = { "lt.ciziunas.exchange.services", "lt.ciziunas.exchange.network", "lt.ciziunas.exchange.controllers" })
public class DIConfiguration {

}