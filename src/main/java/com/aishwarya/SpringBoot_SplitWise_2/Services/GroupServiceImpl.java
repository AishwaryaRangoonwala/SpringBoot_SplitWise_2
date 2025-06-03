package com.aishwarya.SpringBoot_SplitWise_2.Services;

import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidGroupException;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidUserException;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.UnAuthorizedAccessException;
import com.aishwarya.SpringBoot_SplitWise_2.Models.Group;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Override
    public Group createGroup(String groupName, String description, long userId) throws InvalidUserException {
        return null;
    }

    @Override
    public void deleteGroup(long groupId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException {

    }
}
