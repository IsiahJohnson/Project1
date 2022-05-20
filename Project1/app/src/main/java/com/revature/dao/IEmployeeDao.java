package com.revature.dao;

import com.revature.models.Employee;

import java.util.List;

public interface IEmployeeDao {
    public void createEmployee(Employee e);

    //Read
    public List<Employee> readAllEmployees();


    Employee readEmployeeByEmail(String email);

    Employee updateEmployee(Employee em);

    //Delete
    public void deleteEmployee(Employee e);

    Employee readEmployeeById(int id);
}
