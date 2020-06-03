package com.buckzy.plaid.model;

public class Address {
    private AddressData data;
    private boolean primary;

    public AddressData getData() {
        return data;
    }

    public void setData(AddressData data) {
        this.data = data;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        return "Address{" +
                "data=" + data +
                ", primary=" + primary +
                '}';
    }
}
