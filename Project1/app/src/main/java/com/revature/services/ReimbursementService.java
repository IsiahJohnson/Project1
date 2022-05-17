package com.revature.services;

import com.revature.dao.IReimbursemnetDao;
import com.revature.models.Reimbursement;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class ReimbursementService {
    private IReimbursemnetDao rd;

    public ReimbursementService(IReimbursemnetDao rd){
        this.rd = rd;
    }

    public void  createReimbursement(double amount, String description, int reimbursementAuthor, int reimbursementStatus, int reimbursementType){
        Date d = new Date(Instant.now().toEpochMilli());
        Reimbursement r = new Reimbursement(amount, d, description,reimbursementAuthor, reimbursementStatus, reimbursementType);
        rd. createReimbursement(r);
    }

    public Reimbursement updateReimbursementInfo(Reimbursement r){
        return rd.updateReimbursement(r);
    }

    public List<Reimbursement> readAllReimbursements(){
        return rd.readAllReimbursement();
    }

}
