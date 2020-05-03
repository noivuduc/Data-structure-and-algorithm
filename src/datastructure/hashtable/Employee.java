package datastructure.hashtable;

public class Employee {
    private String firstName;
    private String lasName;
    private int id;

    public Employee(String firstName, String lasName, int id) {
        this.firstName = firstName;
        this.lasName = lasName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lasName='" + lasName + '\'' +
                ", id=" + id +
                '}';
    }
}
