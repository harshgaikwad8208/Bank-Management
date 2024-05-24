package com.account;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        REPAYMENT
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Transactions transactions = new Transactions();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("+-----------------------------+");
            System.out.println("|1. Deposit                   |");
            System.out.println("|-----------------------------|");
            System.out.println("|2. Withdraw                  |");
            System.out.println("|-----------------------------|");
            System.out.println("|3. Check Balance             |");
            System.out.println("|-----------------------------|");
            System.out.println("|4. Create Account            |");
            System.out.println("|-----------------------------|");
            System.out.println("|5. Display                   |");
            System.out.println("|-----------------------------|");
            System.out.println("|6. Delete Account            |");
            System.out.println("|-----------------------------|");
            System.out.println("|7. Daily Report              |");
            System.out.println("|-----------------------------|");
            System.out.println("|8. Repayment                 |");
            System.out.println("|-----------------------------|");
            System.out.println("|9. Exit                      |");
            System.out.println("+-----------------------------+");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performTransaction(bank, scanner, TransactionType.DEPOSIT, transactions);
                    break;
                case 2:
                    performTransaction(bank, scanner, TransactionType.WITHDRAWAL, transactions);
                    break;
                case 3:
                    checkBalance(bank, scanner);
                    break;
                case 4:
                    createAccount(bank, scanner);
                    break;
                case 7:
                    transactions.displayTransactions();
                    break;
                case 9:
                    System.out.println("Exiting program. Thank you!");
                    System.exit(0);
                    break;
                case 6:
                    deleteAccount(bank, scanner);
                    break;
                case 5:
                    bank.display();
                    break;
                case 8:
                    performTransaction(bank, scanner, TransactionType.REPAYMENT, transactions);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void performTransaction(Bank bank, Scanner scanner, TransactionType transactionType, Transactions transactions) {
        System.out.print("Enter account number for " + transactionType + ": ");
        long accountNumber = scanner.nextLong();
        Account account = searchAccount(bank, accountNumber);

        if (account != null) {
            switch (transactionType) {
                case DEPOSIT:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                    transactions.addTransaction(account, depositAmount, TransactionType.DEPOSIT);
                    break;
                case WITHDRAWAL:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    transactions.addTransaction(account, withdrawalAmount, TransactionType.WITHDRAWAL);
                    break;
                case REPAYMENT:
                    if (account instanceof Loan_Account) {
                        System.out.print("Enter repayment amount: ");
                        double repaymentAmount = scanner.nextDouble();
                        ((Loan_Account) account).makeRepayment(repaymentAmount);
                        transactions.addTransaction(account, repaymentAmount, TransactionType.REPAYMENT);
                    } else {
                        System.out.println("Repayment option is only available for Loan Accounts.");
                    }
                    break;
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance(Bank bank, Scanner scanner) {
        System.out.print("Enter account number for balance check: ");
        long accountNumber = scanner.nextLong();
        Account account = searchAccount(bank, accountNumber);

        if (account != null) {
            account.check_balance();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void createAccount(Bank bank, Scanner scanner) {
        System.out.println("Choose account type (1. Savings, 2. Current, 3. Loan, 4. Salary): ");
        int accountTypeChoice = scanner.nextInt();
        
        Random rand=new Random();
        long accountNumber = rand.nextLong(100000000);
        scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        
        Account newAccount = null;

        switch (accountTypeChoice) {
            case 1:
                newAccount = new Saving_Account(accountNumber, accountHolderName, "Savings");
                break;
            case 2:
                newAccount = new Current_Account(accountNumber, accountHolderName, "Current");
                break;
            case 3:
                System.out.print("Enter loan amount: ");
                double loanAmount = scanner.nextDouble();
                newAccount = new Loan_Account(accountNumber, accountHolderName, "Loan", loanAmount);
                break;
            case 4:
                newAccount = new Salary_Account(accountNumber, accountHolderName, "Salary", LocalDate.now());
                break;
            default:
                System.out.println("Invalid account type choice.");
                return; // Exit method if choice is invalid
        }

        bank.add_account(newAccount);
        System.out.println(" Account created successfully!");
    }

    private static Account searchAccount(Bank bank, long accountNumber) {
        for (Account account : bank.accounts) {
            if (account != null && account.getAccount_number() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    private static void deleteAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter account number to delete: ");
        long accountNumber = scanner.nextLong();
        bank.deleteAccount(accountNumber);
    }
}
