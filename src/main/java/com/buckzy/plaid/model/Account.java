package com.buckzy.plaid.model;

public class Account {
    private String accountId;
    private String type;
    private String subtype;
    private Balances balances;
    private String name;
    private String mask;
    private String officialName;
    private String verificationStatus;


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public Balances getBalances() {
        return balances;
    }

    public void setBalances(Balances balances) {
        this.balances = balances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", type='" + type + '\'' +
                ", subtype='" + subtype + '\'' +
                ", balances=" + balances +
                ", name='" + name + '\'' +
                ", mask='" + mask + '\'' +
                ", officialName='" + officialName + '\'' +
                ", verificationStatus='" + verificationStatus + '\'' +
                '}';
    }
}
