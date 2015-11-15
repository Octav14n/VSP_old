package restopoly.dataaccesslayer.entities;

/**
 * Created by Paddy-Gaming on 14.11.2015.
 */
public class BankAccount {

    private int bankAccountId;
    private String bankOwner;
    private String IBAN;
    private String BIC;
    // Kontostand
    private double bankBalance;

    public BankAccount(int bankAccountId, String bankOwner, String IBAN, String BIC) {
        this.bankAccountId = bankAccountId;
        this.bankOwner = bankOwner;
        this.IBAN = IBAN;
        this.BIC = BIC;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public String getBankOwner() {
        return bankOwner;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getBIC() {
        return BIC;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    /**
     *
     * @param bankBalance
     */
    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }
}
