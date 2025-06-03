package com.aishwarya.SpringBoot_SplitWise_2.DTOs;

import lombok.Data;

@Data
public class RemoveMemberRequestDto {

    private long groupId;
    private long adminId;
    private long memberId;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}
