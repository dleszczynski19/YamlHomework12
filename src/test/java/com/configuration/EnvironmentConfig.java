package com.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.moderntester.models.Environment;
import pl.moderntester.models.YamlFile;
import pl.moderntester.pages.configuration.YamlReader;

public class EnvironmentConfig {
    private static Logger log = LoggerFactory.getLogger(EnvironmentConfig.class);
    private final YamlFile yamlFile;
    private final BrowserEnvironment browserEnvironment;
    private final Environment environment;
    private final YamlReader yamlReader;
    private final String environmentName;

    public EnvironmentConfig() {
        yamlReader = new YamlReader();
        yamlFile = yamlReader.getYamlFile();
        environmentName = yamlFile.getCurrentEnv();
        log.info("--------------CONFIG-----------------");
        log.info("Environment name: " + environmentName);
        browserEnvironment = new BrowserEnvironment(yamlFile.getBrowser());
        environment = yamlReader.getCurrentConfig(yamlFile, environmentName);
    }

    public static EnvironmentConfig getInstance() {
        return EnvironmentConfig.EnvironmentPropertySingleton.INSTANCE;
    }

    public BrowserEnvironment getBrowserEnvironment() {
        return browserEnvironment;
    }

    public Environment getEnvironment() {
        return environment;
    }

    private static class EnvironmentPropertySingleton {
        private static final EnvironmentConfig INSTANCE = new EnvironmentConfig();
    }
}
