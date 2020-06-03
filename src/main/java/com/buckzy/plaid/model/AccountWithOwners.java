package com.buckzy.plaid.model;


import java.util.List;

public class AccountWithOwners extends Account {
    private List<Identity> owners;

    public List<Identity> getOwners() {
        return owners;
    }

    public void setOwners(List<Identity> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "AccountWithOwners{" +
                "owners=" + owners +
                '}';
    }
}
