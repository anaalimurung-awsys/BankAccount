package bankaccount;

import java.util.List;

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
    acc.deposit(1000.125);

    // TEST 3
    System.out.println("\nTEST CASE 3:");
    acc.deposit(0);

    // TEST 4
    System.out.println("\nTEST CASE 4:");
    acc.deposit(-500);

    // TEST 5
    System.out.println("\nTEST CASE 5:");
    acc.withdraw(500);

    // TEST 6
    System.out.println("\nTEST CASE 6:");

    acc.withdraw(1500);
    System.out.printf("Current balance: %.2f%n", acc.getBalance());

    // TEST 7
    System.out.println("\nTEST CASE 7:");

    acc.withdraw(-100);
    System.out.printf("Current balance: %.2f%n", acc.getBalance());

    // TEST 8
    System.out.println("\nTEST CASE 8:");
    acc.freezeAccount();
    acc.deposit(11500);

    // TEST 9
    System.out.println("\nTEST CASE 9:");

    acc.withdraw(500);
    System.out.printf("Current balance: %.2f%n", acc.getBalance());

    // TEST 10
    System.out.println("\nTEST CASE 10:");
    acc.unfreezeAccount();
    acc.withdraw(100);

    // EXERCISE 2 | TEST CASES
    // TEST CASE 11
    System.out.println("\nTEST CASE 11:");
    System.out.println(acc.getTransactionHistory());

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

    // EXERCISE 3 | TEST CASES
    // TEST CASE 16
    System.out.println("\nTEST CASE 16:");

    acc.deposit(-500);

    // TEST CASE 17
    System.out.println("\nTEST CASE 17:");
    acc.freezeAccount();

    acc.deposit(11500);

    // TEST CASE 18
    System.out.println("\nTEST CASE 18:");
    acc.unfreezeAccount();

    acc.withdraw(-100);

    // TEST CASE 19
    System.out.println("\nTEST CASE 19:");

    acc.withdraw(1500);

    // TEST CASE 20
    System.out.println("\nTEST CASE 20:");
    acc.freezeAccount();

    acc.withdraw(500);

    // TEST CASE 21
    System.out.println("\nTEST CASE 21:");
    List<Transaction> filteredList = 
        accM1.filterTransactionsAtOrAbove(200, acc1.getTransactionHistory());

    System.out.println(filteredList);

    // TEST CASE 22
    System.out.println("\nTEST CASE 22:");
    System.out.print(acc1.getTransactionHistory());
  }
}
