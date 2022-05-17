package com.revature.dao;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionSingleton;
import com.revature.dao.EmployeeDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDao implements IReimbursemnetDao {

    public ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleton();

    @Override //Create
    public void createReimbursement(Reimbursement r) {
        Connection c = cs.getConnection();

        String sql = "insert into reimbursement (amount, submitted_date, description, reimbursement_author, reimbursement_status, reimbursement_type) values (?,?,?,?,?,?)";

        try {
            PreparedStatement p = c.prepareStatement(sql);

            p.setDouble(1, r.getAmount());
            p.setDate(2, (Date) r.getSubmittedDate());
            p.setString(3, r.getDescription());
            p.setInt(4, r.getReimbursementAuthor());
            p.setInt(5, r.getReimbursementStatus());
            p.setInt(6, r.getReimbursementType() );

            p.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override //Read
    public List<Reimbursement> readAllReimbursement() {

        Connection c = cs.getConnection();
        String sql ="SELECT * FROM reimbursement";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Reimbursement> aList = new ArrayList<>();
            while(rs.next()){
                Reimbursement r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getDate(3), rs.getDate(4),rs.getString(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));

                aList.add(r);
            }

            return aList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
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
                Employee e = new Employee(rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getInt(10));

                Reimbursement r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getDate(3), rs.getDate(4),rs.getString(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));

                aList.add(r);
            }

            return aList;

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public Reimbursement updateReimbursement(Reimbursement r) {
        Connection c = cs.getConnection();
        String sql = "UPDATE reimbursement " +
                "SET amount = ?, " + //index 1
<<<<<<< HEAD
                "resolved_date = ?, " + //index 2
                "description = ?, " + //index 3
                "reimbursement_resolver = ?, " + //index 4
                "reimbursement_status = ? " + //index 5
                "WHERE reimbursement_type = ? "; //index 6

=======
                "resolved_date = ? ," + //index 2
                "description = ? ," + //index 3
                "reimbursement_resolver = ?," + //index 4
                "reimbursement_status = ?" + //index 5
                "where reimbursement_id = ?"; //index 6
>>>>>>> cbacf33da00468645ca0eb4085b0e523a9583e43

        try{
            PreparedStatement p = c.prepareStatement(sql);


            p.setDouble(1, r.getAmount());
            p.setDate(2, r.getResolvedDate());
            p.setString(3, r.getDescription());
<<<<<<< HEAD
            p.setInt(4, r.getReimbursementResolver().getEmpolyeeId());
            p.setInt(5, r.getReimbursementStatus());
            p.setInt(6, r.getReimbursementType());
=======
            p.setInt(4, r.getReimbursementResolver());
            System.out.println(r.getReimbursementResolver());
            p.setInt(5, r.getReimbursementStatus());
            p.setInt(6, r.getReimbursementId());
>>>>>>> cbacf33da00468645ca0eb4085b0e523a9583e43

            p.execute();
            return r;

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    }

