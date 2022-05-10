package com.revature.dao;

import com.example.models.Employee;
import com.example.utils.ConnectionSingleton;



public class EmployeeDao implements IEmployeeDao {
    public ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleton();

    @Override
    public void createEmployee(Employee e) {

        Connection c = cs.getConnection();

        String sql = "insert into employees (first_name, last_name, email, password, user_roles) values " +
                "('" + u.getFirstName() + "','" + u.getLastName() + "','" + u.getEmail() + "','" + u.getPassword() + "','" + u.getRole() + "')";

        try {
            Statement s = c.createStatement();
            s.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employee> readAllEmployee() {
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
    public Employee updateEmployee(Employee e) {

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

            p.setString(1, u.getFirstName());
            p.setString(2, u.getLastName());
            p.setString(3, u.getEmail());
            p.setString(4, u.getPassword());
            p.setInt(5, u.getEmployeeId());
            p.setObject(6, u.getUserRole());

            p.execute();

            return u;

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteEmployee(Employee e) {
        Connection c = cs.getConnection();

        String sql = "DELETE FROM employee WHERE employee_id = ?";

        try{
            PreparedStatement p = c.prepareStatement(sql);

            p.setInt(1, u.getEmployeeId());

            p.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertFollowing(String role , int roleId) {

        Connection c = cs.getConnection();
        try{

            String sql = "insert into user_roles values(?,?)";

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, role);
            ps.setInt(2, roleId);

            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}