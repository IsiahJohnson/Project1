package com.revature.models;

public class ReimburseObject {
    public double amount;
    public String description;
    public int type;

    @Override
    public String toString() {
        return "ReimburseObject{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
