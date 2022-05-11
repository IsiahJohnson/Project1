package models;

public class Employee {
    private int employeeId;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private boolean role;



    public Employee(){

    }

    public Employee(int empolyeeId, String password, String firstName, String lastName, String email, boolean role) {
        this.employeeId = empolyeeId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public int getEmpolyeeId() {
        return employeeId;
    }

    public void setEmpolyeeId(int empolyeeId) {
        this.employeeId = empolyeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
}
