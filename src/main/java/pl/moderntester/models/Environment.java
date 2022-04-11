package pl.moderntester.models;

public class Environment {
    private String message;
    private User user;

    public Environment() {
    }

    public Environment(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
