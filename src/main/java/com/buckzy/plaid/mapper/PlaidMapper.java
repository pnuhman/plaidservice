package com.buckzy.plaid.mapper;

import com.buckzy.plaid.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaidMapper {

    public AuthResponse mapPlaidAuthGetResponseToAuthGetResponse(com.plaid.client.response.AuthGetResponse plaidAuthGetResponse) {
        AuthResponse authResponse = new AuthResponse();

        List<Account> accounts = plaidAuthGetResponse.getAccounts()
                .stream()
                .map(accnt -> mapPlaidAccountToAccount(accnt))
                .collect(Collectors.toList());

        authResponse.setAccounts(accounts);
        authResponse.setItem(mapPlaidItemStatusToItemStatus(plaidAuthGetResponse.getItem()));
        authResponse.setRequestId(plaidAuthGetResponse.getRequestId());
        authResponse.setNumbers(mapPlaidNumbersToNumbers(plaidAuthGetResponse.getNumbers()));

        return authResponse;
    }

    public IdentityResponse mapPlaidIdentityGetResponseToIdentityGetResponse(com.plaid.client.response.IdentityGetResponse plaidIdentityGetResponse) {
        IdentityResponse identityResponse = new IdentityResponse();

        List<AccountWithOwners> accounts = plaidIdentityGetResponse.getAccounts()
                .stream()
                .map(accnt -> mapPlaidAccountToAccount(accnt))
                .collect(Collectors.toList());

        identityResponse.setAccounts(accounts);
        identityResponse.setItem(mapPlaidItemStatusToItemStatus(plaidIdentityGetResponse.getItem()));
        identityResponse.setRequestId(plaidIdentityGetResponse.getRequestId());

        return identityResponse;
    }

    public AccountsBalanceResponse
    mapPlaidAccountsBalanceGetResponseToAccountsBalanceGetResponse(com.plaid.client.response.AccountsBalanceGetResponse plaidAccountsBalanceGetResponse) {
        AccountsBalanceResponse accountsBalanceResponse = new AccountsBalanceResponse();

        List<Account> accounts = plaidAccountsBalanceGetResponse.getAccounts()
                .stream()
                .map(accnt -> mapPlaidAccountToAccount(accnt))
                .collect(Collectors.toList());

        accountsBalanceResponse.setRequestId(plaidAccountsBalanceGetResponse.getRequestId());
        accountsBalanceResponse.setAccounts(accounts);
        accountsBalanceResponse.setItem(mapPlaidItemStatusToItemStatus(plaidAccountsBalanceGetResponse.getItem()));

        return accountsBalanceResponse;
    }

    public NumberACH mapPlaidNumberACHToNumberACH(com.plaid.client.response.AuthGetResponse.NumberACH plaidNumberACH) {
        NumberACH numberACH = new NumberACH();

        numberACH.setAccount(plaidNumberACH.getAccount());
        numberACH.setAccountId(plaidNumberACH.getAccountId());
        numberACH.setRouting(plaidNumberACH.getRouting());
        numberACH.setWireRouting(plaidNumberACH.getWireRouting());

        return numberACH;
    }

    public NumberBACS mapPlaidNumberBACSToNumberBACS(com.plaid.client.response.AuthGetResponse.NumberBACS plaidNumberBACS) {
        NumberBACS numberBACS = new NumberBACS();

        numberBACS.setAccount(plaidNumberBACS.getAccount());
        numberBACS.setAccountId(plaidNumberBACS.getAccountId());
        numberBACS.setSortCode(plaidNumberBACS.getSortCode());

        return numberBACS;
    }

    public NumberEFT mapPlaidNumberEFTToNumberEFT(com.plaid.client.response.AuthGetResponse.NumberEFT plaidNumberEFT) {
        NumberEFT numberEFT = new NumberEFT();

        numberEFT.setAccount(plaidNumberEFT.getAccount());
        numberEFT.setAccountId(plaidNumberEFT.getAccountId());
        numberEFT.setBranch(plaidNumberEFT.getBranch());
        numberEFT.setInstitution(plaidNumberEFT.getInstitution());

        return numberEFT;
    }

    public NumberInternational mapPlaidInternationalACHToInternational(com.plaid.client.response.AuthGetResponse.NumberInternational plaidNumberInternational) {
        NumberInternational numberInternational = new NumberInternational();

        numberInternational.setAccountId(plaidNumberInternational.getAccountId());
        numberInternational.setBic(plaidNumberInternational.getBIC());
        numberInternational.setIban(plaidNumberInternational.getIBAN());

        return numberInternational;
    }

    public Numbers mapPlaidNumbersToNumbers(com.plaid.client.response.AuthGetResponse.Numbers plaidNumbers) {
        Numbers numbers = new Numbers();

        if (plaidNumbers.getACH() != null && plaidNumbers.getACH().isEmpty()) {
            List<NumberACH> numberACHES = plaidNumbers.getACH().stream().map(ach -> {
                NumberACH numberACH = new NumberACH();

                numberACH.setAccount(ach.getAccount());
                numberACH.setAccountId(ach.getAccountId());
                numberACH.setWireRouting(ach.getWireRouting());
                numberACH.setRouting(ach.getRouting());

                return numberACH;
            }).collect(Collectors.toList());

            numbers.setAch(numberACHES);
        }

        if (plaidNumbers.getBACS() != null && plaidNumbers.getBACS().isEmpty()) {
            List<NumberBACS> numberBACS = plaidNumbers.getBACS().stream().map(ach -> {
                NumberBACS numberBAC = new NumberBACS();

                numberBAC.setAccount(ach.getAccount());
                numberBAC.setAccountId(ach.getAccountId());
                numberBAC.setSortCode(ach.getSortCode());

                return numberBAC;
            }).collect(Collectors.toList());

            numbers.setBacs(numberBACS);
        }

        if (plaidNumbers.getEFT() != null && plaidNumbers.getEFT().isEmpty()) {
            List<NumberEFT> numberEFTS = plaidNumbers.getEFT().stream().map(ach -> {
                NumberEFT numberEFT = new NumberEFT();

                numberEFT.setAccount(ach.getAccount());
                numberEFT.setAccountId(ach.getAccountId());
                numberEFT.setInstitution(ach.getInstitution());
                numberEFT.setBranch(ach.getBranch());

                return numberEFT;
            }).collect(Collectors.toList());

            numbers.setEft(numberEFTS);
        }

        if (plaidNumbers.getInternational() != null && plaidNumbers.getInternational().isEmpty()) {
            List<NumberInternational> numberInternationals = plaidNumbers.getInternational().stream().map(international -> {
                NumberInternational numberInternational = new NumberInternational();

                numberInternational.setAccountId(international.getAccountId());
                numberInternational.setIban(international.getIBAN());
                numberInternational.setBic(international.getBIC());

                return numberInternational;
            }).collect(Collectors.toList());

            numbers.setInternational(numberInternationals);
        }

        return numbers;
    }

    public Account mapPlaidAccountToAccount(com.plaid.client.response.Account plaidAccount) {
        Account account = new Account();

        account.setAccountId(plaidAccount.getAccountId());
        if (plaidAccount.getBalances() != null) {
            account.setBalances(mapPlaidBalancetoBalance(plaidAccount.getBalances()));
        }
        account.setMask(plaidAccount.getMask());
        account.setName(plaidAccount.getName());
        account.setOfficialName(plaidAccount.getOfficialName());
        account.setSubtype(plaidAccount.getSubtype());
        account.setType(plaidAccount.getType());
        account.setVerificationStatus(plaidAccount.getVerificationStatus());

        return account;
    }

    public AccountWithOwners mapPlaidAccountToAccount(com.plaid.client.response.IdentityGetResponse.AccountWithOwners plaidAccountWithOwners) {
        AccountWithOwners accountWithOwners = new AccountWithOwners();

        List<Identity> owners = plaidAccountWithOwners.getOwners()
                .stream()
                .map(ownr -> mapPlaidIdentityToIdentity(ownr)).collect(Collectors.toList());


        accountWithOwners.setOwners(owners);
        accountWithOwners.setAccountId(plaidAccountWithOwners.getAccountId());
        accountWithOwners.setBalances(mapPlaidBalancetoBalance(plaidAccountWithOwners.getBalances()));
        accountWithOwners.setMask(plaidAccountWithOwners.getMask());
        accountWithOwners.setName(plaidAccountWithOwners.getName());
        accountWithOwners.setOfficialName(plaidAccountWithOwners.getOfficialName());
        accountWithOwners.setSubtype(plaidAccountWithOwners.getSubtype());
        accountWithOwners.setType(plaidAccountWithOwners.getType());
        accountWithOwners.setVerificationStatus(plaidAccountWithOwners.getVerificationStatus());

        return accountWithOwners;
    }

    public Balances mapPlaidBalancetoBalance(com.plaid.client.response.Account.Balances plaidBalances) {
        Balances balances = new Balances();

        balances.setAvailable(plaidBalances.getAvailable());
        balances.setCurrent(plaidBalances.getCurrent());
        balances.setIsoCurrencyCode(plaidBalances.getIsoCurrencyCode());
        balances.setLimit(plaidBalances.getLimit());
        balances.setUnofficialCurrencyCode(plaidBalances.getUnofficialCurrencyCode());

        return balances;
    }

    public ItemStatus mapPlaidItemStatusToItemStatus(com.plaid.client.response.ItemStatus plaidItemStatus) {
        ItemStatus itemStatus = new ItemStatus();

        itemStatus.setAvailableProducts(plaidItemStatus.getAvailableProducts());
        itemStatus.setBilledProducts(plaidItemStatus.getBilledProducts());
        itemStatus.setConsentExpirationTime(plaidItemStatus.getConsentExpirationTime());
        itemStatus.setError(itemStatus.getError());
        itemStatus.setInstitutionId(itemStatus.getInstitutionId());
        itemStatus.setItemId(itemStatus.getItemId());
        itemStatus.setWebhook(itemStatus.getWebhook());

        return itemStatus;
    }

    public Identity mapPlaidIdentityToIdentity(com.plaid.client.response.IdentityGetResponse.Identity plaidIdentity) {
        Identity identity = new Identity();

        List<Address> addresses = plaidIdentity.getAddresses().stream()
                .map(addr -> mapPlaidAddressToAddress(addr))
                .collect(Collectors.toList());

        List<Email> emails = plaidIdentity.getEmails().stream()
                .map(addr -> mapPlaidEmailToEmail(addr))
                .collect(Collectors.toList());

        List<PhoneNumber> phoneNumbers = plaidIdentity.getPhoneNumbers().stream()
                .map(addr -> mapPlaidPhoneNumberToPhoneNumber(addr))
                .collect(Collectors.toList());

        identity.setAddresses(addresses);
        identity.setEmails(emails);
        identity.setNames(plaidIdentity.getNames());
        identity.setPhoneNumbers(phoneNumbers);

        return identity;

    }

    public AddressData mapPlaidAddressDataToAddressData(com.plaid.client.response.IdentityGetResponse.AddressData plaidAddressData) {
        AddressData addressData = new AddressData();

        addressData.setCity(plaidAddressData.getCity());
        addressData.setCountry(plaidAddressData.getCountry());
        addressData.setPostalCode(plaidAddressData.getPostalCode());
        addressData.setRegion(plaidAddressData.getRegion());
        addressData.setStreet(plaidAddressData.getStreet());

        return addressData;
    }

    public Address mapPlaidAddressToAddress(com.plaid.client.response.IdentityGetResponse.Address plaidAddress) {
        Address address = new Address();

        address.setData(mapPlaidAddressDataToAddressData(plaidAddress.getData()));
        address.setPrimary(plaidAddress.isPrimary());

        return address;
    }

    public Email mapPlaidEmailToEmail(com.plaid.client.response.IdentityGetResponse.Email plaidEmail) {
        Email email = new Email();

        email.setData(plaidEmail.getData());
        email.setPrimary(plaidEmail.isPrimary());
        email.setType(plaidEmail.getType());

        return email;
    }

    public PhoneNumber mapPlaidPhoneNumberToPhoneNumber(com.plaid.client.response.IdentityGetResponse.PhoneNumber plaidPhoneNumber) {
        PhoneNumber phoneNumber = new PhoneNumber();

        phoneNumber.setData(plaidPhoneNumber.getData());
        phoneNumber.setPrimary(plaidPhoneNumber.isPrimary());
        phoneNumber.setType(plaidPhoneNumber.getType());

        return phoneNumber;
    }

}
