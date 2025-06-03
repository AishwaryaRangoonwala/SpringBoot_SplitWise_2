package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.GroupController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddMemberRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddMemberResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddMemberToGroupCommand implements Command {
    @Autowired
    private GroupController groupController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() == 4 && commandSubStr.get(0).equalsIgnoreCase("addMemberToGroup");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        // addMemberToGroup groupId adminId memberId
        AddMemberRequestDto requestDTO = new AddMemberRequestDto();
        requestDTO.setGroupId(Long.parseLong(commandSubStr.get(1)));
        requestDTO.setAdminId(Long.parseLong(commandSubStr.get(2)));
        requestDTO.setMemberId(Long.parseLong(commandSubStr.get(3)));
        AddMemberResponseDto responseDTO = groupController.addMember(requestDTO);
        System.out.println(responseDTO.getResponseStatus());
    }
}
