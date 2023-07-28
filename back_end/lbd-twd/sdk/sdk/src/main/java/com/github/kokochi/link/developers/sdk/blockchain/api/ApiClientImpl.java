package com.github.kokochi.link.developers.sdk.blockchain.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kokochi.link.developers.sdk.blockchain.http.Utils;
import com.github.kokochi.link.developers.sdk.blockchain.model.dto.ApiKeySecret;
import com.github.kokochi.link.developers.sdk.blockchain.model.request.Request.*;
import com.github.kokochi.link.developers.sdk.blockchain.model.response.Response.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.util.EntityUtils;

import java.util.*;

public class ApiClientImpl implements ApiClient {

    private final String baseUrl;
    private final HttpClient httpClient;
    private final ApiKeySecret apiKeySecret;
    private Utils utils;

    public ApiClientImpl(String baseUrl, HttpClient httpClient, ApiKeySecret apiKeySecret) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
        this.apiKeySecret = apiKeySecret;
        this.utils = new Utils(baseUrl, apiKeySecret);
    }

    @Override
    public GenericResponse<String> time() {
        String path = Constants.TIME_API_PATH;
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<String> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<UserRequestStatus> userRequests(String requestSessionToken) {
        return null;
    }

    @Override
    public GenericResponse<ServiceDetail> serviceDetail(String serviceDetail) {
        String path = Constants.SERVICE_DETAIL_API_PATH
                .replace("{serviceId}", serviceDetail);
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<ServiceDetail> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<ServiceToken>> serviceTokens() {
        String path = Constants.SERVICE_TOKENS_PATH;
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<ServiceToken>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<ServiceToken> serviceToken(String contractId) {
        String path = Constants.SERVICE_TOKEN_PATH
                .replace("{contractId}", contractId);
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<ServiceToken> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<ServiceTokenHolder>> serviceTokenHolders(String contractId, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.SERVICE_TOKEN_HOLDERS_PATH
                .replace("{contractId}", contractId);
        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<ServiceTokenHolder>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> updateServiceToken(String contractId, UpdateServiceTokenRequest request) {
        String path = Constants.SERVICE_TOKEN_PATH
                .replace("{contractId}", contractId);
        Map<String, Object> body = new HashMap<>();
        if(request.getName() != null) body.put("name", request.getName());
        if(request.getMeta() != null) body.put("meta", request.getMeta());
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());

        String result = httpPutRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> mintServiceToken(String contractId, MintServiceTokenRequest request) {
        String path = Constants.SERVICE_TOKEN_MINT_PATH
                .replace("{contractId}", contractId);
        Map<String, Object> body = new HashMap<>();
        if(request.getToUserId() != null) body.put("toUserId", request.getToUserId());
        if(request.getToAddress() != null) body.put("toAddress", request.getToAddress());
        if(request.getAmount() != null) body.put("amount", request.getAmount());
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> burnServiceToken(String contractId, BurnServiceTokenRequest request) {
        String path = Constants.SERVICE_TOKEN_BURN_PATH
                .replace("{contractId}", contractId);
        Map<String, Object> body = new HashMap<>();
        if(request.getFromUserId() != null) body.put("fromUserId", request.getFromUserId());
        if(request.getFromAddress() != null) body.put("fromAddress", request.getFromAddress());
        if(request.getAmount() != null) body.put("amount", request.getAmount());
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TxResultResponse> transaction(String txHash) {
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> saveMemo(MemoRequest request) {
        return null;
    }

    @Override
    public GenericResponse<Memo> queryMemo(String txHash) {
        return null;
    }

    @Override
    public GenericResponse<Collection<WalletResponse>> wallets() {
        String path = Constants.WALLET_LIST_PATH;
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<WalletResponse>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<WalletResponse> wallet(String walletAddress) {
        String path = Constants.WALLET_PATH.replace("{walletAddress}", walletAddress);
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<WalletResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<TxResultResponse>> transactionOfWallet(String walletAddress, Long after, Long before, Integer limit, String msgType, OrderBy orderBy, Integer page) {
        String path = Constants.WALLET_TRANSACTIONS_PATH;
            Map<String, Object> query = new HashMap<>();
            if(after != null) query.put("after", after);
            if(before != null) query.put("before", before);
            if(limit != null) query.put("limit", limit);
            if(msgType != null) query.put("msgType", msgType);
            if(orderBy != null) query.put("orderBy", orderBy);
            if(page != null) query.put("page", page);

            String result = httpGetRequest(path, query);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                GenericResponse<Collection<TxResultResponse>> res = objectMapper.readValue(result, GenericResponse.class);
                return res;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public GenericResponse<BaseCoinBalance> baseCoinBalanceOfWallet(String walletAddress) {
        String path = Constants.WALLET_BASE_COIN_BALANCE_PATH.replace("{walletAddress}", walletAddress);
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<BaseCoinBalance> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> transferBaseCoin(String walletAddress, TransferBaseCoinRequest request) {
        String path = Constants.BASE_COIN_TRANSFER_PATH
                .replace("{walletAddress}", walletAddress);
        Map<String, Object> body = new HashMap<>();
        if(request.getWalletSecret() != null) body.put("walletSecret", request.getWalletSecret());
        if(request.getToAddress() != null) body.put("toAddress", request.getToAddress());
        if(request.getToUserId() != null) body.put("toUserId", request.getToUserId());
        if(request.getAmount() != null) body.put("amount", request.getAmount());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<ServiceTokenBalance>> serviceTokenBalancesOfWallet(String walletAddress, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.WALLET_SERVICE_TOKENS_BALANCE_PATH
                .replace("{walletAddress}", walletAddress);
        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<ServiceTokenBalance>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<ServiceTokenBalance> serviceTokenBalanceOfWallet(String walletAddress, String contractId) {
        String path = Constants.WALLET_SERVICE_TOKEN_BALANCE_PATH
                .replace("{walletAddress}", walletAddress)
                .replace("{contractId}", contractId);
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<ServiceTokenBalance> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> transferServiceToken(String walletAddress, String contractId, TransferServiceTokenRequest request) {
        String path = Constants.SERVICE_TOKEN_TRANSFER_PATH
                .replace("{walletAddress}", walletAddress)
                .replace("{contractId}", contractId);
        Map<String, Object> body = new HashMap<>();
        if(request.getWalletSecret() != null) body.put("walletSecret", request.getWalletSecret());
        if(request.getToAddress() != null) body.put("toAddress", request.getToAddress());
        if(request.getToUserId() != null) body.put("toUserId", request.getToUserId());
        if(request.getAmount() != null) body.put("amount" , request.getAmount());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<FungibleBalance>> fungibleTokensBalanceOfWallet(String walletAddress, String contractId, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.WALLET_FUNGIBLE_TOKENS_BALANCE_PATH
                .replace("{walletAddress}", walletAddress)
                .replace("{contractId}", contractId);
        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<FungibleBalance>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<FungibleBalance> fungibleTokenBalanceOfWallet(String walletAddress, String contractId, String tokenType) {
        String path = Constants.WALLET_FUNGIBLE_TOKEN_BALANCE_PATH
                .replace("{walletAddress}", walletAddress)
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<FungibleBalance> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> transferFungibleTokenOfWallet(String walletAddress, String contractId, String tokenType, TransferFungibleTokenRequest request) {
        String path = Constants.WALLET_FUNGIBLE_TOKEN_TRANSFER_PATH
                .replace("{walletAddress}", walletAddress)
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);
        Map<String, Object> body = new HashMap<>();
        if(request.getWalletSecret() != null) body.put("walletSecret", request.getWalletSecret());
        if(request.getToAddress() != null) body.put("toAddress", request.getToAddress());
        if(request.getToUserId() != null) body.put("toUserId", request.getToUserId());
        if(request.getAmount() != null) body.put("amount" , request.getAmount());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<NonFungibleBalance>> nonFungibleTokenBalancesOfWallet(String walletAddress, String contractId, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.WALLET_NON_FUNGIBLE_TOKENS_BALANCE_PATH
                .replace("{walletAddress}", walletAddress)
                .replace("{contractId}", contractId);
        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<NonFungibleBalance>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<TokenIndex>> nonFungibleTokenBalancesOfWalletByType(String walletAddress, String contractId, String tokenType, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.WALLET_NON_FUNGIBLE_TOKEN_BALANCES_BY_TYPE_PATH
                .replace("{walletAddress}", walletAddress)
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);
        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<TokenIndex>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TokenIndex> nonFungibleTokenBalanceOfWallet(String walletAddress, String contractId, String tokenType, String tokenIndex) {
        String path = Constants.WALLET_NON_FUNGIBLE_TOKEN_BALANCE_PATH
                .replace("{walletAddress}", walletAddress)
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TokenIndex> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> transferNonFungibleTokenOfWallet(String walletAddress, String contractId, String tokenType, String tokenIndex, TransferNonFungibleRequest request) {
        String path = Constants.WALLET_FUNGIBLE_TOKEN_TRANSFER_PATH
                .replace("{walletAddress}", walletAddress)
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);
        Map<String, Object> body = new HashMap<>();
        if(request.getWalletSecret() != null) body.put("walletSecret", request.getWalletSecret());
        if(request.getToAddress() != null) body.put("toAddress", request.getToAddress());
        if(request.getToUserId() != null) body.put("toUserId", request.getToUserId());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> batchTransferNonFungibleTokenOfWallet(String walletAddress, String contractId, BatchTransferNonFungibleRequest request) {
        String path = Constants.WALLET_NON_FUNGIBLE_TOKEN_BATCH_TRANSFER_PATH
                .replace("{walletAddress}", walletAddress)
                .replace("{contractId}", contractId);
        Map<String, Object> body = new HashMap<>();
        if(request.getWalletSecret() != null) body.put("walletSecret", request.getWalletSecret());
        if(request.getToAddress() != null) body.put("toAddress", request.getToAddress());
        if(request.getToUserId() != null) body.put("toUserId", request.getToUserId());
        if(request.getTransferList() != null) {
            List<Map<String, Object>> transferList = new ArrayList<>();
            for (TokenId tokenId : request.getTransferList()) {
                Map<String, Object> map = new HashMap<>();
                if(tokenId.getTokenId() != null) map.put("tokenId", tokenId.getTokenId());
                transferList.add(map);
            }
            body.put("transferList", transferList);
        }
        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<ItemToken> itemToken(String contractId) {
        String path = Constants.ITEM_TOKEN_PATH
                .replace("{contractId}", contractId);
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<ItemToken> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<FungibleToken>> fungibleTokens(String contractId, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.FUNGIBLE_TOKENS_PATH
                .replace("{contractId}", contractId);
        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<FungibleToken>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<FungibleToken> fungibleToken(String contractId, String tokenType) {
        String path = Constants.FUNGIBLE_TOKEN_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);

        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<FungibleToken> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<FungibleTokenHolder>> fungibleTokenHolders(String contractId, String tokenType, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.FUNGIBLE_TOKEN_HOLDERS_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);
        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<FungibleTokenHolder>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> createFungible(String contractId, FungibleTokenCreateUpdateRequest request) {
        String path = Constants.FUNGIBLE_TOKENS_PATH
                .replace("{contractId}", contractId);
        Map<String, Object> body = new HashMap<>();
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());
        if(request.getName() != null) body.put("name", request.getName());
        if(request.getMeta() != null) body.put("meta", request.getMeta());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> updateFungible(String contractId, String tokenType, FungibleTokenCreateUpdateRequest request) {
        String path = Constants.FUNGIBLE_TOKEN_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);
        Map<String, Object> body = new HashMap<>();
        if(request.getName() != null) body.put("name", request.getName());
        if(request.getMeta() != null) body.put("meta", request.getMeta());
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());

        String result = httpPutRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> mintFungible(String contractId, String tokenType, FungibleTokenMintRequest request) {
        String path = Constants.FUNGIBLE_TOKEN_MINT_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);
        Map<String, Object> body = new HashMap<>();
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());
        if(request.getToUserId() != null) body.put("toUserId", request.getToUserId());
        if(request.getToAddress() != null) body.put("toAddress", request.getToAddress());
        if(request.getAmount() != null) body.put("amount", request.getAmount());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> burnFungible(String contractId, String tokenType, FungibleTokenItemTokenBurnRequest request) {
        String path = Constants.FUNGIBLE_TOKEN_BURN_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);
        Map<String, Object> body = new HashMap<>();
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());
        if(request.getFromUserId() != null) body.put("fromUserId", request.getFromUserId());
        if(request.getFromAddress() != null) body.put("fromAddress", request.getFromAddress());
        if(request.getAmount() != null) body.put("amount", request.getAmount());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<ItemTokenType>> nonFungibleTokenTypes(String contractId, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.NON_FUNGIBLE_TOKENS_PATH
                .replace("{contractId}", contractId);
        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<ItemTokenType>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> createNonFungibleType(String contractId, NonFungibleTokenCreateUpdateRequest request) {
        String path = Constants.NON_FUNGIBLE_TOKENS_PATH
                .replace("{contractId}", contractId);
        Map<String, Object> body = new HashMap<>();
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());
        if(request.getName() != null) body.put("name", request.getName());
        if(request.getMeta() != null) body.put("meta", request.getMeta());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<NonFungibleTokenType> nonFungibleTokenType(String contractId, String tokenType, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.NON_FUNGIBLE_TOKEN_TYPE_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);
        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<NonFungibleTokenType> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> updateNonFungibleTokenType(String contractId, String tokenType, NonFungibleTokenCreateUpdateRequest request) {
        String path = Constants.NON_FUNGIBLE_TOKEN_TYPE_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);
        Map<String, Object> body = new HashMap<>();
        if(request.getName() != null) body.put("name", request.getName());
        if(request.getMeta() != null) body.put("meta", request.getMeta());
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());

        String result = httpPutRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<NonFungibleId> nonFungibleToken(String contractId, String tokenType, String tokenIndex) {
        String path = Constants.NON_FUNGIBLE_TOKEN_ID_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);

        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<NonFungibleId> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> updateNonFungibleToken(String contractId, String tokenType, String tokenIndex, NonFungibleTokenCreateUpdateRequest request) {
        String path = Constants.NON_FUNGIBLE_TOKEN_ID_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);
        Map<String, Object> body = new HashMap<>();
        if(request.getName() != null) body.put("name", request.getName());
        if(request.getMeta() != null) body.put("meta", request.getMeta());
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());

        String result = httpPutRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> mintNonFungible(String contractId, String tokenType, NonFungibleTokenMintRequest request) {
        String path = Constants.NON_FUNGIBLE_TOKEN_MINT_PATH
                        .replace("{contractId}", contractId)
                        .replace("{tokenType}", tokenType);
        Map<String, Object> body = new HashMap<>();
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());
        if(request.getToAddress() != null) body.put("toAddress", request.getToAddress());
        if(request.getToUserId() != null) body.put("toUserId", request.getToUserId());
        if(request.getName() != null) body.put("name", request.getName());
        if(request.getMeta() != null) body.put("meta", request.getMeta());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<NonFungibleTokenTypeHolder>> nonFungibleTokenTypeHolders(String contractId, String tokenType, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.NON_FUNGIBLE_TOKEN_TYPE_HOLDERS_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType);

        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<NonFungibleTokenTypeHolder>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<NonFungibleTokenHolder> nonFungibleTokenHolder(String contractId, String tokenType, String tokenIndex) {
        String path = Constants.NON_FUNGIBLE_TOKEN_HOLDER_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);

        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<NonFungibleTokenHolder> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> multiMintNonFungible(String contractId, NonFungibleTokenMultiMintRequest request) {
        String path = Constants.NON_FUNGIBLE_TOKEN_MULTI_MINT_PATH
                .replace("{contractId}", contractId);
        Map<String, Object> body = new HashMap<>();
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());
        if(request.getToAddress() != null) body.put("toAddress", request.getToAddress());
        if(request.getToUserId() != null) body.put("toUserId", request.getToUserId());
        if(request.getMintList() != null) {
            List<Map<String, Object>> minList = new ArrayList<>();
            for (MultiMintNonFungible multiMintNonFungible : request.getMintList()) {
                Map<String, Object> map = new HashMap<>();
                if(multiMintNonFungible.getMeta() != null) map.put("meta", multiMintNonFungible.getMeta());
                if(multiMintNonFungible.getName() != null) map.put("name", multiMintNonFungible.getName());
                if(multiMintNonFungible.getTokenType() != null) map.put("tokenType", multiMintNonFungible.getTokenType());
                minList.add(map);
            }
            body.put("minList", minList);
        }

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> burnNonFungible(String contractId, String tokenType, String tokenIndex, NonFungibleTokenItemTokenBurnRequest request) {
        String path = Constants.NON_FUNGIBLE_TOKEN_BURN_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);
        Map<String, Object> body = new HashMap<>();
        if(request.getOwnerAddress() != null) body.put("ownerAddress", request.getOwnerAddress());
        if(request.getOwnerSecret() != null) body.put("ownerSecret", request.getOwnerSecret());
        if(request.getFromUserId() != null) body.put("fromUserId", request.getFromUserId());
        if(request.getFromAddress() != null) body.put("fromAddress", request.getFromAddress());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<NonFungibleId>> nonFungibleTokenChildren(String contractId, String tokenType, String tokenIndex, Integer limit, Integer page, OrderBy orderBy) {
        String path = Constants.NON_FUNGIBLE_TOKEN_CHILDREN_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);

        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy);
        if(page != null) query.put("page", page);

        String result = httpGetRequest(path, query);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<Collection<NonFungibleId>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<NonFungibleId> nonFungibleTokenParent(String contractId, String tokenType, String tokenIndex) {
        String path = Constants.NON_FUNGIBLE_TOKEN_PARENT_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);

        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<NonFungibleId> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<NonFungibleId> nonFungibleTokenRoot(String contractId, String tokenType, String tokenIndex) {
        String path = Constants.NON_FUNGIBLE_TOKEN_ROOT_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);

        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<NonFungibleId> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> attachNonFungible(String contractId, String tokenType, String tokenIndex, NonFungibleTokenItemTokenAttachRequest request) {
        String path = Constants.NON_FUNGIBLE_TOKEN_PARENT_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);
        Map<String, Object> body = new HashMap<>();
        if(request.getParentTokenId() != null) body.put("parentTokenId", request.getParentTokenId());
        if(request.getServiceWalletAddress() != null) body.put("serviceWalletAddress", request.getServiceWalletAddress());
        if(request.getServiceWalletSecret() != null) body.put("serviceWalletSecret", request.getServiceWalletSecret());
        if(request.getTokenHolderAddress() != null) body.put("tokenHolderAddress", request.getTokenHolderAddress());
        if(request.getTokenHolderUserId() != null) body.put("tokenHolderUserId", request.getTokenHolderUserId());

        String result = httpPostRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> detachNonFungible(String contractId, String tokenType, String tokenIndex, NonFungibleTokenItemTokenDetachRequest request) {
        String path = Constants.NON_FUNGIBLE_TOKEN_PARENT_PATH
                .replace("{contractId}", contractId)
                .replace("{tokenType}", tokenType)
                .replace("{tokenIndex}", tokenIndex);
        Map<String, Object> body = new HashMap<>();
        if(request.getServiceWalletAddress() != null) body.put("serviceWalletAddress", request.getServiceWalletAddress());
        if(request.getServiceWalletSecret() != null) body.put("serviceWalletSecret", request.getServiceWalletSecret());
        if(request.getTokenHolderAddress() != null) body.put("tokenHolderAddress", request.getTokenHolderAddress());
        if(request.getTokenHolderUserId() != null) body.put("tokenHolderUserId", request.getTokenHolderUserId());

        String result = httpDeleteRequest(path, body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<TransactionResponse> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<UserIdAddress> userDetail(String userId) {
        String path = Constants.USER_DETAIL_PATH
                .replace("{userId}", userId);
        String result = httpGetRequest(path, null);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<UserIdAddress> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<Collection<TxResultResponse>> transactionOfUser(String userId, Integer limit, Integer page, OrderBy orderBy, Long before, Long after) {
        String path = Constants.USER_TRANSACTIONS_PATH
                .replace("{userId}", userId);
        Map<String, Object> query = new HashMap<>();
        if(limit != null) query.put("limit", limit);
        if(orderBy != null) query.put("orderBy", orderBy.toString());
        if(page != null) query.put("page", page);
        if(before != null) query.put("before", before);
        if(after != null) query.put("after", after);

        String result = httpGetRequest(path, query);
        System.out.println("result :: " + result);
        ObjectMapper objectMapper = new ObjectMapper();
        try {

//            Map<String, Object> map = objectMapper.readValue(result, Map.class);
//            for (Object responseData : (ArrayList) map.get("responseData")) {
//                System.out.println("response :: " + responseData.getClass().getSimpleName()  + "  " + ((Map) responseData).get("logs"));
//            }
            //            Map<String,Object>[] responseData = objectMapper.readValue((String) map.get("responseData"), Map[].class);
//            for (Map<String,Object> maps : responseData) {
//                for (String s : maps.keySet()) {
//                    System.out.println("transactionOfUser :: " + s +" :: " + maps.get(s));
//                }
//                System.out.println();
//            }

            GenericResponse<Collection<TxResultResponse>> res = objectMapper.readValue(result, GenericResponse.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericResponse<BaseCoinBalance> baseCoinBalanceOfUser(String userId) {
        return null;
    }

    @Override
    public GenericResponse<Collection<ServiceTokenBalance>> serviceTokenBalancesOfUser(String userId, Integer limit, Integer page, OrderBy orderBy) {
        return null;
    }

    @Override
    public GenericResponse<ServiceTokenBalance> serviceTokenBalanceOfUser(String userId, String contractId) {
        return null;
    }

    @Override
    public GenericResponse<Collection<FungibleBalance>> fungibleTokenBalancesOfUser(String userId, String contractId, Integer limit, Integer page, OrderBy orderBy) {
        return null;
    }

    @Override
    public GenericResponse<FungibleBalance> fungibleTokenBalanceOfUser(String userId, String contractId, String tokenType) {
        return null;
    }

    @Override
    public GenericResponse<Collection<NonFungibleBalance>> nonFungibleTokenBalancesOfUser(String userId, String contractId, Integer limit, Integer page, OrderBy orderBy) {
        return null;
    }

    @Override
    public GenericResponse<Collection<TokenIndex>> nonFungibleTokenBalancesOfUser(String userId, String contractId, String tokenType, Integer limit, Integer page, OrderBy orderBy) {
        return null;
    }

    @Override
    public GenericResponse<TokenIndex> nonFungibleTokenBalanceOfUser(String userId, String contractId, String tokenType, String tokenIndex) {
        return null;
    }

    @Override
    public GenericResponse<RequestSessionStatus> requestSessionToken(String requestSessionToken) {
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> commitRequestSession(String requestSessionToken) {
        return null;
    }

    @Override
    public GenericResponse<RequestSession> issueSessionTokenForBaseCoinTransfer(String userId, RequestType requestType) {
        return null;
    }

    @Override
    public GenericResponse<RequestSession> issueSessionTokenForServiceTokenProxy(String userId, String contractId, RequestType requestType, UserAssetProxyRequest requestUser) {
        return null;
    }

    @Override
    public GenericResponse<RequestSession> issueSessionTokenForServiceTokenTransfer(String userId, String contractId, RequestType requestType, UserServiceTokenTransferRequest request) {
        return null;
    }

    @Override
    public GenericResponse<RequestSession> issueSessionTokenForItemTokenProxy(String userId, String contractId, RequestType requestType, UserAssetProxyRequest requestUser) {
        return null;
    }

    @Override
    public GenericResponse<ProxyStatus> isProxyOfServiceToken(String userId, String contractId) {
        return null;
    }

    @Override
    public GenericResponse<ProxyStatus> isProxyOfItemToken(String userId, String contractId) {
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> transferServiceTokenOfUser(String userId, String contractId, TransferTokenOfUserRequest request) {

        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> transferFungibleTokenOfUser(String userId, String contractId, String tokenType, TransferTokenOfUserRequest request) {
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> transferNonFungibleTokenOfUser(String userId, String contractId, String tokenType, String tokenIndex, TransferNonFungibleOfUserRequest request) {
        return null;
    }

    @Override
    public GenericResponse<TransactionResponse> batchTransferNonFungibleTokenOfUser(String userId, String contractId, BatchTransferNonFungibleOfUserRequest request) {
        return null;
    }


    private String httpGetRequest(String path, Map<String, Object> map) {
        try {
            HttpGet httpGet = utils.installGet(path, null);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                return EntityUtils.toString(respEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String httpPostRequest(String path, Map<String, Object> body) {
        try {
            HttpPost httpPost = utils.installPost(path, body);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                return EntityUtils.toString(respEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String httpPutRequest(String path, Map<String, Object> body) {
        try {
            HttpPut httpPut = utils.installPut(path, body);
            HttpResponse response = httpClient.execute(httpPut);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                return EntityUtils.toString(respEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String httpDeleteRequest(String path, Map<String, Object> body) {
        try {
            return utils.installDelete(path, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}