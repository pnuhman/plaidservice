package com.buckzy.plaid.service;

import com.buckzy.plaid.mapper.PlaidMapper;
import com.buckzy.plaid.model.AccountsBalanceResponse;
import com.buckzy.plaid.model.AuthResponse;
import com.buckzy.plaid.model.IdentityResponse;
import com.plaid.client.PlaidClient;
import com.plaid.client.request.AccountsBalanceGetRequest;
import com.plaid.client.request.AuthGetRequest;
import com.plaid.client.request.IdentityGetRequest;
import com.plaid.client.request.ItemPublicTokenExchangeRequest;
import com.plaid.client.response.AccountsBalanceGetResponse;
import com.plaid.client.response.AuthGetResponse;
import com.plaid.client.response.IdentityGetResponse;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class PlaidService {

    private static final Logger LOG = LoggerFactory.getLogger(PlaidService.class);
    // We store the accessToken in memory - in production, store it in a secure
    // persistent data store.
    public static String accessToken;
    // The payment_token is only relevant for the UK Payment Initiation product.
    // We store the paymentToken in memory - in production, store it in a secure
    // persistent data store.
    public static String paymentToken;
    public static String paymentId;
    @Autowired
    private PlaidMapper plaidMapper;
    private PlaidClient plaidClient;
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

        getAuth(accessToken);
        getIdentity(accessToken);
        getAccountBalance(accessToken);

        return itemResponse.body();
    }

    public AuthResponse getAuth(String accessToken) throws IOException {

        Response<AuthGetResponse> authGetResponse = plaidClient.service()
                .authGet(new AuthGetRequest(accessToken))
                .execute();

        AuthResponse authResponse = plaidMapper.mapPlaidAuthGetResponseToAuthGetResponse(authGetResponse.body());

        LOG.info("getAuth: " + authResponse);

        return authResponse;
    }

    public IdentityResponse getIdentity(String accessToken) throws IOException {

        Response<IdentityGetResponse> IdentityGetResponse = plaidClient.service()
                .identityGet(new IdentityGetRequest(accessToken))
                .execute();

        IdentityResponse identityResponse = plaidMapper.mapPlaidIdentityGetResponseToIdentityGetResponse(IdentityGetResponse.body());

        LOG.info("getIdentity: " + identityResponse);

        return identityResponse;
    }

    public AccountsBalanceResponse getAccountBalance(String accessToken) throws IOException {
        Response<AccountsBalanceGetResponse> accountsBalanceGetResponseResponse = plaidClient.service()
                .accountsBalanceGet(new AccountsBalanceGetRequest(accessToken))
                .execute();

        AccountsBalanceResponse accountsBalanceResponse = plaidMapper.
                mapPlaidAccountsBalanceGetResponseToAccountsBalanceGetResponse(accountsBalanceGetResponseResponse.body());

        LOG.info("getAccountBalance: " + accountsBalanceResponse);

        return accountsBalanceResponse;
    }
}
