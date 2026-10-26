package bankaccount;

import exception.AccountFrozenException;
import exception.InvalidAmountException;
import exception.InsufficientFundsException;

/**
  * Running the main.
  */


public class Main {
    /**
     * Herein runs the main function.
     */

    public static void main(String[] args) {
        // EXERCISE 1 | TEST CASES
        // upcasting
        BankAccount acc1 = new SavingsAccount("Test0");

        // downcasting
        SavingsAccount acc = (SavingsAccount) acc1;

        // TEST 1
        System.out.println("TEST CASE 1:");
        System.out.println("Account Owner: " + acc.getOwnerName());

        // TEST 2
        System.out.println("\nTEST CASE 2:");
        try{
          acc.deposit(1000.125);
        } catch (InvalidAmountException | AccountFrozenException e){
          System.out.println(e.getMessage());
        } 

        // TEST 3
        System.out.println("\nTEST CASE 3:");
        try {
          acc.deposit(0);
        } catch (InvalidAmountException | AccountFrozenException e) {
          System.out.println(e.getMessage());
        }

        // TEST 4
        System.out.println("\nTEST CASE 4:");
        try {
          acc.deposit(-500);
        } catch (InvalidAmountException | AccountFrozenException e) {
          System.out.println(e.getMessage());
        }

        // TEST 5
        System.out.println("\nTEST CASE 5:");
        try {
          acc.withdraw(500);
        } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
          System.out.println(e.getMessage());
        }

        // TEST 6
        System.out.println("\nTEST CASE 6:");
        try {
          acc.withdraw(1500);
          System.out.printf("Current balance: %.2f%n", acc.getBalance());
        } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
          System.out.println(e.getMessage());
        } finally {
          System.out.printf("Current balance: %.2f%n", acc.getBalance());
        }

        // TEST 7
        System.out.println("\nTEST CASE 7:");
        try {
          acc.withdraw(-100);
          System.out.printf("Current balance: %.2f%n", acc.getBalance());
        } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
          System.out.println(e.getMessage());
        } finally {
          System.out.printf("Current balance: %.2f%n", acc.getBalance());
        }

        // TEST 8
        System.out.println("\nTEST CASE 8:");
        acc.freezeAccount();
        try {
          acc.deposit(11500);
        } catch (InvalidAmountException | AccountFrozenException e){
          System.out.println(e.getMessage());
        } finally {
          System.out.printf("Current balance: %.2f%n", acc.getBalance());
        }

        // TEST 9
        System.out.println("\nTEST CASE 9:");
        try {
          acc.withdraw(500);
          System.out.printf("Current balance: %.2f%n", acc.getBalance());
        } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
          System.out.println(e.getMessage());
        } finally {
          System.out.printf("Current balance: %.2f%n", acc.getBalance());
        }

        // TEST 10
        System.out.println("\nTEST CASE 10:");
        acc.unfreezeAccount();
        try {
          acc.withdraw(100);
        } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
          System.out.println(e.getMessage());
        }

        // EXERCISE 2 | TEST CASES
        // TEST CASE 11
        System.out.println("\nTEST CASE 11:");
        acc.getTransactionHistory();

        // TEST CASE 12
        System.out.println("\nTEST CASE 12:");
        BankAccountManager accM1 = new BankAccountManager();
        System.out.println(accM1);

        // TEST CASE 13
        System.out.println("\nTEST CASE 13:");
        accM1.addAccount(acc1);

        // TEST CASE 14
        System.out.println("\nTEST CASE 14:");
        accM1.addAccount(new SavingsAccount("Test1"));

        // TEST CASE 15
        System.out.println("\nTEST CASE 15:");
        accM1.listAccounts();
  }
}
