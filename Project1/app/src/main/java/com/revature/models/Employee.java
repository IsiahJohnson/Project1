package com.revature.models;

public class Employee {
    private int empolyeeId;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int userRole;



    public Employee(){

    }


    public Employee(int empolyeeId, String password, String firstName, String lastName, String email, int userRole) {
        this.empolyeeId = empolyeeId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
    }

    public Employee(int empolyeeId, String password, String firstName, String lastName, String email) {
        this.empolyeeId = empolyeeId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public int getEmpolyeeId() {
        return empolyeeId;
    }

    public void setEmpolyeeId(int empolyeeId) {
        this.empolyeeId = empolyeeId;
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
                "empolyeeId=" + empolyeeId +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
