package com.revature.models;

import java.util.Date;

public class Reimbursement {
    private double amount;
    private Date submittedDate;
    private Date resolvedDate;
    private String description;
    private Employee reimbursementAuthor;
    private Employee reimbursementResolver;
    private ReimbursementStatus reimbursementStatus;
    private ReimbursementType reimbursementType;

    public Reimbursement(){

    }


    public Reimbursement(double amount, Date submittedDate, Date resolvedDate, String description, Employee reimbursementAuthor, Employee reimbursementResolver, ReimbursementStatus reimbursementStatus, ReimbursementType reimbursementType) {
        this.amount = amount;
        this.submittedDate = submittedDate;
        this.resolvedDate = resolvedDate;
        this.description = description;
        this.reimbursementAuthor = reimbursementAuthor;
        this.reimbursementResolver = reimbursementResolver;
        this.reimbursementStatus = reimbursementStatus;
        this.reimbursementType = reimbursementType;
    }

    public Reimbursement(double amount, Date submittedDate, Date resolvedDate, String description) {
        this.amount = amount;
        this.submittedDate = submittedDate;
        this.resolvedDate = resolvedDate;
        this.description = description;
    }

    public Reimbursement(double amount, Date submittedDate, Date resolvedDate, String description, Employee reimbursementAuthor) {
        this.amount = amount;
        this.submittedDate = submittedDate;
        this.resolvedDate = resolvedDate;
        this.description = description;
        this.reimbursementAuthor = reimbursementAuthor;
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

    public ReimbursementStatus getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(ReimbursementStatus reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    public ReimbursementType getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(ReimbursementType reimbursementType) {
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
