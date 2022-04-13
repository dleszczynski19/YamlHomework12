package com.configuration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class TestBase {
    protected static WebDriver driver;
    public final String passedMessage = "Test Passed!";
    public final static Marker passed = MarkerFactory.getMarker("PASSED");
    private static Logger log = LoggerFactory.getLogger(TestBase.class);
    private static BrowserEnvironment browserEnvironment;
    private static EnvironmentConfig environmentConfig;

    @BeforeAll
    static void setup() {
        environmentConfig = EnvironmentConfig.getInstance();
        browserEnvironment = environmentConfig.getBrowserEnvironment();
        driver = browserEnvironment.getDriver();
        log.info("Driver setup and initialized properly");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        log.info("Driver closed properly");
    }
}