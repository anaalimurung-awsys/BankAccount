package bankaccount;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import java.util.ArrayList;
import java.util.List;

/**
 * Initializes the parent class Bank Account.
 * 
 */

public class BankAccount {
  private double balance;
  private boolean isFrozen;
  private List<Transaction> transactionHistory;

  private static final String INVALID_AMOUNT = "Invalid amount. Must be greater than 0.";
  private static final String INSUFFICIENT_FUNDS = "It must not be zero.";
  private static final String INSUFFICIENT_BALANCE = "Insufficient balance.";
  private static final String ACCOUNT_FROZEN = "Account is FROZEN. Unable to transact.";

  /**
   * constructor for BankAccount class.
   * 
   */
  public BankAccount() {
    this.balance = 0;
    this.isFrozen = false;
    this.transactionHistory = new ArrayList<>();
  }

  /**
   * Method for depositing amount.
   * Parameter: amount
   * Return: updated balance
   * Throws: InvalidAmountException, AccountFrozenException
   * 
   */

  public void deposit(double amount) {
    try {
      if (isFrozen) {
        throw new AccountFrozenException(ACCOUNT_FROZEN);
      }

      System.out.printf("Amount deposited is %.2f%n\n", amount);

      if (amount <= 0) {
        throw new InvalidAmountException(INVALID_AMOUNT);
      } else {
        this.balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
      }

      System.out.printf("Current balance: %.2f%n", this.balance);
    } catch (InvalidAmountException | AccountFrozenException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Method for withdrawing amount.
   * Parameter: amount
   * Return: updated balance
   * Throws: InsufficientFunds, AccountFrozen, InvalidAmount
   * 
   */

  public void withdraw(double amount) {
    try {
      if (isFrozen == true) {
        throw new AccountFrozenException(ACCOUNT_FROZEN);
      }

      System.out.printf("Amount withdrawn: %.2f%n", amount);

      if (amount < 0) {
        throw new InvalidAmountException(INVALID_AMOUNT);
      } else if (amount == 0) {
        throw new InsufficientFundsException(INSUFFICIENT_FUNDS);
      } else if (amount > this.balance) {
        throw new InsufficientFundsException(INSUFFICIENT_BALANCE);
      } else {
        this.balance -= amount;
        transactionHistory.add(new Transaction("Withdraw", amount));

      }

      System.out.printf("Current balance: %.2f%n", this.balance);
    } catch (InvalidAmountException
        | InsufficientFundsException
        | AccountFrozenException e) {
      System.out.println(e.getMessage());
    }
  }

  public List<Transaction> getTransactionHistory() {
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
}
