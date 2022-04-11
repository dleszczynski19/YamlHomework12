package pl.moderntester.models;

public enum Objects {
    USER, BROWSER;

    @SuppressWarnings("unchecked")
    public <T> T getObject() {
        switch (this) {
            case USER:
                return (T) User.class;
            case BROWSER:
                return (T) Browser.class;
            default:
                return null;
        }
    }
}
