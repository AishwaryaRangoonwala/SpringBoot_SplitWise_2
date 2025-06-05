package com.aishwarya.SpringBoot_SplitWise_2.Models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity (name = "s_group")
public class Group extends BaseModel {
    private String name;
    private String description;
    private Date createdAt;
    // new attributes for settle up flow added below
    private List<User> users;
    private List<User> admins;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
