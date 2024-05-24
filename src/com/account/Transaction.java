package com.account;

import com.account.Main.TransactionType;

public class Transaction {
    private Account account;
    private double amount;
    private TransactionType transactionType;

    public Transaction(Account account, double amount, TransactionType transactionType) {
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction Type: " + transactionType + "\n"
        	 +	"Account Number: " + account.getAccount_number()+"\n"									  
             + "Account Holder: " + account.getName() + "\n"
             + "Amount: " + amount;
    }
}
