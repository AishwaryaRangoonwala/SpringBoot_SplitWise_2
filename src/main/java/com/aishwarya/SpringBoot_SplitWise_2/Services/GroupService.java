package com.aishwarya.SpringBoot_SplitWise_2.Services;

import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.*;
import com.aishwarya.SpringBoot_SplitWise_2.Models.Group;
import com.aishwarya.SpringBoot_SplitWise_2.Models.GroupMember;
import com.aishwarya.SpringBoot_SplitWise_2.Models.User;

import java.util.List;

public interface GroupService {

    public Group createGroup(String groupName, String description, long userId) throws InvalidUserException;

    public void deleteGroup(long groupId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException;

    public GroupMember addMember(long groupId, long adminId, long userId) throws InvalidGroupException, InvalidUserException, UnAuthorizedAccessException, MemberAlreadyExistsException;

    public void removeMember(long groupId, long adminId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException, GroupAdminSelfRemovalException;

    public List<User> fetchAllMembers(long groupId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException;
}
