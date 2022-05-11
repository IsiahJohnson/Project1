package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;

import java.util.List;

public interface IReimbursemnetDao {

    public void createReimbursement(Reimbursement r);

    public List<Reimbursement> readAllReimbursement();

    public List<Reimbursement> readReimbursementByUser(int id);

    public Reimbursement update();

    public void deleteReimbursement(Reimbursement r);


    public Reimbursement updateReimbursement(Reimbursement r);
}
