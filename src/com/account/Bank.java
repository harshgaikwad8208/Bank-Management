package com.account;

public class Bank {
    public Account[] accounts = new Account[10];
    private int serial_number = 0;

    public void add_account(Account add_account) {
        if (serial_number < accounts.length) {
            accounts[serial_number++] = add_account;
        } else {
            System.out.println("There is no space to add a new account.");
        }
    }

    public void display() {
        System.out.println("Bank Accounts:");
        System.out.println("===================================");

        for (int i = 0; i < serial_number; i++) {
            if (accounts[i] != null) {
                System.out.println(accounts[i].getInfo());
                System.out.println("===================================");
            } else {
                System.out.println("Account at index " + i + " is null.");
            }
        }
    }


    public boolean deleteAccount(long accountNumber) {
        int index = findAccountIndex(accountNumber);

        if (index != -1) {
            removeAccountAtIndex(index);
            System.out.println("Account deleted successfully");
            return true;
        } else {
            System.out.println("Account number not found");
            return false;
        }
    }

    private int findAccountIndex(long accountNumber) {
        for (int i = 0; i < serial_number; i++) {
            if (accounts[i].getAccount_number() == accountNumber) {
                return i;
            }
        }
        return 1;
    }

    private void removeAccountAtIndex(int index) {
        for (int i = index; i < serial_number - 1; i++) {
            accounts[i] = accounts[i + 1];
        }

        accounts[serial_number - 1] = null;
        serial_number--;
    }
}
