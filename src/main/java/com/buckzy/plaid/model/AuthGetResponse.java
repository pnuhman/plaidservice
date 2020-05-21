package com.buckzy.plaid.model;

import java.util.List;

public final class AuthGetResponse extends BaseResponse {
  private ItemStatus item;
  private List<Account> accounts;
  private Numbers numbers;

  public ItemStatus getItem() {
    return item;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public Numbers getNumbers() {
    return numbers;
  }

}
