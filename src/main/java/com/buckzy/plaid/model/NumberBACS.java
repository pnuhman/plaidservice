package com.buckzy.plaid.model;

public class NumberBACS {
    private String accountId;
    private String account;
    private String sortCode;

    public String getAccountId() {
        return accountId;
    }

    public String getAccount() {
        return account;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }
}
