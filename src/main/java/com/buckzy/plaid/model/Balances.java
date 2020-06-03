package com.buckzy.plaid.model;

public class Balances {
    private Double available;
    private Double current;
    private Double limit;
    private String isoCurrencyCode;
    private String unofficialCurrencyCode;

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    public void setIsoCurrencyCode(String isoCurrencyCode) {
        this.isoCurrencyCode = isoCurrencyCode;
    }

    public String getUnofficialCurrencyCode() {
        return unofficialCurrencyCode;
    }

    public void setUnofficialCurrencyCode(String unofficialCurrencyCode) {
        this.unofficialCurrencyCode = unofficialCurrencyCode;
    }

    @Override
    public String toString() {
        return "Balances{" +
                "available=" + available +
                ", current=" + current +
                ", limit=" + limit +
                ", isoCurrencyCode='" + isoCurrencyCode + '\'' +
                ", unofficialCurrencyCode='" + unofficialCurrencyCode + '\'' +
                '}';
    }
}
