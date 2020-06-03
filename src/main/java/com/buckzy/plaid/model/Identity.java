package com.buckzy.plaid.model;

import java.util.List;

public class Identity {
    private List<Address> addresses;
    private List<Email> emails;
    private List<String> names;
    private List<PhoneNumber> phoneNumbers;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "addresses=" + addresses +
                ", emails=" + emails +
                ", names=" + names +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
