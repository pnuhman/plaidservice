package com.buckzy.plaid.model;

public enum Product {
    ASSETS("ASSETS"),
    BALANCE("BALANCE"),
    CREDIT_DETAILS("CREDIT_DETAILS"),
    INCOME("INCOME"),
    IDENTITY("IDENTITY"),
    AUTH("AUTH"),
    TRANSACTIONS("TRANSACTIONS"),
    INVESTMENTS("INVESTMENTS"),
    LIABILITIES("LIABILITIES"),
    PAYMENT_INITIATION("PAYMENT_INITIATION");

    private String text;

    Product(String text) {
        this.text = text;
    }

    public static Product fromString(String text) {
        for (Product b : Product.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return "Product{" +
                "text='" + text + '\'' +
                '}';
    }
}
