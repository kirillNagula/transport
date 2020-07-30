package model;

public class User {
    private int id;
    private String name;
    private String password;
    private String UserAccess;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserAccess(String userAccess) {
        UserAccess = userAccess;
    }

    public String getUserAccess() {
        return UserAccess;
    }
}
