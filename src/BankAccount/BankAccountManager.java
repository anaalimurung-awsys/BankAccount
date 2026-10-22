package bankaccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountManager implements Bank {
    public Map<Integer, BankAccount> accounts;
    private int id;

    BankAccountManager(){
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    public void addAccount(BankAccount account){
        for(int i : accounts.keySet()){ 
            accounts.put(id, account);
            id++;
        }
    }

    public int getAccount(int id){
        return id;
    }

    public Map<Integer, BankAccount> listAccounts(){
        return accounts;
    }
}
