package bankaccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Initializes Transaction class.
 * 
 */
public class Transaction {
  private String type;
  private double amount;
  private LocalDateTime timeStamp;

  private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  /**
 * Constructor for Transaction class.
 * 
 */
  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.timeStamp = LocalDateTime.now();
  }

  /**
 * Returns a string that has the details for a transactions.
 * 
 */
  public String toString() {
    return "type = " + this.type + ", amount = "
        + this.amount + ", time_stamp = "
        + this.timeStamp.format(FORMAT) + "]\n";
  }

  public double getAmount() {
    return this.amount;
  }
}
