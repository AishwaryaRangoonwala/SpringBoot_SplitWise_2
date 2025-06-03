package com.aishwarya.SpringBoot_SplitWise_2.Controllers;

import com.aishwarya.SpringBoot_SplitWise_2.DTOs.CreateUserRequestDTO;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.CreateUserResponseDTO;
import com.aishwarya.SpringBoot_SplitWise_2.Enums.ResponseStatus;
import com.aishwarya.SpringBoot_SplitWise_2.Models.User;
import com.aishwarya.SpringBoot_SplitWise_2.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    public CreateUserResponseDTO createUser(CreateUserRequestDTO requestDTO) {
        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();
        try {
            User user = userService.createUser(requestDTO.getName(), requestDTO.getPhoneNumber());
            responseDTO.setUser(user);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            System.out.println("Error in createUserController: " + e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
