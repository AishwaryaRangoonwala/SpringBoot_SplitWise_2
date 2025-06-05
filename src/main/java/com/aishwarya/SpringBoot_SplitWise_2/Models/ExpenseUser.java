package com.aishwarya.SpringBoot_SplitWise_2.Models;

import com.aishwarya.SpringBoot_SplitWise_2.Enums.ExpenseType;
import lombok.Data;

@Data
public class ExpenseUser extends BaseModel{
    private Expense expense;
    private User user;
    private double amount;
    private ExpenseType expenseType;
}
