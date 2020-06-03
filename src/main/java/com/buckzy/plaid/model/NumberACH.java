package com.buckzy.plaid.model;

public class NumberACH {
    private String accountId;
    private String account;
    private String routing;
    private String wireRouting;

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

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public String getWireRouting() {
        return wireRouting;
    }

    public void setWireRouting(String wireRouting) {
        this.wireRouting = wireRouting;
    }

    @Override
    public String toString() {
        return "NumberACH{" +
                "accountId='" + accountId + '\'' +
                ", account='" + account + '\'' +
                ", routing='" + routing + '\'' +
                ", wireRouting='" + wireRouting + '\'' +
                '}';
    }
}
