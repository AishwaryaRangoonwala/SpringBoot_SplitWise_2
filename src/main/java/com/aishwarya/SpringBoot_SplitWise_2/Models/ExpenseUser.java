package com.aishwarya.SpringBoot_SplitWise_2.Models;

import com.aishwarya.SpringBoot_SplitWise_2.Enums.ExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "s_user_expense")
public class ExpenseUser extends BaseModel{
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
}
