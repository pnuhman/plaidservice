package com.buckzy.plaid.model;

public class NumberBACS {
    private String accountId;
    private String account;
    private String sortCode;

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

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    @Override
    public String toString() {
        return "NumberBACS{" +
                "accountId='" + accountId + '\'' +
                ", account='" + account + '\'' +
                ", sortCode='" + sortCode + '\'' +
                '}';
    }
}
