package com.aishwarya.SpringBoot_SplitWise_2.Repositories;

import com.aishwarya.SpringBoot_SplitWise_2.Models.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
}
