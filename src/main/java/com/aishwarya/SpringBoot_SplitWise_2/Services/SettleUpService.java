package com.aishwarya.SpringBoot_SplitWise_2.Services;

import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidGroupException;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidUserException;
import com.aishwarya.SpringBoot_SplitWise_2.Models.Transaction;

import java.util.List;

public interface SettleUpService {
    public List<Transaction> settleGroup(long groupId) throws InvalidGroupException;

    public List<Transaction> settleUser(long userId) throws InvalidUserException;
}
