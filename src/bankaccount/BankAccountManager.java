package bankaccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankAccountManager implements Bank {
    private Map<Integer, BankAccount> accounts;
    private int id;
    private static final int MAX_ACCOUNTS = 100;

    BankAccountManager(){
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    public void addAccount(BankAccount account){
        int currentId = this.id;

        if(accounts.size() == MAX_ACCOUNTS){
            System.out.println("\nAccount limit reached");
            return;
        }

        accounts.put(currentId, account);
        this.id++;
        System.out.println("Account added succesfully: " + currentId);
    }

    @Override
    public BankAccount getAccount(int id){
        return accounts.get(id);
    }

    public void listAccounts(){
        if(accounts.isEmpty()){
            System.out.println("There are no accounts listed");
            return;
        }

        for(Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            BankAccount account = entry.getValue();
            String acc = "Unknown";

            if(account instanceof SavingsAccount){
                acc = ((SavingsAccount) account).getOwnerName();
            }

            double bal = Math.round(account.getBalance() * 100.0) / 100.0;

            System.out.println("\nAccount ID: " + entry.getKey() + 
            ", Account Name: " + acc + ", Balance: " + bal);
        }
    }

    @Override 
    public List<Transaction> filterTransactionsAtOrAbove (
        double amount, List<Transaction> accList
    ){
        return accList.stream().
        filter(tx -> tx.getAmount() >= amount).
        collect(Collectors.toList());
    }

    @Override
    public List<Transaction> sortTransactionsByAmount(
        List<Transaction> accList
    ){
        List<Transaction> sortedAccList = new ArrayList<>(accList);
        
        sortedAccList.sort((a, b) -> Double.compare(a.getAmount(), b.getAmount()));
        return sortedAccList;
    }
}
