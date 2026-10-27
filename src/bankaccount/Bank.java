package bankaccount;

import java.util.List;

/**
 * Bank Interface.
 */
public interface Bank {

  public void addAccount(BankAccount account);

  public BankAccount getAccount(int id);

  public List<Transaction> filterTransactionsAtOrAbove(
      double amount, List<Transaction> accList);

  public List<Transaction> sortTransactionsByAmount(
      List<Transaction> accList);
}
