package BankAccount;

public class BankAccount {
    public double balance;
    public boolean isFrozen;

    public BankAccount() {
        this.balance = 0;
        this.isFrozen = false;
    }

    public double deposit(double amount){
        if(isFrozen){
            System.out.print("Account is FROZEN. Unable to transact.");
        } 
        else if (amount < 0) {
            System.out.printf("\nAmount deposited is %.2f%nIt must not be negative", amount);
        }
        else if (amount == 0) {
            System.out.printf("\nAmount deposited is %.2f%nIt must not be zero", amount);
        }
        else { 
            this.balance += amount;
        }

        System.out.printf("\nCurrent balance: %.2f%n", this.balance);
        return balance;
    }

    public double withdraw(double amount){
        if(isFrozen){
            System.out.print("Account is FROZEN. Unable to transact.");
        } 
        else if (amount < 0) {
            System.out.printf("\nAmount withdrawn: %.2f%nInvalid amount. Must be greater than 0.", amount);
        }
        else if(amount == 0 || amount > this.balance){
            System.out.printf("\nAmount withdrawn: %.2f%nInsufficient balance.", amount);
        }
        else { 
            this.balance -= amount;
        }
        
        System.out.printf("\nCurrent balance: %.2f%n", this.balance);
        return this.balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void freezeAccount(){
        isFrozen = true;
    }

    public void unfreezeAccount(){
        isFrozen = false;
    }

    public boolean isFrozen(){
        return this.isFrozen;
    }


    // HEREIN RUN MAIN FUNCTION
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("Test0");
        SavingsAccount acc = (SavingsAccount) acc1;

        // TEST 1
        System.out.print("Account Owner: " + acc.getOwnerName());

        //TEST 2
        acc.deposit(1000.125);

        // TEST 3
        acc.deposit(0);

        // TEST 4
        acc.deposit(-500);

        // TEST 5
        acc.withdraw(500);

        // TEST 6
        acc.withdraw(1500);

        // TEST 7
        acc.withdraw(-100);

        // TEST 8
        acc.freezeAccount();
        acc.deposit(11500);

        // TEST 9
        acc.withdraw(500);

        // TEST 10
        acc.unfreezeAccount();
        acc.withdraw(100);
    }
}
