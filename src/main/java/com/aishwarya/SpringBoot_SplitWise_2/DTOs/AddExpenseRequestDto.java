package com.aishwarya.SpringBoot_SplitWise_2.DTOs;

import lombok.Data;

import java.util.List;


//addExpense expenseAmount groupId
//expenseUser1_userId expenseUser1_amount expenseUser1_type
//expenseUser2_userId expenseUser2_amount expenseUser2_type ...
//expenseUser3_userId expenseUserN_amount expenseUserN_type
@Data
public class AddExpenseRequestDto {
    private Double totalAmount;
    private Long groupId;
    private List<ExpenseUserDTO> expenseUserRequestDTOList;

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<ExpenseUserDTO> getExpenseUserRequestDTOList() {
        return expenseUserRequestDTOList;
    }

    public void setExpenseUserRequestDTOList(List<ExpenseUserDTO> expenseUserRequestDTOList) {
        this.expenseUserRequestDTOList = expenseUserRequestDTOList;
    }
}
