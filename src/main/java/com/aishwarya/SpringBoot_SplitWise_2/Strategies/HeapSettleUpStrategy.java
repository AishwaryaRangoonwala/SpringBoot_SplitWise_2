package com.aishwarya.SpringBoot_SplitWise_2.Strategies;

import com.aishwarya.SpringBoot_SplitWise_2.Models.Transaction;
import com.aishwarya.SpringBoot_SplitWise_2.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


class UserBalance implements Comparable<UserBalance> {
    private User user;
    private Double balance;

    public UserBalance(User user, Double balance) {
        this.user = user;
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public int compareTo(UserBalance o) {
        return Double.compare(this.balance, o.balance);
    }
}

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUpGroup(Map<User, Double> balanceMap) {
        PriorityQueue<UserBalance> giverHeap = new PriorityQueue<>();
        PriorityQueue<UserBalance> receiverHeap = new PriorityQueue<>();
        // Transaction will be formed as follows:
        // The person who is to be paid the most will be paid by the person owes the most
        for (User user : balanceMap.keySet()) {
            Double userAmount = balanceMap.get(user);
            if (userAmount < 0) {
                giverHeap.add(new UserBalance(user, Math.abs(userAmount)));
            }
            if (userAmount > 0) {
                receiverHeap.add(new UserBalance(user, userAmount));
            }
        }
        List<Transaction> transactionList = new ArrayList<>();
        while (!giverHeap.isEmpty() && !receiverHeap.isEmpty()) {
            Transaction transaction = new Transaction();
            UserBalance giverBalance = giverHeap.poll();
            UserBalance receiverBalance = receiverHeap.poll();
            transaction.setPaidFrom(giverBalance.getUser());
            transaction.setPaidTo(receiverBalance.getUser());
            transaction.setAmount(Math.min(giverBalance.getBalance(), receiverBalance.getBalance()));
            if (giverBalance.getBalance() < receiverBalance.getBalance()) {
                receiverBalance.setBalance(receiverBalance.getBalance() - giverBalance.getBalance());
                receiverHeap.add(receiverBalance);
            }
            else if (giverBalance.getBalance() > receiverBalance.getBalance()) {
                giverBalance.setBalance(giverBalance.getBalance() - receiverBalance.getBalance());
                giverHeap.add(giverBalance);
            }
            transactionList.add(transaction);
        }
        return transactionList;
    }
}
