package com.aishwarya.SpringBoot_SplitWise_2.Controllers;

import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddExpenseRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddExpenseResponseDTO;
import com.aishwarya.SpringBoot_SplitWise_2.Enums.ResponseStatus;
import com.aishwarya.SpringBoot_SplitWise_2.Services.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseServiceImpl expenseService;

    public AddExpenseResponseDTO addExpense(AddExpenseRequestDto requestDTO) {
        AddExpenseResponseDTO responseDTO = new AddExpenseResponseDTO();
        try {
            expenseService.addExpense(
                    requestDTO.getGroupId(),
                    requestDTO.getTotalAmount(),
                    requestDTO.getExpenseUserRequestDTOList()
                    );
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            System.out.println("Error in addExpenseController: " + e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
