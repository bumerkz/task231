package web.model;

public class User {
    private int id;
    private String name;
    private String lastName;
    private int bYear;

    public User() {
    }

    public User(int id, String name, String lastName, int bYear) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.bYear = bYear;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getbYear() {
        return bYear;
    }

    public void setbYear(int bYear) {
        this.bYear = bYear;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bYear=" + bYear +
                '}';
    }
}
