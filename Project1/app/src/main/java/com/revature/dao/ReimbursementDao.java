package com.revature.dao;

public class ReimbursementDao implements IReimbursementDao {

    public ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleton();

    @Override //Create
    public void createReimbursement(Reimbursement r) {
        Connection c = cs.getConnection();

        String sql = "insert into reimbursement (amount, submitted_date, resolved_date, description) values " +
                "('" + r.getAmount() + "','" + r.getSubmittedDate() + "','" + r.getResolvedDate() + "','" + r.getDescription() + "')";

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

            List<Post> aList = new ArrayList<>();

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

}