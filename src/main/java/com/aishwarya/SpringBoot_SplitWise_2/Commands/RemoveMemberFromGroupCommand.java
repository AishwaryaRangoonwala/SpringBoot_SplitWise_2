package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.GroupController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.RemoveMemberRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.RemoveMemberResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


//removeMemberFromGroup groupId adminId memberId
@Component
public class RemoveMemberFromGroupCommand implements Command {

    @Autowired
    private GroupController groupController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() == 4 &&
                commandSubStr.get(0).equalsIgnoreCase("removeMemberFromGroup");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        RemoveMemberRequestDto requestDTO = new RemoveMemberRequestDto();
        requestDTO.setGroupId(Long.parseLong(commandSubStr.get(1)));
        requestDTO.setAdminId(Long.parseLong(commandSubStr.get(2)));
        requestDTO.setMemberId(Long.parseLong(commandSubStr.get(3)));
        RemoveMemberResponseDto responseDTO = groupController.removeMember(requestDTO);
        System.out.println(responseDTO.getResponseStatus());
    }
}
