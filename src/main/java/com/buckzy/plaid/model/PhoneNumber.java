package com.buckzy.plaid.model;

public class PhoneNumber {
    private String data;
    private boolean primary;
    private String type;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "data='" + data + '\'' +
                ", primary=" + primary +
                ", type='" + type + '\'' +
                '}';
    }
}
