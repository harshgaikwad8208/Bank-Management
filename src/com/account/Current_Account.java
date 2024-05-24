package com.account;

import java.util.Scanner;

public class Current_Account extends Account {
    Scanner sc = new Scanner(System.in);
    public double overdraft = 10000;

    public Current_Account(long v1, String v2, String v3) {
        super(v1, v2, v3);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Your Account Does Not Have Sufficient Balance to Complete Transaction");

            System.out.println("Choice" + "\n" + "1)Use Overdraft Facility" + "\n" + "2)Cancel Transaction" + "\n");
            int choice = sc.nextInt();

            if (choice == 1) {
                if (amount > overdraft) {
                    System.out.println("Overdraft limit is: $" + overdraft + "\t" + "Your Amount for withdrawal: $" + amount);
                } else {
                    overdraft -= amount;
                    setBalance(getBalance() - amount);
                    System.out.println("Transaction Successful");
                }
            }
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Transaction Successful");
        }
    }

    @Override
    public void check_balance() {
        System.out.println("Current balance: $" + getBalance());
    }

    @Override
    public void generate_slip() {
        // TODO: Implement slip generation logic for the current account
    }

    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposit successful. Updated balance: $" + getBalance());
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    @Override
    public void cal_intrest() {
        // TODO: Implement interest calculation logic for the current account
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "The OverDraft is: $" + overdraft + "\n";
    }

	
}
