package com.revature.dao;

import com.revature.models.Employee;

public interface IEmployeeDao {
    public void createEmployee(Employee e);

    //Read
    public List<Employee> readAllEmployees();

    //Read
    public Employee readByEmail(String email);

    //Update
    public Employee update();

    //Delete
    public void deleteEmployee(Employee e);

    public void insertUserRole(string role, int roleId);
}
