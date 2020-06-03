package com.buckzy.plaid.model;

public class NumberInternational {
    private String accountId;
    private String iban;
    private String bic;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getIBAN() {
        return iban;
    }

    public String getBIC() {
        return bic;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Override
    public String toString() {
        return "NumberInternational{" +
                "accountId='" + accountId + '\'' +
                ", iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                '}';
    }
}
