package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.UserController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.CreateUserRequestDTO;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.CreateUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CreateUserCommand implements Command {

    @Autowired
    private UserController userController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() == 3 && commandSubStr.get(0).equalsIgnoreCase("createuser");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO();
        requestDTO.setName(commandSubStr.get(1));
        requestDTO.setPhoneNumber(commandSubStr.get(2));
        CreateUserResponseDTO responseDTO = userController.createUser(requestDTO);
        System.out.println(responseDTO.getResponseStatus());
    }
}
