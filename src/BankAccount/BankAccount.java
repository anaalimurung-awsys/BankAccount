package BankAccount;

public class BankAccount {
    public double balance;
    public boolean isFrozen;


    public BankAccount(double balance, boolean isFrozen) {
        this.balance = 0;
        this.isFrozen = false;
    }

    public double deposit(double amount){
        if(isFrozen){
            System.out.println("Account is frozen");
        } 
        else if (amount <= 0) {
            System.out.println("Amount should not be zero or lower");
        }
        else { 
            this.balance = amount;
        }

        return balance;
    }
    public double withdraw(double amount){
        if(isFrozen){
            System.out.println("Account is frozen");
        } 
        else if (amount <= 0) {
            System.out.println("Amount should not be zero or lower");
        }
        else { 
            this.balance = this.balance - amount;
        }

        return amount;
    }

    public double getBalance(){
        return this.balance;
    }

    public boolean freezeAccount(){
        return true;
    }

    public boolean unfreezeAccount(){
        return false;
    }

    public boolean isFrozen(){
        return this.isFrozen;
    }


    // HEREIN RUN MAIN FUNCTION
}
