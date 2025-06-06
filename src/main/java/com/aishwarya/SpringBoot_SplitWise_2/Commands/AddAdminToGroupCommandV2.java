package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.GroupController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddAdminRequestDtoV2;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.AddAdminResponseDtoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//addAdminToGroupV2 groupId memberId
@Component
public class AddAdminToGroupCommandV2 implements Command {

    @Autowired
    private GroupController groupController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() == 3 &&
                commandSubStr.get(0).equalsIgnoreCase("addAdminToGroupV2");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        try {
            AddAdminRequestDtoV2 requestDTO = new AddAdminRequestDtoV2();
            requestDTO.setGroupId(Long.parseLong(commandSubStr.get(1)));
            requestDTO.setAdminId(Long.parseLong(commandSubStr.get(2)));
            AddAdminResponseDtoV2 responseDTO = groupController.addAdminToGroupV2(requestDTO);
            System.out.println(responseDTO.getResponseStatus());
        } catch (Exception e) {
            System.out.println("Error in command: " + e.getMessage());
        }
    }
}
