package models;

import java.util.Date;

public class Reimbursement {
    private double amount;
    private Date submittedDate;
    private Date resolvedDate;
    private String description;
    private int reimbursementAuthor;
    private int reimbursementResolver;

    public Reimbursement(){

    }

    public Reimbursement(double amount, Date submittedDate, Date resolvedDate, String description, int reimbursementAuthor, int reimbursementResolver) {
        this.amount = amount;
        this.submittedDate = submittedDate;
        this.resolvedDate = resolvedDate;
        this.description = description;
        this.reimbursementAuthor = reimbursementAuthor;
        this.reimbursementResolver = reimbursementResolver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReimbursementAuthor() {
        return reimbursementAuthor;
    }

    public void setReimbursementAuthor(int reimbursementAuthor) {
        this.reimbursementAuthor = reimbursementAuthor;
    }

    public int getReimbursementResolver() {
        return reimbursementResolver;
    }

    public void setReimbursementResolver(int reimbursementResolver) {
        this.reimbursementResolver = reimbursementResolver;
    }
}
