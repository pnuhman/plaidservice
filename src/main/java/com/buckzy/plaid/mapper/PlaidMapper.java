package com.buckzy.plaid.mapper;

import com.buckzy.plaid.model.*;

public class PlaidMapper {

    public AuthGetResponse mapPlaidAuthGetResponseToAuthGetResponse(){
        AuthGetResponse authGetResponse = new AuthGetResponse();

    }

    public NumberACH mapPlaidNumberACHToNumberACH(com.plaid.client.response.AuthGetResponse.NumberACH plaidNumberACH){
        NumberACH numberACH = new NumberACH();

        numberACH.setAccount(plaidNumberACH.getAccount());
        numberACH.setAccountId(plaidNumberACH.getAccountId());
        numberACH.setRouting(plaidNumberACH.getRouting());
        numberACH.setWireRouting(plaidNumberACH.getWireRouting());

        return numberACH;
    }

    public NumberBACS mapPlaidNumberBACSToNumberBACS(com.plaid.client.response.AuthGetResponse.NumberBACS plaidNumberBACS){
        NumberBACS numberBACS = new NumberBACS();

        numberBACS.setAccount(plaidNumberBACS.getAccount());
        numberBACS.setAccountId(plaidNumberBACS.getAccountId());
        numberBACS.setSortCode(plaidNumberBACS.getSortCode());

        return numberBACS;
    }

    public NumberEFT mapPlaidNumberEFTToNumberEFT(com.plaid.client.response.AuthGetResponse.NumberEFT plaidNumberEFT){
        NumberEFT numberEFT = new NumberEFT();

        numberEFT.setAccount(plaidNumberEFT.getAccount());
        numberEFT.setAccountId(plaidNumberEFT.getAccountId());
        numberEFT.setBranch(plaidNumberEFT.getBranch());
        numberEFT.setInstitution(plaidNumberEFT.getInstitution());

        return numberEFT;
    }

    public NumberInternational mapPlaidInternationalACHToInternational(com.plaid.client.response.AuthGetResponse.NumberInternational plaidNumberInternational){
        NumberInternational numberInternational = new NumberInternational();
    }

    public Numbers mapPlaidNumbersToNumbers(com.plaid.client.response.AuthGetResponse.Numbers plaidNumbers){
        Numbers numbers = new Numbers();
    }
}
