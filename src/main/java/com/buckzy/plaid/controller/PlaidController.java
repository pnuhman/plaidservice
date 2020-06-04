package com.buckzy.plaid.controller;

import com.buckzy.plaid.model.AccountsBalanceResponse;
import com.buckzy.plaid.model.AuthResponse;
import com.buckzy.plaid.model.IdentityResponse;
import com.buckzy.plaid.service.PlaidService;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
public class PlaidController {

    @Autowired
    private PlaidService plaidService;

    @PostMapping(path = "/get_access_token")
    public ItemPublicTokenExchangeResponse getAccessToken(@RequestParam("public_token") String publicToken) throws IOException {

        ItemPublicTokenExchangeResponse itemPublicTokenExchangeResponse = plaidService.getAccessToken(publicToken);

        return itemPublicTokenExchangeResponse;
    }

    @PostMapping(path = "/get_access_token_customer")
    public ItemPublicTokenExchangeResponse getAccessTokenByCustomerId(@RequestParam("customerId") UUID customerId,
                                                                      @RequestParam("public_token") String publicToken) throws IOException {

        ItemPublicTokenExchangeResponse itemPublicTokenExchangeResponse = plaidService.getDetails(customerId, publicToken);

        return itemPublicTokenExchangeResponse;
    }

    @GetMapping(path = "/get_auth")
    public AuthResponse getAuth(@RequestParam("customerId") UUID customerId,
                                                   @RequestParam("itemId") String itemId) throws IOException {
        String accessToken = plaidService.getAccessToken(customerId, itemId);
        AuthResponse authResponse = plaidService.getAuth(accessToken);

        return authResponse;
    }

    @GetMapping(path = "/get_identity")
    public IdentityResponse getIdentity(@RequestParam("customerId") UUID customerId,
                                @RequestParam("itemId") String itemId) throws IOException {
        String accessToken = plaidService.getAccessToken(customerId, itemId);
        IdentityResponse identityResponse = plaidService.getIdentity(accessToken);

        return identityResponse;
    }

    @GetMapping(path = "/get_balance")
    public AccountsBalanceResponse getBalance(@RequestParam("customerId") UUID customerId,
                                              @RequestParam("itemId") String itemId) throws IOException {
        String accessToken = plaidService.getAccessToken(customerId, itemId);
        AccountsBalanceResponse accountBalance = plaidService.getAccountBalance(accessToken);

        return accountBalance;
    }
}
