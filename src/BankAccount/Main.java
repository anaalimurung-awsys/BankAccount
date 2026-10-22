package bankaccount;

/**
  * Running the main.
  */


public class Main {
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

        // EXERCISE 2 | TEST CASE 1
        System.out.println("\nTEST CASE 11:");
        acc.getTransactionHistory();
  }
}
