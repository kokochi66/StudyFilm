package com.github.kokochi.link.developers.sdk.blockchain.api;

public class Constants {
    public static final String USER_REQUESTS_PATH = "/v1/user-requests/{requestSessionToken}";

    // time
    public static final String TIME_API_PATH = "/v1/time";

    // service
    public static final String SERVICE_DETAIL_API_PATH = "/v1/services/{serviceId}";

    // service-token
    public static final String SERVICE_TOKENS_PATH = "/v1/service-tokens";
    public static final String SERVICE_TOKEN_PATH = "/v1/service-tokens/{contractId}";
    public static final String SERVICE_TOKEN_BURN_PATH = "/v1/service-tokens/{contractId}/burn";
    public static final String SERVICE_TOKEN_MINT_PATH = "/v1/service-tokens/{contractId}/mint";
    public static final String SERVICE_TOKEN_HOLDERS_PATH = SERVICE_TOKEN_PATH + "/holders";

    // transaction
    public static final String TRANSACTION_PATH = "/v1/transactions/{txHash}";

    // memo
    public static final String MEMO_PATH = "/v1/memos";
    public static final String MEMO_BY_TX_HASH_PATH = "/v1/memos/{txHash}";

    // wallet
    public static final String WALLET_LIST_PATH = "/v1/wallets";
    public static final String WALLET_PATH = WALLET_LIST_PATH +"/{walletAddress}";
    public static final String WALLET_SERVICE_TOKENS_BALANCE_PATH = WALLET_PATH + "/service-tokens";
    public static final String WALLET_BASE_COIN_BALANCE_PATH = WALLET_PATH + "/base-coin";
    public static final String WALLET_SERVICE_TOKEN_BALANCE_PATH = WALLET_SERVICE_TOKENS_BALANCE_PATH + "/{contractId}";
    public static final String WALLET_FUNGIBLE_TOKENS_BALANCE_PATH = WALLET_PATH +"/item-tokens/{contractId}/fungibles";
    public static final String WALLET_FUNGIBLE_TOKEN_BALANCE_PATH = WALLET_FUNGIBLE_TOKENS_BALANCE_PATH + "/{tokenType}";
    public static final String WALLET_TRANSACTIONS_PATH = WALLET_PATH + "/transactions";
    public static final String WALLET_NON_FUNGIBLE_TOKENS_BALANCE_PATH = WALLET_PATH + "/item-tokens/{contractId}/non-fungibles";
    public static final String WALLET_NON_FUNGIBLE_TOKEN_BALANCES_BY_TYPE_PATH = WALLET_PATH + "/item-tokens/{contractId}/non-fungibles/{tokenType}";
    public static final String WALLET_NON_FUNGIBLE_TOKEN_BALANCE_PATH =
            WALLET_NON_FUNGIBLE_TOKEN_BALANCES_BY_TYPE_PATH + "/{tokenIndex}";

    // transfer
    public static final String SERVICE_TOKEN_TRANSFER_PATH =
            WALLET_SERVICE_TOKEN_BALANCE_PATH + "/transfer";

    public static final String BASE_COIN_TRANSFER_PATH = WALLET_BASE_COIN_BALANCE_PATH + "/transfer";

    public static final String WALLET_NON_FUNGIBLE_TOKEN_TRANSFER_PATH = "$WALLET_NON_FUNGIBLE_TOKEN_BALANCE_PATH/transfer";
    public static final String WALLET_NON_FUNGIBLE_TOKEN_BATCH_TRANSFER_PATH =
                "$WALLET_PATH/item-tokens/{contractId}/non-fungibles/batch-transfer";

    public static final String WALLET_FUNGIBLE_TOKEN_TRANSFER_PATH = "$WALLET_FUNGIBLE_TOKEN_BALANCE_PATH/transfer";

    // item-tokens
    public static final String ITEM_TOKEN_PATH = "/v1/item-tokens/{contractId}";
    public static final String FUNGIBLE_TOKENS_PATH = "/v1/item-tokens/{contractId}/fungibles";
    public static final String FUNGIBLE_TOKEN_PATH = "/v1/item-tokens/{contractId}/fungibles/{tokenType}";
    public static final String FUNGIBLE_TOKEN_HOLDERS_PATH = "/v1/item-tokens/{contractId}/fungibles/{tokenType}/holders";
    public static final String FUNGIBLE_TOKEN_CREATE_PATH = "/v1/item-tokens/{contractId}/fungibles";
    public static final String FUNGIBLE_TOKEN_UPDATE_PATH = "/v1/item-tokens/{contractId}/fungibles/{tokenType}";
    public static final String FUNGIBLE_TOKEN_MINT_PATH = "/v1/item-tokens/{contractId}/fungibles/{tokenType}/mint";
    public static final String FUNGIBLE_TOKEN_BURN_PATH = "/v1/item-tokens/{contractId}/fungibles/{tokenType}/burn";
    public static final String FUNGIBLE_TOKEN_STATUS_PATH = "/v1/item-tokens/{contractId}/fungibles/icon/{request-id}/status";

    public static final String NON_FUNGIBLE_TOKENS_PATH = "/v1/item-tokens/{contractId}/non-fungibles";
    public static final String NON_FUNGIBLE_TOKEN_TYPE_PATH = "/v1/item-tokens/{contractId}/non-fungibles/{tokenType}";
    public static final String NON_FUNGIBLE_TOKEN_ID_PATH =
                "/v1/item-tokens/{contractId}/non-fungibles/{tokenType}/{tokenIndex}";

