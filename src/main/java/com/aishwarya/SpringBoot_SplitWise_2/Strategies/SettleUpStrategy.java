package com.aishwarya.SpringBoot_SplitWise_2.Strategies;

import com.aishwarya.SpringBoot_SplitWise_2.Models.Transaction;
import com.aishwarya.SpringBoot_SplitWise_2.Models.User;

import java.util.List;
import java.util.Map;

public interface SettleUpStrategy {
    List<Transaction> settleUpGroup(Map<User, Double> balanceMap);
}
