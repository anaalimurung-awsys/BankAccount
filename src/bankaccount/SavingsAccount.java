package bankaccount;

/**
 * Initializes child class SavingsAccount.
 * 
 */

public class SavingsAccount extends BankAccount {
  private String ownerName;

  public SavingsAccount(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }
}
