package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.ExpenseController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddExpenseRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddExpenseResponseDTO;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.ExpenseUserDTO;
import com.aishwarya.SpringBoot_SplitWise_2.Enums.ExpenseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//addExpense expenseAmount groupId
//expenseUser1_userId expenseUser1_amount expenseUser1_type
//expenseUser2_userId expenseUser2_amount expenseUser2_type ...
//expenseUser1_userId expenseUserN_amount expenseUserN_type
@Component
public class AddExpenseCommand implements Command {

    @Autowired
    private ExpenseController expenseController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() >= 6 &&
                commandSubStr.get(0).equalsIgnoreCase("addExpense");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        try {
            AddExpenseRequestDto requestDTO = new AddExpenseRequestDto();
            requestDTO.setTotalAmount(Double.parseDouble(commandSubStr.get(1)));
            if (!commandSubStr.get(2).equals("null")) requestDTO.setGroupId(Long.parseLong(commandSubStr.get(2)));
            List<ExpenseUserDTO> expenseUserDTOList = new ArrayList<>();
            for (int i = 3; i < commandSubStr.size(); i+=3) {
                ExpenseUserDTO expenseUser = new ExpenseUserDTO();
                expenseUser.setUserId(Long.parseLong(commandSubStr.get(i)));
                expenseUser.setAmount(Double.parseDouble(commandSubStr.get(i+1)));
                expenseUser.setExpenseType(ExpenseType.valueOf(commandSubStr.get(i+2)));
                expenseUserDTOList.add(expenseUser);
            }
            requestDTO.setExpenseUserRequestDTOList(expenseUserDTOList);
            AddExpenseResponseDTO responseDTO = expenseController.addExpense(requestDTO);
            System.out.println(responseDTO.getResponseStatus());
        } catch (Exception e) {
            System.out.println("Error in Command: " + e.getMessage());
        }
    }
}
