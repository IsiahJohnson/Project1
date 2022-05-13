package com.revature.models;

import java.sql.Date;

public class Reimbursement {

    private int reimbursementId;
    private double amount;
    private Date submittedDate;
    private Date resolvedDate;
    private String description;
    private Employee reimbursementAuthor;
    private Employee reimbursementResolver;
    private int reimbursementStatus;
    private int reimbursementType;

    public Reimbursement(){

    }

    public Reimbursement(double amount, Date submittedDate, String description, Employee reimbursementAuthor, int reimbursementStatus, int reimbursementType) {
        this.amount = amount;
        this.submittedDate = submittedDate;
        this.description = description;
        this.reimbursementAuthor = reimbursementAuthor;
        this.reimbursementStatus = reimbursementStatus;
        this.reimbursementType = reimbursementType;
    }

    public Reimbursement(double amount, Date submittedDate, Date resolvedDate, String description, Employee reimbursementAuthor) {
        this.amount = amount;
        this.submittedDate = submittedDate;
        this.resolvedDate = resolvedDate;
        this.description = description;
        this.reimbursementAuthor = reimbursementAuthor;
    }


    public Reimbursement(double amount, Date submittedDate, String description, Employee reimbursementAuthor) {
        this.amount = amount;
        this.submittedDate = submittedDate;
        this.description = description;
        this.reimbursementAuthor = reimbursementAuthor;
    }

    public Reimbursement(double amount, Date submittedDate, String description, Employee reimbursementAuthor, int reimbursementType) {
        this.amount = amount;
        this.submittedDate = submittedDate;
        this.description = description;
        this.reimbursementAuthor = reimbursementAuthor;
        this.reimbursementType = reimbursementType;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
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

    public Employee getReimbursementAuthor() {
        return reimbursementAuthor;
    }

    public void setReimbursementAuthor(Employee reimbursementAuthor) {
        this.reimbursementAuthor = reimbursementAuthor;
    }

    public Employee getReimbursementResolver() {
        return reimbursementResolver;
    }

    public void setReimbursementResolver(Employee reimbursementResolver) {
        this.reimbursementResolver = reimbursementResolver;
    }

    public int getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(int reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    public int getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(int reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Reimbursement{" +
                "amount=" + amount +
                ", submittedDate=" + submittedDate +
                ", resolvedDate=" + resolvedDate +
                ", description='" + description + '\'' +
                ", reimbursementAuthor=" + reimbursementAuthor +
                ", reimbursementResolver=" + reimbursementResolver +
                ", reimbursementStatus=" + reimbursementStatus +
                ", reimbursementType=" + reimbursementType +
                '}';
    }
}
