package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.GroupController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.CreateGroupRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.CreateGroupResponseDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.CreateUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateGroupCommand implements Command {

    @Autowired
    private GroupController groupController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() == 4 && commandSubStr.get(0).equalsIgnoreCase("creategroup");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        CreateGroupRequestDto requestDTO = new CreateGroupRequestDto();
        requestDTO.setName(commandSubStr.get(1));
        requestDTO.setDescription(commandSubStr.get(2));
        requestDTO.setCreatorUserId(Long.parseLong(commandSubStr.get(3)));
        CreateGroupResponseDto responseDTO = groupController.createGroup(requestDTO);
        System.out.println(responseDTO.getResponseStatus());
    }
}
