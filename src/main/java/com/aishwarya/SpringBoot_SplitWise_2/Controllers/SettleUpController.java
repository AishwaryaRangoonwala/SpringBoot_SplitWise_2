package com.aishwarya.SpringBoot_SplitWise_2.Controllers;

import com.aishwarya.SpringBoot_SplitWise_2.Enums.ResponseStatus;
import com.aishwarya.SpringBoot_SplitWise_2.Models.Transaction;
import com.aishwarya.SpringBoot_SplitWise_2.Services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.SettleGroupRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.SettleGroupResponseDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.SettleUserRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.SettleUserResponseDto;

import java.util.List;

@Controller
public class SettleUpController {

    @Autowired
    private SettleUpService settleUpService;

    public SettleGroupResponseDto settleGroup(SettleGroupRequestDto dto){
        SettleGroupResponseDto responseDTO = new SettleGroupResponseDto();
        try {
           List<Transaction> transactionList =  settleUpService.settleGroup(dto.getGroupId());
           responseDTO.setTransactions(transactionList);
           responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e) {
            System.out.println("Error in settleGroupController: " + e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    public SettleUserResponseDto settleUser(SettleUserRequestDto requestDto){
        SettleUserResponseDto responseDTO = new SettleUserResponseDto();
        try {
            List<Transaction> transactionList = settleUpService.settleUser(requestDto.getUserId());
            responseDTO.setTransactions(transactionList);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
