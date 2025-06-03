package com.aishwarya.SpringBoot_SplitWise_2.Services;

import com.aishwarya.SpringBoot_SplitWise_2.Exceptions.*;
import com.aishwarya.SpringBoot_SplitWise_2.Models.Group;
import com.aishwarya.SpringBoot_SplitWise_2.Models.GroupAdmin;
import com.aishwarya.SpringBoot_SplitWise_2.Models.GroupMember;
import com.aishwarya.SpringBoot_SplitWise_2.Models.User;
import com.aishwarya.SpringBoot_SplitWise_2.Repositories.GroupAdminRepository;
import com.aishwarya.SpringBoot_SplitWise_2.Repositories.GroupMemberRepository;
import com.aishwarya.SpringBoot_SplitWise_2.Repositories.GroupRepository;
import com.aishwarya.SpringBoot_SplitWise_2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupAdminRepository groupAdminRepository;
    @Autowired
    private GroupMemberRepository groupMemberRepository;

    @Override
    public Group createGroup(String groupName, String description, long userId) throws InvalidUserException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) throw new InvalidUserException("User Not Found!");
        Group group = new Group();
        group.setName(groupName);
        group.setDescription(description);
        group.setCreatedAt(new Date());
        Group savedGroup = groupRepository.save(group);
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.setGroup(savedGroup);
        groupAdmin.setAdmin(userOptional.get());
        groupAdmin.setAddedBy(userOptional.get());
        groupAdminRepository.save(groupAdmin);
        GroupMember groupMember = new GroupMember();
        groupMember.setUser(userOptional.get());
        groupMember.setAddedAt(new Date());
        groupMember.setGroup(savedGroup);
        groupMember.setAddedBy(userOptional.get());
        groupMemberRepository.save(groupMember);
        return group;
    }

    @Override
    @Transactional
    public void deleteGroup(long groupId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (groupOptional.isEmpty()) throw new InvalidGroupException("Group is invalid");
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) throw new InvalidUserException("User Not Found!");
        Optional<GroupAdmin> groupAdminOptional = groupAdminRepository.findByGroupIdAndAdminId(groupId, userId);
        if (groupAdminOptional.isEmpty()) throw new UnAuthorizedAccessException("User not authorized to delete the group");
        groupMemberRepository.deleteByGroupId(groupId);
        groupAdminRepository.deleteByGroupId(groupId);
        groupRepository.deleteById(groupId);
    }

    @Override
    public GroupMember addMember(long groupId, long adminId, long userId) throws
            InvalidGroupException,
            InvalidUserException,
            UnAuthorizedAccessException,
            MemberAlreadyExistsException {
        Optional<User> memberOptional = userRepository.findById(userId);
        if (memberOptional.isEmpty()) throw new InvalidUserException("User Not Found!");
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (groupOptional.isEmpty()) throw new InvalidGroupException("Group is invalid!");
        Optional<GroupAdmin> groupAdminOptional = groupAdminRepository.findByGroupIdAndAdminId(groupId, adminId);
        if (groupAdminOptional.isEmpty()) throw new UnAuthorizedAccessException("User not authorized to add member for this group!");
        Optional<GroupMember> groupMemberOptional = groupMemberRepository.findByUserId(userId);
        if (groupMemberOptional.isPresent()) throw new MemberAlreadyExistsException("Member already exists in the group!");
        GroupMember groupMember = new GroupMember();
        groupMember.setGroup(groupOptional.get());
        groupMember.setAddedBy(groupAdminOptional.get().getAdmin());
        groupMember.setUser(memberOptional.get());
        groupMember.setAddedAt(new Date());
        return groupMemberRepository.save(groupMember);
    }

    @Override
    @Transactional
    public void removeMember(long groupId, long adminId, long userId) throws
            InvalidGroupException,
            UnAuthorizedAccessException,
            InvalidUserException,
            GroupAdminSelfRemovalException {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (groupOptional.isEmpty()) throw new InvalidGroupException("Group Not Found!");
        Optional<User> adminUserOptional = userRepository.findById(adminId);
        if (adminUserOptional.isEmpty()) throw new InvalidUserException("User Not Found!");
        Optional<User> memberOptional = userRepository.findById(userId);
        if (memberOptional.isEmpty()) throw new InvalidUserException("User Not Found!");
        Optional<GroupAdmin> groupAdminOptional = groupAdminRepository.findByGroupIdAndAdminId(groupId, adminId);
        if (groupAdminOptional.isEmpty()) throw new UnAuthorizedAccessException("User Not Authorized!");
        if (adminId == userId) throw new GroupAdminSelfRemovalException("Group Admin cannot remove himself!");
        groupMemberRepository.deleteByUserId(userId);
    }

    @Override
    public List<User> fetchAllMembers(long groupId, long userId) throws
            InvalidGroupException,
            UnAuthorizedAccessException,
            InvalidUserException {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (groupOptional.isEmpty()) throw new InvalidGroupException("Group Not Found!");
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) throw new InvalidUserException("User Not Found!");
        Optional<GroupAdmin> groupAdminOptional = groupAdminRepository.findByGroupIdAndAdminId(groupId, userId);
        Optional<GroupMember> groupMemberOptional = groupMemberRepository.findByUserId(userId);
        if (groupAdminOptional.isEmpty() && groupMemberOptional.isEmpty()) throw new UnAuthorizedAccessException("User Not Authorized!");
        List<GroupMember> groupMemberList = groupMemberRepository.findAllByGroupId(groupId);
        List<GroupAdmin> groupAdminList = groupAdminRepository.findAllByGroupId(groupId);
        List<User> membersList = new ArrayList<>();
        for (GroupAdmin groupAdmin : groupAdminList) {
            membersList.add(groupAdmin.getAdmin());
        }
        for (GroupMember groupMember: groupMemberList) {
            membersList.add(groupMember.getUser());
        }
        return membersList;
    }
}
