package doyourbestapp;

import doyourbestapp.models.cache.CreateActivityCache;
import doyourbestapp.models.RetroCalendarInventory;
import doyourbestapp.models.RetroCalender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author shivanidwivedi on 29/07/20
 * @project DoYourBest
 */

@SpringBootApplication
public class MainApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String s[]) {
        SpringApplication.run(MainApplication.class, s);
        LOGGER.info("Inside main application");
    }

    @Bean
    public CreateActivityCache responseCache() {
        return CreateActivityCache.getInstance();
    }

    @Bean
    public RetroCalender myBestCalender() {
        return new RetroCalender();
    }

    @Bean
    public RetroCalendarInventory bestDaysInventory(){
        return RetroCalendarInventory.createInventory();
    }
}
