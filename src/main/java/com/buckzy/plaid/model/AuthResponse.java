package com.buckzy.plaid.model;

import java.util.List;

public class AuthResponse extends BaseResponse {
    private ItemStatus item;
    private List<Account> accounts;
    private Numbers numbers;

    public ItemStatus getItem() {
        return item;
    }

    public void setItem(ItemStatus item) {
        this.item = item;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public void setNumbers(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "item=" + item +
                ", accounts=" + accounts +
                ", numbers=" + numbers +
                '}';
    }
}
