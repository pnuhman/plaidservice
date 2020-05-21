package com.buckzy.plaid.model;

public class NumberACH {
    private String accountId;
    private String account;
    private String routing;
    private String wireRouting;

    public String getAccountId() {
        return accountId;
    }

    public String getAccount() {
        return account;
    }

    public String getRouting() {
        return routing;
    }

    public String getWireRouting() {
        return wireRouting;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public void setWireRouting(String wireRouting) {
        this.wireRouting = wireRouting;
    }
}
