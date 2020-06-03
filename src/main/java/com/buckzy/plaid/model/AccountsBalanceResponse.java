package com.buckzy.plaid.model;

import java.util.List;

/**
 * Response for /accounts/balance/get api call.
 */
public class AccountsBalanceResponse extends BaseResponse {
    private ItemStatus item;
    private List<Account> accounts;

    public ItemStatus getItem() {
        return item;
    }

    public void setItem(ItemStatus item) {
        this.item = item;
    }

    public List<Account> getAccounts() {
        if (accounts == null) {
            return null;
        }
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "AccountsBalanceResponse{" +
                "item=" + item +
                ", accounts=" + accounts +
                '}';
    }
}
