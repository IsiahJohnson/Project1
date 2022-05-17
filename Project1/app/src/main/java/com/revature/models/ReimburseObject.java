package com.revature.models;

public class ReimburseObject {
    public double amount;
    public String description;
    public int status;
    public int type;

    @Override
    public String toString() {
        return "ReimburseObject{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
