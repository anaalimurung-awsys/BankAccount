package bankaccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountManager implements Bank {
    private Map<Integer, BankAccount> accounts;
    private int id;

    BankAccountManager(){
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    public void addAccount(BankAccount account){
        int currentId = this.id;
        accounts.put(currentId, account);
        this.id++;
        System.out.println("Account added succesfully: " + currentId);
    }

    public BankAccount getAccount(int id){
        return accounts.get(id);
    }

    public Map<Integer, BankAccount> listAccounts(){
        return accounts;
    }
}
