package bankaccount;
import java.util.ArrayList;
import java.util.List;

/**
 * Initializes the parent class Bank Account.
 * 
 */

public class BankAccount {
  public double balance;
  public boolean isFrozen;
  public List<Transaction> transactionHistory;

  public BankAccount() {
    this.balance = 0;
    this.isFrozen = false;
    this.transactionHistory = new ArrayList<>();
  }

  /**
   * Method for depositing amount.
   * Parameter: amount
   * Return: updated balance
   */

  public double deposit(double amount) {
    if (isFrozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
    } else if (amount < 0) {
      System.out.printf("Amount deposited is %.2f%nIt must not be negative\n", amount);
    } else if (amount == 0) {
      System.out.printf("Amount deposited is %.2f%nIt must not be zero\n", amount);
    } else {
      this.balance += amount;
    }

    System.out.printf("Current balance: %.2f%n", this.balance);
    return balance;
  }

  /**
   * Method for withdrawing amount.
   * Parameter: amount
   * Return: updated balance
   */
  
  public double withdraw(double amount) {
    if (isFrozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
    } else if (amount < 0) {
      System.out.printf("Amount withdrawn: %.2f%n", amount);
      System.out.println("Invalid amount. Must be greater than 0.");
    } else if (amount == 0 || amount > this.balance) {
      System.out.printf("Amount withdrawn: %.2f%nInsufficient balance.\n", amount);
    } else {
      this.balance -= amount;
    }

    System.out.printf("Current balance: %.2f%n", this.balance);
    return this.balance;
  }

  public double getBalance() {
    return this.balance;
  }

  public void freezeAccount() {
    isFrozen = true;
  }

  public void unfreezeAccount() {
    isFrozen = false;
  }

  public boolean isFrozen() {
    return this.isFrozen;
  }

  /**
  * Herein runs the main function.
  */

  public static void main(String[] args) {
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

    // TEST 7
    System.out.println("\nTEST CASE 7:");
    acc.withdraw(-100);

    // TEST 8
    System.out.println("\nTEST CASE 8:");
    acc.freezeAccount();
    acc.deposit(11500);

    // TEST 9
    System.out.println("\nTEST CASE 9:");
    acc.withdraw(500);

    // TEST 10
    System.out.println("\nTEST CASE 10:");
    acc.unfreezeAccount();
    acc.withdraw(100);
  }
}
