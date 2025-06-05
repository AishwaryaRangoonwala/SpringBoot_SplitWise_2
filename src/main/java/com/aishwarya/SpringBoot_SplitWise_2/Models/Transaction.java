package com.aishwarya.SpringBoot_SplitWise_2.Models;

import lombok.Data;

@Data
public class Transaction extends BaseModel{
    private User paidFrom;
    private User paidTo;
    private double amount;
}
