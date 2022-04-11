package com.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.moderntester.models.Browser;

public class BrowserEnvironment {
    private static Logger log = LoggerFactory.getLogger(BrowserEnvironment.class);
    private final String browserName;
    private final boolean headlessBrowser;
    private final int webElementTimeOut;
    private WebDriver driver;
    private Browser browser;

    public BrowserEnvironment(Browser browser) {
        this.browser = browser;
        this.headlessBrowser = browser.isHeadlessBrowser();
        this.webElementTimeOut = browser.getWebElementTimeOut();
        this.browserName = browser.getBrowserName();
        log.info("Browser name: " + browserName);
        log.info("WebElement TimeOut: " + webElementTimeOut);
        log.info("Is headless browser: " + headlessBrowser);
        log.info("-------------------------------------");
    }

    public WebDriver getDriver() {
        WebDriver driver;
        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                break;
            default:
                InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsDefault);
        }
        driver.get(browser.getAppUrl());
        this.driver = driver;
        return this.driver;
    }
}