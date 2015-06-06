package net.unitbv.email.model;


public class User {
    private String id;
    private String userName;
    private String firstName;
    private String lastName;

    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String id, String userName, String firstName, String lastName) {
        this(userName, firstName, lastName);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
