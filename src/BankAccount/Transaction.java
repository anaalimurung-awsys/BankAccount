package bankaccount;
import java.time.LocalDateTime;

public class Transaction {
    public String type;
    public double amount;
    public LocalDateTime time_stamp;

    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
        LocalDateTime time_stamp = LocalDateTime.now();
    }

    public String toString(){
        return "[type = " + this.type + ", amount = " + this.amount + ", time_stamp = " + this.time_stamp + "]\n";
	}
}
