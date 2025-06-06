package com.aishwarya.SpringBoot_SplitWise_2.Services;

import com.aishwarya.SpringBoot_SplitWise_2.DTOs.ExpenseUserDTO;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidGroupException;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidUserException;
import com.aishwarya.SpringBoot_SplitWise_2.Models.*;
import com.aishwarya.SpringBoot_SplitWise_2.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupExpenseRepository groupExpenseRepository;
    @Autowired
    private ExpenseUserRepository expenseUserRepository;

    public void addExpense(Long groupId, Double finalAmount, List<ExpenseUserDTO> expenseUserDTOList) throws InvalidGroupException, InvalidUserException {
        Optional<Group> groupOptional = Optional.empty();
        if (groupId != null) {
            groupOptional = groupRepository.findById(groupId);
            if (groupOptional.isEmpty()) throw new InvalidGroupException("Group Not Found!");
        }
        for (ExpenseUserDTO expenseUserDTO : expenseUserDTOList) {
            User user = userRepository.findById(expenseUserDTO.getUserId()).orElseThrow(() -> new InvalidUserException("User Not Found!"));
        }
        Expense expense = new Expense();
        expense.setAmount(finalAmount);
        expense.setAddedAt(new Date());
        Expense savedExpense = expenseRepository.save(expense);
        for (ExpenseUserDTO expenseUserDTO : expenseUserDTOList) {
            User user = userRepository.findById(expenseUserDTO.getUserId()).orElseThrow(() -> new InvalidUserException("User Not Found!"));
            ExpenseUser expenseUser = new ExpenseUser();
            expenseUser.setUser(user);
            expenseUser.setAmount(expenseUserDTO.getAmount());
            expenseUser.setExpenseType(expenseUserDTO.getExpenseType());
            expenseUser.setExpense(savedExpense);
            expenseUserRepository.save(expenseUser);
        }

        if (groupOptional.isPresent()) {
            GroupExpense groupExpense = new GroupExpense();
            groupExpense.setGroup(groupOptional.get());
            groupExpense.setExpense(savedExpense);
            groupExpenseRepository.save(groupExpense);
        }
    }
}
