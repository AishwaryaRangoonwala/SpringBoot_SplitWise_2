package com.aishwarya.SpringBoot_SplitWise_2.Services;

import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.UserAlreadyExistsException;
import com.aishwarya.SpringBoot_SplitWise_2.Models.User;

public interface UserService {
    public User createUser(String name, String phoneNumber) throws UserAlreadyExistsException;
}
