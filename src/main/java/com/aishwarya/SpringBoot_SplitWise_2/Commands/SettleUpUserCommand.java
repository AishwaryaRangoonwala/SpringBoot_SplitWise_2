package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.SettleUpController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.SettleGroupResponseDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.SettleUserRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.SettleUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// settleUpUser userId
@Component
public class SettleUpUserCommand implements Command {

    @Autowired
    private SettleUpController settleUpController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() == 2 &&
                commandSubStr.get(0).equalsIgnoreCase("settleUpUser");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        try {
            SettleUserRequestDto requestDTO = new SettleUserRequestDto();
            requestDTO.setUserId(Long.parseLong(commandSubStr.get(1)));
            SettleUserResponseDto responseDTO = settleUpController.settleUser(requestDTO);
            System.out.println(responseDTO.getResponseStatus());
        }
        catch (Exception e) {
            System.out.println("Command Error: " + e.getMessage());
        }
    }
}
