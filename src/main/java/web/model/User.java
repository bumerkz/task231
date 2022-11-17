package web.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class User {
    private int id;

    @NotEmpty(message = "Name shoud not be empty")
    @Size(min = 2, max = 30, message = "Name Error")
    private String name;
    @NotEmpty(message = "LastName shoud not be empty")
    @Size(min = 2, max = 30, message = "LastName Error")
    private String lastName;
    @Min(value = 0, message = "Year Error")
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
