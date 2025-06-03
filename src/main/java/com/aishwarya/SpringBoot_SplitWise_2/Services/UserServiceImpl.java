package com.aishwarya.SpringBoot_SplitWise_2.Services;

import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.UserAlreadyExistsException;
import com.aishwarya.SpringBoot_SplitWise_2.Models.User;
import com.aishwarya.SpringBoot_SplitWise_2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(String name, String phoneNumber) throws UserAlreadyExistsException {
        Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);
        if (userOptional.isPresent()) throw new UserAlreadyExistsException("User Already Exists!");
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }
}
