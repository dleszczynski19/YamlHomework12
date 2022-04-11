package pl.moderntester.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;

public class YamlFile {
    private Browser browser;
    private String currentEnv;
    @JsonAnyGetter
    private HashMap<String, Environment> environments;

    public YamlFile() {
    }

    public YamlFile(Browser browser, String currentEnv, HashMap<String, Environment> environments) {
        this.browser = browser;
        this.currentEnv = currentEnv;
        this.environments = environments;
    }

    public Browser getBrowser() {
        return browser;
    }

    public String getCurrentEnv() {
        return currentEnv;
    }

    public HashMap<String, Environment> getEnvironments() {
        return environments;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public void setCurrentEnv(String currentEnv) {
        this.currentEnv = currentEnv;
    }

    public void setEnvironments(HashMap<String, Environment> environments) {
        this.environments = environments;
    }
}
