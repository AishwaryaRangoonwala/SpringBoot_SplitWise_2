package com.aishwarya.SpringBoot_SplitWise_2.DTOs;

import com.aishwarya.SpringBoot_SplitWise_2.Enums.ResponseStatus;
import lombok.Data;

@Data
public class RemoveMemberResponseDto {
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
