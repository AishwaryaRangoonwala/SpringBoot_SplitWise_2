package com.aishwarya.SpringBoot_SplitWise_2.DTOs;

import lombok.Data;

@Data
public class SettleUserRequestDto {
    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
