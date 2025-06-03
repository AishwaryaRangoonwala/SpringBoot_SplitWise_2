package com.aishwarya.SpringBoot_SplitWise_2.Services;

import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidGroupException;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.InvalidUserException;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.MemberAlreadyExistsException;
import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.UnAuthorizedAccessException;
import com.aishwarya.SpringBoot_SplitWise_2.Models.Group;
import com.aishwarya.SpringBoot_SplitWise_2.Models.GroupMember;

public interface GroupService {

    public Group createGroup(String groupName, String description, long userId) throws InvalidUserException;

    public void deleteGroup(long groupId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException;

    public GroupMember addMember(long groupId, long adminId, long userId) throws InvalidGroupException, InvalidUserException, UnAuthorizedAccessException, MemberAlreadyExistsException;
}
