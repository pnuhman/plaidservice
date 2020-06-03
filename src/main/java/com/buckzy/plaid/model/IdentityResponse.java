package com.buckzy.plaid.model;

import java.util.List;

public final class IdentityResponse extends BaseResponse {
    private ItemStatus item;
    private List<AccountWithOwners> accounts;

    public ItemStatus getItem() {
        return item;
    }

    public void setItem(ItemStatus item) {
        this.item = item;
    }

    public List<AccountWithOwners> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountWithOwners> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "IdentityResponse{" +
                "item=" + item +
                ", accounts=" + accounts +
                '}';
    }
}
