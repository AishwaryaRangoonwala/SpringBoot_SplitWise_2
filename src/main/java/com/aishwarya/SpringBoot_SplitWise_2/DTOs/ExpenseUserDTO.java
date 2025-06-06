package com.aishwarya.SpringBoot_SplitWise_2.DTOs;

import com.aishwarya.SpringBoot_SplitWise_2.Enums.ExpenseType;
import lombok.Data;

@Data
public class ExpenseUserDTO {
    private Double amount;
    private Long userId;
    private ExpenseType expenseType;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
}
