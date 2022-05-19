package com.revature.services;

import com.revature.dao.IEmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {
    private IEmployeeDao ed;

    public EmployeeService(IEmployeeDao ed){
        this.ed = ed;
    }

    public void registerEmployee(String username, String password, String firstName, String lastName, String email){
        Employee register = new Employee(0, username, password, firstName, lastName, email, 2);
        ed.createEmployee(register);
    }

    public Employee loginEmployee(String email, String password){
        //Try to see if that user exists in the database
        Employee e = ed.readEmployeeByEmail(email);

        if(e != null){
            if(password.equals(e.getPassword())){
                //This is out success
                return e;
            } else {
                //This means the password did not match
                return null;
            }
        }

        //Also not good, the user did not exist
        return null;
    }

    public Employee readEmployeeByEmail(String email){
        return ed.readEmployeeByEmail(email);
    }

    public Employee updateEmployeeInfo(Employee e){
        return ed.updateEmployee(e);
    }

    public void deleteEmployee(Employee e){
        ed.deleteEmployee(e);
    }


    public Employee getEmployeeById(int id) { return ed.readEmployeeById(id);}

}

