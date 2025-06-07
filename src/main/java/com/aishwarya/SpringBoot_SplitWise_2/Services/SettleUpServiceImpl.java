package com.aishwarya.SpringBoot_SplitWise_2.Services;

import com.aishwarya.SpringBoot_SplitWise_2.Enums.ExpenseType;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidGroupException;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidUserException;
import com.aishwarya.SpringBoot_SplitWise_2.Models.*;
import com.aishwarya.SpringBoot_SplitWise_2.Repositories.*;
import com.aishwarya.SpringBoot_SplitWise_2.Strategies.HeapSettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpServiceImpl implements SettleUpService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupExpenseRepository groupExpenseRepository;
    @Autowired
    private ExpenseUserRepository expenseUserRepository;
    @Autowired
    private HeapSettleUpStrategy heapSettleUpStrategy;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Transaction> settleGroup(long groupId) throws InvalidGroupException {
        // InvalidGroupException
        groupRepository.findById(groupId).orElseThrow(() -> new InvalidGroupException("Group Not Found!"));
        // GroupExpenseRepository : Get list of expenses for a group
        List<GroupExpense> groupExpenseList = groupExpenseRepository.findByGroupId(groupId);

        Map<User,Double> balanceMap = new HashMap<>();

        // Loop through the expenses of a group
        for (GroupExpense groupExpense : groupExpenseList) {
            // For each expense, loop through the userExpense
            List<ExpenseUser> userExpenseList = expenseUserRepository.findByExpenseId(groupExpense.getExpense().getId());
            // for each user expense, create/update entry in balanceMap
            generateBalanceMap(userExpenseList, balanceMap);
        }
        return heapSettleUpStrategy.settleUpGroup(balanceMap);
    }

    @Override
    public List<Transaction> settleUser(long userId) throws InvalidUserException {
        userRepository.findById(userId).orElseThrow(() -> new InvalidUserException("User Not Found!"));
        List<Expense> expenseList = expenseRepository.findNonGroupExpensesForUser(userId);
        Map<User, Double> balanceMap = new HashMap<>();
        for (Expense expense : expenseList) {
            List<ExpenseUser> userExpenseList = expenseUserRepository.findByExpenseId(expense.getId());
            generateBalanceMap(userExpenseList, balanceMap);
        }
        return heapSettleUpStrategy.settleUpGroup(balanceMap);
    }

    public void generateBalanceMap(List<ExpenseUser> userExpenseList, Map<User, Double> balanceMap) {
        for (ExpenseUser userExpense : userExpenseList) {
            User user = userExpense.getUser();
            Double currAmount = userExpense.getExpenseType().equals(ExpenseType.OWED) ? (-1 * userExpense.getAmount()) : userExpense.getAmount();
            balanceMap.putIfAbsent(user, 0.0);
            balanceMap.put(userExpense.getUser(), balanceMap.get(user) + currAmount);
        }
    }
}
