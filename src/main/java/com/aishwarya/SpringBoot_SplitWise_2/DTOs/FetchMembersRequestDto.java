package com.aishwarya.SpringBoot_SplitWise_2.DTOs;

import lombok.Data;

@Data
public class FetchMembersRequestDto {
    private long groupId;
    private long memberId;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}
