package com.revature.models;

public class Employee {
    private int employeeId;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int userRole;



    public Employee(){

    }

    public Employee(String username, String password, String firstName, String lastName, String email, int userRole) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
    }

    public Employee(int employeeId, String username, String password, String firstName, String lastName, String email, int userRole) {
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
    }

    public Employee(int employeeId, String username, String password, String firstName, String lastName, String email) {
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int empolyeeId) {
        this.employeeId = empolyeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Employee{" +
                "empolyeeId=" + employeeId +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
