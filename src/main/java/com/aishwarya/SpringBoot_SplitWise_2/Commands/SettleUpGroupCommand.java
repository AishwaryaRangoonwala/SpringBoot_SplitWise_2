package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.SettleUpController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.SettleGroupRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.SettleGroupResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// settleUpGroup groupId
@Component
public class SettleUpGroupCommand implements  Command {
    @Autowired
    private SettleUpController settleUpController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() == 2 &&
                commandSubStr.get(0).equalsIgnoreCase("settleUpGroup");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        try {
            SettleGroupRequestDto requestDTO = new SettleGroupRequestDto();
            requestDTO.setGroupId(Long.parseLong(commandSubStr.get(1)));
            SettleGroupResponseDto responseDTO = settleUpController.settleGroup(requestDTO);
            System.out.println(responseDTO.getResponseStatus());
        }
        catch (Exception e) {
            System.out.println("Command Error: " + e.getMessage());
        }
    }
}
