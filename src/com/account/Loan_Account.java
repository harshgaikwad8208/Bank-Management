package com.account;

public class Loan_Account extends Account {
    private double loan_amount;
    private double interestRate=0.2;

    public Loan_Account(long account_number, String name, String acc_type, double v4) {
        super(account_number, name, acc_type);
        loan_amount = v4;
    }

    @Override
    public void deposit(double amount) {
        // TODO: Implement deposit logic
    	setBalance(getBalance()+amount);
    }

    @Override
    public void withdraw(double amount) {
        // TODO: Implement withdrawal logic
    	if(amount > getBalance())
    	{
    		System.out.println("Transaction Failed");
    	}
    	else
    	{
    		setBalance(getBalance()-amount);
    	}
    }

    @Override
    public void check_balance() {
        // TODO: Implement check_balance logic
    	System.out.println("Current Balancc is :"+getBalance());
    }

    public void cal_intrest() {
        // Assuming simple interest calculation
        double interest = loan_amount * interestRate / 100;
        System.out.println("Interest calculated: " + interest);
    }

    @Override
    public void generate_slip() {
        // TODO: Implement slip generation logic
    }

    public String getInfo() {
        return super.getInfo() + "\nLoan Amount: " + loan_amount;
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public void makeRepayment(double amount) {
        if (amount > 0) {
            double remainingLoan = getLoan_amount() - amount;

            if (remainingLoan >= 0) {
                setLoan_amount(remainingLoan);
                System.out.println("Repayment successful. Remaining loan amount: " + remainingLoan);
            } else {
                System.out.println("Repayment exceeds the remaining loan amount.");
            }
        } else {
            System.out.println("Invalid repayment amount.");
        }
    }
}
