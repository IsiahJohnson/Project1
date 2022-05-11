package com.revature.dao;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDao implements IReimbursemnetDao {

    public ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleton();

    @Override //Create
    public void createReimbursement(Reimbursement r) {
        Connection c = cs.getConnection();

        String sql = "insert into reimbursement (amount, submitted_date, description) values " +
                "('" + r.getAmount() + "','" + r.getSubmittedDate() + "','"  + r.getDescription() + "')";

        try {
            Statement s = c.createStatement();
            s.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override //Read
    public List<Reimbursement> readAllReimbursement() {
        return null;
    }

    @Override
    public List<Reimbursement> readReimbursementByUser(int id) {

        Connection c = cs.getConnection();

        try{
            c.setAutoCommit(false);
            String sql = "{?=call get_reimbursement_by_employee(?)}";

            CallableStatement call = c.prepareCall(sql);

            call.registerOutParameter(1, Types.OTHER);

            call.setInt(2, id);

            call.execute();

            ResultSet rs = (ResultSet) call.getObject(1);

            List<Reimbursement> aList = new ArrayList<>();

            while(rs.next()){
                Employee e = new Employee(rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));

                Reimbursement r = new Reimbursement(rs.getDouble(1), rs.getDate(2), rs.getDate(3), rs.getString(4), e);

                aList.add(r);
            }

            return aList;

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Reimbursement update() {
        return null;
    }

    @Override
    public void deleteReimbursement(Reimbursement r) {
        Connection c = cs.getConnection();

        String sql = "DELETE FROM reimbursement WHERE reimbursement_id = ?";

        try{
            PreparedStatement p = c.prepareStatement(sql);

            p.setInt(1, r.getReimbursementId());

            p.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Reimbursement updateReimbursement(Reimbursement r) {
        Connection c = cs.getConnection();
        String sql = "UPDATE reimbursement " +
                "SET amount = ?, " + //index 1
                "submitted_date = ?, " + //index 2
                "resolved_date = ?, " + //index 3
                "description = ? " + //index 4s
                "WHERE reimbursement_id = ?"; //index 5

        try{
            PreparedStatement p = c.prepareStatement(sql);

            p.setDouble(1, r.getAmount());
            p.setDate(2, (Date) r.getSubmittedDate());
            p.setDate(3, (Date) r.getResolvedDate());
            p.setString(4, r.getDescription());
            p.setInt(5, r.getReimbursementId());

            p.execute();

            return r;

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    }

