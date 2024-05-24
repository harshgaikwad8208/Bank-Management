package com.account;

import com.account.Main.TransactionType;

public class Transactions {
    private Transaction[] transactions = new Transaction[100];
    private int size = 0;

    public Transactions() {
        // Constructor
    }

    public void addTransaction(Account account, double amount, TransactionType transactionType) {
        if (size < transactions.length) {
            transactions[size++] = new Transaction(account, amount, transactionType);
        } else {
            System.out.println("Transaction limit reached. Cannot add more transactions.");
        }
    }

    public void displayTransactions() {
        System.out.println("Transaction History:");
        System.out.println("=====================");

        for (int i = 0; i < size; i++) {
            System.out.println(transactions[i].toString());
            System.out.println("---------------------");
        }
    }
}
