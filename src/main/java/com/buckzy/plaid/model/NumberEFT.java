package com.buckzy.plaid.model;

public class NumberEFT {
    private String accountId;
    private String account;
    private String institution;
    private String branch;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "NumberEFT{" +
                "accountId='" + accountId + '\'' +
                ", account='" + account + '\'' +
                ", institution='" + institution + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
