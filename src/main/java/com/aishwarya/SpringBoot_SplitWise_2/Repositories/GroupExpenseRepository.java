package com.aishwarya.SpringBoot_SplitWise_2.Repositories;

import com.aishwarya.SpringBoot_SplitWise_2.Models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long> {
}
