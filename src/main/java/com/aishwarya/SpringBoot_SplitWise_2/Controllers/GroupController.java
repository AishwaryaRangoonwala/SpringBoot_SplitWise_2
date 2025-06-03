package com.aishwarya.SpringBoot_SplitWise_2.Controllers;

import com.aishwarya.SpringBoot_SplitWise_2.DTOs.*;
import com.aishwarya.SpringBoot_SplitWise_2.Enums.ResponseStatus;
import com.aishwarya.SpringBoot_SplitWise_2.Models.Group;
import com.aishwarya.SpringBoot_SplitWise_2.Models.GroupMember;
import com.aishwarya.SpringBoot_SplitWise_2.Services.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {

    @Autowired
    private GroupServiceImpl groupService;

    public CreateGroupResponseDto createGroup(CreateGroupRequestDto requestDto) {
        CreateGroupResponseDto responseDTO = new CreateGroupResponseDto();
        try {
            Group group = groupService.createGroup(
                    requestDto.getName(),
                    requestDto.getDescription(),
                    requestDto.getCreatorUserId());
            responseDTO.setGroup(group);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            System.out.println("Error in createGroupController: " + e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    public DeleteGroupResponseDto deleteGroup(DeleteGroupRequestDto requestDto) {
        DeleteGroupResponseDto responseDTO = new DeleteGroupResponseDto();
        try {
            groupService.deleteGroup(requestDto.getGroupId(),
                                      requestDto.getUserId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            System.out.println("Error in deleteGroupController: " + e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    public AddMemberResponseDto addMember(AddMemberRequestDto requestDto) {
        AddMemberResponseDto responseDTO = new AddMemberResponseDto();
        try {
            GroupMember groupMember = groupService.addMember(requestDto.getGroupId(),
                                   requestDto.getAdminId(),
                                   requestDto.getMemberId());
            responseDTO.setGroupMember(groupMember);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            System.out.println("Error in addMemberToGroupController: " + e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
