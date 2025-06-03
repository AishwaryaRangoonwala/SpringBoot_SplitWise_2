package com.aishwarya.SpringBoot_SplitWise_2.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity (name = "s_user")
public class User extends BaseModel {
    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
