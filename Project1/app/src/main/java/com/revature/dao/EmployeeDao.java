package com.revature.dao;

import com.revature.models.Employee;
import com.revature.utils.ConnectionSingleton;

import java.sql.*;
import java.util.List;


public class EmployeeDao implements IEmployeeDao {
    public ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleton();

    @Override
    public void createEmployee(Employee em) {

        Connection c = cs.getConnection();

        String sql = "insert into employees (first_name, last_name, email, password, user_roles) values " +
                "('" + em.getFirstName() + "','" + em.getLastName() + "','" + em.getEmail() + "','" + em.getPassword() + "','" + em.getUserRole() + "')";

        try {
            Statement s = c.createStatement();
            s.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employee> readAllEmployees() {
        return null;
    }

    @Override
    public Employee readEmployeeByEmail(String email) {

        Connection c = cs.getConnection();
        String sql = "SELECT * FROM employee WHERE email = ?";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            Employee loggedIn = null;
            while (rs.next()) {
                loggedIn = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }

            return loggedIn;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee updateEmployee(Employee em) {

        Connection c = cs.getConnection();
        String sql = "UPDATE employee " +
                "SET first_name = ?, " + //index 1
                "last_name = ?, " + //index 2
                "email = ?, " + //index 3
                "password = ? " + //index 4s
                "WHERE employee_id = ?" + //index 5
                "user_roles = ?"; //index 6

        try{
            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, em.getFirstName());
            p.setString(2, em.getLastName());
            p.setString(3, em.getEmail());
            p.setString(4, em.getPassword());
            p.setInt(5, em.getEmpolyeeId());
            p.setInt(6, em.getUserRole());

            p.execute();

            return em;

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteEmployee(Employee em) {
        Connection c = cs.getConnection();

        String sql = "DELETE FROM employee WHERE employee_id = ?";

        try{
            PreparedStatement p = c.prepareStatement(sql);

            p.setInt(1, em.getEmpolyeeId());

            p.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



    }
