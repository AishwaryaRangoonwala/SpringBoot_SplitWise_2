package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.GroupController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.DeleteGroupRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.DeleteGroupResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteGroupCommand implements Command {

    @Autowired
    private GroupController groupController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() == 3 && commandSubStr.get(0).equalsIgnoreCase("deleteGroup");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        DeleteGroupRequestDto requestDto = new DeleteGroupRequestDto();
        requestDto.setGroupId(Long.parseLong(commandSubStr.get(1)));
        requestDto.setUserId(Long.parseLong(commandSubStr.get(2)));
        DeleteGroupResponseDto responseDto = groupController.deleteGroup(requestDto);
        System.out.println(responseDto.getResponseStatus());
    }
}
