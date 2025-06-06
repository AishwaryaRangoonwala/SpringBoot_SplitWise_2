package com.aishwarya.SpringBoot_SplitWise_2.DTOs;

import lombok.Data;

@Data
public class AddAdminRequestDtoV2 {
    private Long groupId;
    private Long adminId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
