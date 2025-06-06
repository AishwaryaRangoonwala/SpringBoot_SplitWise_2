package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.GroupController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddMemberRequestDtoV2;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddMemberResponseDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddMemberResponseDtoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//addMemberToGroupV2 groupId memberId
@Component
public class AddMemberToGroupCommandV2 implements Command {

    @Autowired
    private GroupController groupController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() == 3 &&
                commandSubStr.get(0).equalsIgnoreCase("addMemberToGroupV2");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        try {
            AddMemberRequestDtoV2 requestDTO = new AddMemberRequestDtoV2();
            requestDTO.setGroupId(Long.parseLong(commandSubStr.get(1)));
            requestDTO.setMemberId(Long.parseLong(commandSubStr.get(2)));
            AddMemberResponseDtoV2 responseDTO = groupController.addMemberToGroupV2(requestDTO);
            System.out.println(responseDTO.getResponseStatus());
        }
        catch (Exception e) {
            System.out.println("Command Error : " + e.getMessage());
        }
    }
}
