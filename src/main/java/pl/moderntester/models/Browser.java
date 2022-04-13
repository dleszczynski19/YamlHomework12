package pl.moderntester.models;

public class Browser {
    private String browserName;
    private boolean headlessBrowser;
    private int webElementTimeOut;
    private String appUrl;

    public String getBrowserName() {
        return browserName;
    }

    public boolean isHeadlessBrowser() {
        return headlessBrowser;
    }

    public int getWebElementTimeOut() {
        return webElementTimeOut;
    }

    public String getAppUrl() {
        return appUrl;
    }
}