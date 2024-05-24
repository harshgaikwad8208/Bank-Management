package com.account;

import java.util.Scanner;

public abstract class Account {
    protected long account_number;
    protected String name;
    protected String acc_type;
    protected double balance;

    public Account(long account_number, String name, String acc_type) {
        this.account_number = account_number;
        this.name = name;
        this.acc_type = acc_type;
        this.balance = 0;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getInfo() {
        return "Account Number: " + account_number + "\n"
             + "Account Holder Name: " + name + "\n"
             + "Account Type: " + acc_type + "\n"
             + "Account Balance: " + getBalance() + "\n";
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void check_balance();

    public abstract void cal_intrest();

    public abstract void generate_slip();

	
}
