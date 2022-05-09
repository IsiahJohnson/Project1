package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;

public interface IReimbursemnetDao {

    public void createReimbursement(Reimbursement r);

    public List<Reimbursement> readAllReimbursement();

    public List<Reimbursement> readReimbursementsByUser(int id);

    public Reimbursement update();

    public void deleteReimbursement(Reimbursement r);


    public void insertReimbursementStatus(boolean status, int statusId);

    public void insertReimbursementType(string type, int typeId);
}
