package com.account;

import java.time.LocalDate;

public class Salary_Account extends Account {
    private boolean isFrozen;
    private LocalDate lastActivityDate;
    private static final int INACTIVE_MONTH_LIMIT = 2;

    // Constructor
    public Salary_Account(long accountNumber, String accountHolderName, String accountType, LocalDate lastActivityDate) {
        super(accountNumber, accountHolderName, accountType);
        this.isFrozen = true;
        this.lastActivityDate = lastActivityDate;
    }

    // Getter and Setter for isFrozen
    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    // Method to freeze account
    public void freezeAccount() {
        isFrozen = true;
        System.out.println("Account frozen successfully.");
    }

    // Method to unfreeze account
    public void unfreezeAccount() {
        isFrozen = false;
        System.out.println("Account is active.");
    }

    @Override
    public void withdraw(double amount) {
        checkInactive();
        if (!isFrozen) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                lastActivityDate = LocalDate.now();
                System.out.println("Withdrawal of $" + amount + " successful.");
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        } else {
            System.out.println("Account is frozen. Withdrawal not allowed.");
        }
    }

    @Override
    public void deposit(double amount) {
        checkInactive();
        if (!isFrozen) {
            if (amount > 0) {
                balance += amount;
                lastActivityDate = LocalDate.now();
                System.out.println("Deposit of $" + amount + " successful.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        } else {
            System.out.println("Account is frozen. Deposit not allowed.");
        }
    }

    @Override
    public void check_balance() {
        System.out.println("Account balance: $" + balance);
    }

    @Override
    public void generate_slip() {
        System.out.println("Savings Account Slip - " + getInfo());
    }

    public String getInfo() {
        return super.getInfo() + "\n";
    }

    @Override
    public void cal_intrest() {
        // Salary account does not use interest function.
    }

    // Method to check if the account is inactive
    public void checkInactive() {
        LocalDate currentDate = LocalDate.now();
        LocalDate inactiveThreshold = currentDate.minusMonths(INACTIVE_MONTH_LIMIT);
        if (lastActivityDate.isBefore(inactiveThreshold)) {
            freezeAccount();
        } else {
            unfreezeAccount();
        }
    }
}
