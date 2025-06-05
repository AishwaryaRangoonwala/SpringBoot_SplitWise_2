package com.aishwarya.SpringBoot_SplitWise_2.Models;

import lombok.Data;

@Data
public class GroupExpense extends BaseModel{
    private Group group;
    private Expense expense;
}
