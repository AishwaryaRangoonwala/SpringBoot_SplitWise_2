package com.aishwarya.SpringBoot_SplitWise_2.Repositories;

import com.aishwarya.SpringBoot_SplitWise_2.Models.GroupAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupAdminRepository extends JpaRepository<GroupAdmin, Long> {
    public Optional<GroupAdmin> findByGroupIdAndAdminId(Long groupId, Long adminId);
    public void deleteByGroupId(Long groupId);
}
