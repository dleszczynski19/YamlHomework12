package pl.moderntester.models;

public class Browser {

    private String browserName;
    private boolean headlessBrowser;
    private int webElementTimeOut;
    private String appUrl;

    public Browser() {
    }

    public Browser(String browserName, boolean headlessBrowser, int webElementTimeOut, String appUrl) {
        this.browserName = browserName;
        this.headlessBrowser = headlessBrowser;
        this.webElementTimeOut = webElementTimeOut;
        this.appUrl = appUrl;
    }

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
