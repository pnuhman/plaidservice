package com.buckzy.plaid.model;

import com.plaid.client.request.common.Product;
import com.plaid.client.response.ErrorResponse;

import java.util.Date;
import java.util.List;

public final class ItemStatus {
    private List<Product> availableProducts;
    private List<Product> billedProducts;
    private ErrorResponse error;
    private String institutionId;
    private String itemId;
    private String webhook;
    private Date consentExpirationTime;

    public List<Product> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(List<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public List<Product> getBilledProducts() {
        return billedProducts;
    }

    public void setBilledProducts(List<Product> billedProducts) {
        this.billedProducts = billedProducts;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    public Date getConsentExpirationTime() {
        return consentExpirationTime;
    }

    public void setConsentExpirationTime(Date consentExpirationTime) {
        this.consentExpirationTime = consentExpirationTime;
    }

    @Override
    public String toString() {
        return "ItemStatus{" +
                "availableProducts=" + availableProducts +
                ", billedProducts=" + billedProducts +
                ", error=" + error +
                ", institutionId='" + institutionId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", webhook='" + webhook + '\'' +
                ", consentExpirationTime=" + consentExpirationTime +
                '}';
    }
}
