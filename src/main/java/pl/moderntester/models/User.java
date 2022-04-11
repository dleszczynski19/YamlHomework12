package pl.moderntester.models;

import java.util.Arrays;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String profession;
    private String[] commands;
    private String filePath;

    public User() {
    }

    public User(String firstName, String lastName, String email, int age, String profession, String[] commands, String filePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.profession = profession;
        this.commands = commands;
        this.filePath = filePath;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public String[] getCommands() {
        return commands;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString(){
        return "FirstName: " + firstName + "\nLastName: " + lastName + "\nEmail: " + email + "\nAge: " + age +
                "\nProfession: " + profession + "\nCommands: " + Arrays.toString(commands) + "\nPath: "
                + filePath;
    }
}
