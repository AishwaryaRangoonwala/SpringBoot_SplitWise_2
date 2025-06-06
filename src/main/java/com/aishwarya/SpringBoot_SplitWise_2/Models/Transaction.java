package com.aishwarya.SpringBoot_SplitWise_2.Models;

import lombok.Data;

@Data
public class Transaction extends BaseModel{
    private User paidFrom;
    private User paidTo;
    private double amount;

    public User getPaidFrom() {
        return paidFrom;
    }

    public void setPaidFrom(User paidFrom) {
        this.paidFrom = paidFrom;
    }

    public User getPaidTo() {
        return paidTo;
    }

    public void setPaidTo(User paidTo) {
        this.paidTo = paidTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
