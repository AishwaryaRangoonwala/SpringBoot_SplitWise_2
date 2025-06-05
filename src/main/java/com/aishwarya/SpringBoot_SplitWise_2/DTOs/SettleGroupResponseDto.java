package com.aishwarya.SpringBoot_SplitWise_2.DTOs;

import com.aishwarya.SpringBoot_SplitWise_2.Enums.ResponseStatus;
import com.aishwarya.SpringBoot_SplitWise_2.Models.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class SettleGroupResponseDto {
    private List<Transaction> transactions;
    private ResponseStatus responseStatus;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
