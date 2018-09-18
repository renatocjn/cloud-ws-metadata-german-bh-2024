package org.identifiers.org.cloud.ws.metadata.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;

/**
 * Project: metadata
 * Package: org.identifiers.org.cloud.ws.metadata.models
 * Timestamp: 2018-09-18 17:28
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
@Component
public class MetadataFetcherChromeEngineBased implements MetadataFetcher {
    private static final Logger logger = LoggerFactory.getLogger(MetadataFetcherChromeEngineBased.class);

    @Value("${org.identifiers.cloud.ws.metadata.backend.selenium.driver.chrome.path.bin}")
    private String pathChromedriver;

    private ChromeDriverService chromeDriverService;
    private ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);

    @PostConstruct
    private void init() {
        logger.info("Starting Chrome driver service");
        chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(pathChromedriver))
                .usingAnyFreePort()
                .build();
        try {
            chromeDriverService.start();
            // TODO create a watchdog that makes sure the chrome driver service is running
        } catch (IOException e) {
            String errorMessage = String.format("Could not start Google Chrome Driver Service due to '%s'!", e.getMessage());
            logger.error(errorMessage);
            throw new MetadataFetcherException(errorMessage);
        }
    }

    @PreDestroy
    private void shutdown() {
        logger.info("Shutting down Google Chromedriver Service");
        chromeDriverService.stop();
    }

    @Override
    public Object fetchMetadataFor(String url) throws MetadataFetcherException {
        logger.info("Connecting to google chrome driver");
        WebDriver driver = new RemoteWebDriver(chromeDriverService.getUrl(), chromeOptions);

        return null;
    }
}