    public static final String NON_FUNGIBLE_TOKEN_MINT_PATH = "/v1/item-tokens/{contractId}/non-fungibles/{tokenType}/mint";
    public static final String NON_FUNGIBLE_TOKEN_MULTI_MINT_PATH = "/v1/item-tokens/{contractId}/non-fungibles/multi-mint";
    public static final String NON_FUNGIBLE_TOKEN_BURN_PATH =
                "/v1/item-tokens/{contractId}/non-fungibles/{tokenType}/{tokenIndex}/burn";
    public static final String NON_FUNGIBLE_TOKEN_TYPE_HOLDERS_PATH =
                "/v1/item-tokens/{contractId}/non-fungibles/{tokenType}/holders";
    public static final String NON_FUNGIBLE_TOKEN_HOLDER_PATH =
                "/v1/item-tokens/{contractId}/non-fungibles/{tokenType}/{tokenIndex}/holder";
    public static final String NON_FUNGIBLE_TOKEN_CHILDREN_PATH =
                "/v1/item-tokens/{contractId}/non-fungibles/{tokenType}/{tokenIndex}/children";
    public static final String NON_FUNGIBLE_TOKEN_PARENT_PATH =
                "/v1/item-tokens/{contractId}/non-fungibles/{tokenType}/{tokenIndex}/parent";

    public static final String NON_FUNGIBLE_TOKEN_ROOT_PATH =
                "/v1/item-tokens/{contractId}/non-fungibles/{tokenType}/{tokenIndex}/root";

    // user api path
    public static final String USER_DETAIL_PATH = "/v1/users/{userId}";
    public static final String USER_TRANSACTIONS_PATH = "/v1/users/{userId}/transactions";
    public static final String USER_BASE_COIN_BALANCE_PATH = "/v1/users/{userId}/base-coin";
    public static final String USER_SERVICE_TOKENS_BALANCE_PATH = "/v1/users/{userId}/service-tokens";
    public static final String USER_SERVICE_TOKEN_BALANCE_PATH = "/v1/users/{userId}/service-tokens/{contractId}";

    public static final String USER_FUNGIBLE_TOKENS_BALANCE_PATH = "/v1/users/{userId}/item-tokens/{contractId}/fungibles";
    public static final String USER_FUNGIBLE_TOKEN_BALANCE_PATH = "/v1/users/{userId}/item-tokens/{contractId}/fungibles/{tokenType}";

    public static final String USER_NON_FUNGIBLE_TOKENS_BALANCE_PATH = "/v1/users/{userId}/item-tokens/{contractId}/non-fungibles";
    public static final String USER_NON_FUNGIBLE_TOKEN_BALANCES_BY_TYPE_PATH =
                "/v1/users/{userId}/item-tokens/{contractId}/non-fungibles/{tokenType}";
    public static final String USER_NON_FUNGIBLE_TOKEN_BALANCE_PATH =
                "/v1/users/{userId}/item-tokens/{contractId}/non-fungibles/{tokenType}/{tokenIndex}";

    public static final String REQUEST_SESSION_TOKEN_PATH = "/v1/user-requests/{requestSessionToken}";
    public static final String COMMIT_SESSION_TOKEN_PATH = "/v1/user-requests/{requestSessionToken}/commit";
    public static final String ISSUE_SESSION_TOKEN_FOR_BASE_COIN_PATH = "/v1/users/{userId}/base-coin/request-transfer";
    public static final String ISSUE_SESSION_TOKEN_FOR_SERVICE_TOKEN_PATH =
                "/v1/users/{userId}/service-tokens/{contractId}/request-transfer";
    public static final String ISSUE_SESSION_TOKEN_FOR_SERVICE_TOKEN_PROXY = "/v1/users/{userId}/service-tokens/{contractId}/request-proxy";
    public static final String ISSUE_SESSION_TOKEN_FOR_ITEM_TOKEN_PROXY = "/v1/users/{userId}/item-tokens/{contractId}/request-proxy";
    public static final String USER_SERVICE_TOKEN_IS_PROXY_PATH = "/v1/users/{userId}/service-tokens/{contractId}/proxy";
    public static final String USER_ITEM_TOKEN_IS_PROXY_PATH = "/v1/users/{userId}/item-tokens/{contractId}/proxy";
    public static final String USER_SERVICE_TOKEN_TRANSFER_PATH =
                "/v1/users/{userId}/service-tokens/{contractId}/transfer";
    public static final String USER_FUNGIBLE_TOKEN_TRANSFER_PATH =
                "/v1/users/{userId}/item-tokens/{contractId}/fungibles/{tokenType}/transfer";
    public static final String USER_NON_FUNGIBLE_TOKEN_TRANSFER_PATH =
                "/v1/users/{userId}/item-tokens/{contractId}/non-fungibles/{tokenType}/{tokenIndex}/transfer";
    public static final String USER_NON_FUNGIBLE_TOKEN_BATCH_TRANSFER_PATH = "/v1/users/{userId}/item-tokens/{contractId}/non-fungibles/batch-transfer";


    // headers
    public static final String TIME_STAMP_HEADER = "Timestamp";

}
