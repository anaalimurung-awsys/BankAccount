package bankaccount;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime time_stamp;

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();
    }

    public String toString(){
        return "[type = " + this.type + ", amount = " 
        + this.amount + ", time_stamp = " 
        + this.time_stamp.format(FORMAT) + "]\n";
	}

    public double getAmount(){
        return this.amount;
    }

    public String getType(){
        return this.type;
    }

    public LocalDateTime getTimeStamp(){
        return this.time_stamp;
    }
}
