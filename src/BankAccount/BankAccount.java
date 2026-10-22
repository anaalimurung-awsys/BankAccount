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
      transactionHistory.add(new Transaction("Deposit", amount));
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
      transactionHistory.add(new Transaction("Withdraw", amount));

    }
    System.out.printf("Current balance: %.2f%n", this.balance);
    return this.balance;
  }

  public List<Transaction> getTransactionHistory() {
    System.out.println(transactionHistory);
    return transactionHistory; 
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
}
