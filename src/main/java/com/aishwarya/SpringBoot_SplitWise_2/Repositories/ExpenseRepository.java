package com.aishwarya.SpringBoot_SplitWise_2.Repositories;

import com.aishwarya.SpringBoot_SplitWise_2.Models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

   @Query("Select e from s_expense e inner join s_user_expense eu on e.id = eu.expense.id and eu.user.id = :userId left join s_group_expense ge on e.id = ge.expense.id where ge.id is null")
   List<Expense> findNonGroupExpensesForUser(@Param("userId") Long userId);
}
