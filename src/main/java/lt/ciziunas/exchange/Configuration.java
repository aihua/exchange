package lt.ciziunas.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by mciziunas on 2/29/16.
 */
@SpringBootApplication
@org.springframework.context.annotation.Configuration
@EnableScheduling
public class Configuration {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Configuration.class, args);
        
    }

}