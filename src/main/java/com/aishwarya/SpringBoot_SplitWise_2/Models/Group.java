package com.aishwarya.SpringBoot_SplitWise_2.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity (name = "s_group")
public class Group extends BaseModel {
    private String name;
    private String description;
    private Date createdAt;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users;
    // The below fields is incorrect as admins are stored in GroupAdmin model
    @ManyToMany(fetch = FetchType.EAGER)
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getAdmins() {
        return admins;
    }

    public void setAdmins(List<User> admins) {
        this.admins = admins;
    }
}
