package com.buckzy.plaid.service;

import com.plaid.client.PlaidClient;
import com.plaid.client.request.AccountsBalanceGetRequest;
import com.plaid.client.request.AccountsGetRequest;
import com.plaid.client.request.IdentityGetRequest;
import com.plaid.client.request.ItemPublicTokenExchangeRequest;
import com.plaid.client.response.AccountsBalanceGetResponse;
import com.plaid.client.response.AccountsGetResponse;
import com.plaid.client.response.IdentityGetResponse;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class PlaidService {

    private static final Logger LOG = LoggerFactory.getLogger(PlaidService.class);

    private PlaidClient plaidClient;
    // We store the accessToken in memory - in production, store it in a secure
    // persistent data store.
    public static String accessToken;
    // The payment_token is only relevant for the UK Payment Initiation product.
    // We store the paymentToken in memory - in production, store it in a secure
    // persistent data store.
    public static String paymentToken;
    public static String paymentId;

    @Value("${plaid.clientId}")
    private String plaidClientId;

    @Value("${plaid.secret}")
    private String plaidSecret;

    @Value("${plaid.publicKey}")
    private String plaidPublicKey;


    @PostConstruct
    public void setPlaidService() {

        plaidClient = PlaidClient.newBuilder()
                .clientIdAndSecret(plaidClientId, plaidSecret)
                .publicKey(plaidPublicKey) // optional. only needed to call endpoints that require a public key
                .sandboxBaseUrl() // or equivalent, depending on which environment you're calling into
                .build();

    }

    public ItemPublicTokenExchangeResponse getAccessToken(String publicToken) throws IOException {
        Response<ItemPublicTokenExchangeResponse> itemResponse = plaidClient.service()
                .itemPublicTokenExchange(new ItemPublicTokenExchangeRequest(publicToken))
                .execute();

        accessToken = itemResponse.body().getAccessToken();

        LOG.info("public token: " + publicToken);
        LOG.info("access token: " + accessToken);
        LOG.info("item ID: " + itemResponse.body().getItemId());

        getIdentity(accessToken);

        return itemResponse.body();
    }

    public IdentityGetResponse getIdentity(String accessToken) throws IOException {

        Response<IdentityGetResponse> IdentityGetResponse = plaidClient.service()
                .identityGet(new IdentityGetRequest(accessToken))
                .execute();


        LOG.info("getIdentity: " + IdentityGetResponse.body().getAccounts());

        return  IdentityGetResponse.body();
    }

    public AccountsBalanceGetResponse getAccountBalance(String accessToken) throws IOException {
        Response<AccountsBalanceGetResponse> accountsBalanceGetResponseResponse = plaidClient.service()
                .accountsBalanceGet(new AccountsBalanceGetRequest(accessToken))
                .execute();

        return  accountsBalanceGetResponseResponse.body();
    }

}
