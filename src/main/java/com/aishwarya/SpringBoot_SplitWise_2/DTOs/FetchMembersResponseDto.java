package com.aishwarya.SpringBoot_SplitWise_2.DTOs;

import com.aishwarya.SpringBoot_SplitWise_2.Enums.ResponseStatus;
import com.aishwarya.SpringBoot_SplitWise_2.Models.User;
import lombok.Data;

import java.util.List;

@Data
public class FetchMembersResponseDto {

    private List<User> members;
    private ResponseStatus responseStatus;

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
