package com.aishwarya.SpringBoot_SplitWise_2.Services;

import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidGroupException;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidUserException;
import com.aishwarya.SpringBoot_SplitWise_2.Models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettleUpServiceImpl implements SettleUpService {
    @Override
    public List<Transaction> settleGroup(long groupId) throws InvalidGroupException {
        return List.of();
    }

    @Override
    public List<Transaction> settleUser(long userId) throws InvalidUserException {
        return List.of();
    }
}
