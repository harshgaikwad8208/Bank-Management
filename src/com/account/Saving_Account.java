package com.account;

public class Saving_Account extends Account {
    private final double minimumAmount = 10000;

    public Saving_Account(long accountNumber, String accountHolderName, String accountType) {
        super(accountNumber, accountHolderName, accountType);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= minimumAmount) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Withdrawal not allowed. Maintain a minimum balance of $" + minimumAmount);
        }
    }

    @Override
    public void check_balance() {
        System.out.println("Current balance: $" + getBalance());
    }

    @Override
    public void cal_intrest() {
        // Implement your interest calculation logic here
    }

    @Override
    public void generate_slip() {
        System.out.println("Savings Account Slip - " + getInfo());
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\n";
    }
}
