package com.buckzy.plaid.controller;

import com.buckzy.plaid.service.PlaidService;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PlaidController {

    @Autowired
    private PlaidService plaidService;

    @PostMapping(path = "/get_access_token")
    public ItemPublicTokenExchangeResponse getBankDetails247(@RequestParam("public_token") String publicToken) throws IOException {

        ItemPublicTokenExchangeResponse itemPublicTokenExchangeResponse = plaidService.getAccessToken(publicToken);

        return itemPublicTokenExchangeResponse;
    }

}
