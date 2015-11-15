package restopoly.dataaccesslayer.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paddy-Gaming on 14.11.2015.
 */
public class Bank {

    private int bankId;
    private String name;
    // In German it's Bankleitzahl
    private int bankCode;
    private List<BankAccount> bankAccounts;

    public Bank(int bankId, String name, int bankCode) {
        this.bankId = bankId;
        this.name = name;
        this.bankCode = bankCode;
        this.bankAccounts = new ArrayList<>();

    }

    public int getBankId() {
        return bankId;
    }

    public String getName() {
        return name;
    }

    public int getBankCode() {
        return bankCode;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
    }
}
