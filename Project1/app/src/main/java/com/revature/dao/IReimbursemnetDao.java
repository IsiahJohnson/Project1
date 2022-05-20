package com.revature.dao;

import com.revature.models.Reimbursement;

import java.util.List;

public interface IReimbursemnetDao {

    public void createReimbursement(Reimbursement r);

    public List<Reimbursement> readAllReimbursement();

    public List<Reimbursement> getPendingReimbursement(int id);

    public List<Reimbursement> getReolvedReibursement(int id);

    public List<Reimbursement> readReimbursementByUser(int id);

    public Reimbursement getReimbursementById(int id);


    public Reimbursement updateReimbursement(Reimbursement r);
}
