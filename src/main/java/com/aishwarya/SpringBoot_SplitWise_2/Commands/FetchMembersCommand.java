package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import com.aishwarya.SpringBoot_SplitWise_2.Controllers.GroupController;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.FetchMembersRequestDto;
import com.aishwarya.SpringBoot_SplitWise_2.DTOs.FetchMembersResponseDto;
import com.aishwarya.SpringBoot_SplitWise_2.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// fetchMembersOfAGroup groupId memberId
@Component
public class FetchMembersCommand implements Command {
    @Autowired
    private GroupController groupController;

    @Override
    public boolean matches(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        return commandSubStr.size() == 3 &&
                commandSubStr.get(0).equalsIgnoreCase("fetchMembersOfAGroup");
    }

    @Override
    public void execute(String input) {
        List<String> commandSubStr = getCommandSubStr(input);
        FetchMembersRequestDto requestDTO = new FetchMembersRequestDto();
        requestDTO.setGroupId(Long.parseLong(commandSubStr.get(1)));
        requestDTO.setMemberId(Long.parseLong(commandSubStr.get(2)));
        FetchMembersResponseDto responseDTO = groupController.fetchMembers(requestDTO);
        for (User user: responseDTO.getMembers()) {
            System.out.println(user.getId() + " | " + user.getName() + " | " + user.getPhoneNumber());
        }
        System.out.println(responseDTO.getResponseStatus());
    }
}
