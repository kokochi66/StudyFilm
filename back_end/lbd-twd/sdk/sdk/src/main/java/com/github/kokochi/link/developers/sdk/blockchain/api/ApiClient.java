package com.github.kokochi.link.developers.sdk.blockchain.api;

import com.github.kokochi.link.developers.sdk.blockchain.model.request.Request.*;
import com.github.kokochi.link.developers.sdk.blockchain.model.response.Response.*;

import java.util.Collection;

public interface ApiClient {
    GenericResponse<String> time();
    GenericResponse<UserRequestStatus> userRequests(String requestSessionToken);
    GenericResponse<ServiceDetail> serviceDetail(String serviceDetail);
    GenericResponse<Collection<ServiceToken>> serviceTokens();
    GenericResponse<ServiceToken> serviceToken(String contractId);
    GenericResponse<Collection<ServiceTokenHolder>> serviceTokenHolders(String contractId, Integer limit, Integer page, OrderBy orderBy);
    GenericResponse<TransactionResponse> updateServiceToken(String contractId, UpdateServiceTokenRequest request);
    GenericResponse<TransactionResponse> mintServiceToken(String contractId, MintServiceTokenRequest request);
    GenericResponse<TransactionResponse> burnServiceToken(String contractId, BurnServiceTokenRequest request);
    GenericResponse<TxResultResponse> transaction(String txHash);
    GenericResponse<TransactionResponse> saveMemo(MemoRequest request);
    GenericResponse<Memo> queryMemo(String txHash);
    GenericResponse<Collection<WalletResponse>> wallets();
    GenericResponse<WalletResponse> wallet(String walletAddress);
    GenericResponse<Collection<TxResultResponse>> transactionOfWallet(
            String walletAddress, Long after, Long before, Integer limit,
            String msgType, OrderBy orderBy, Integer page
    );
    GenericResponse<BaseCoinBalance> baseCoinBalanceOfWallet(String walletAddress);
    GenericResponse<TransactionResponse> transferBaseCoin(String walletAddress, TransferBaseCoinRequest request);
    GenericResponse<Collection<ServiceTokenBalance>> serviceTokenBalancesOfWallet(
            String walletAddress, Integer limit, Integer page, OrderBy orderBy
    );
    GenericResponse<ServiceTokenBalance> serviceTokenBalanceOfWallet(String walletAddress, String contractId);
    GenericResponse<TransactionResponse> transferServiceToken(String walletAddress, String contractId, TransferServiceTokenRequest request);
    GenericResponse<Collection<FungibleBalance>> fungibleTokensBalanceOfWallet(
            String walletAddress, String contractId, Integer limit, Integer page, OrderBy orderBy
    );
    GenericResponse<FungibleBalance> fungibleTokenBalanceOfWallet(String walletAddress, String contractId, String tokenType);
    GenericResponse<TransactionResponse> transferFungibleTokenOfWallet(String walletAddress, String contractId, String tokenType, TransferFungibleTokenRequest request);
    GenericResponse<Collection<NonFungibleBalance>> nonFungibleTokenBalancesOfWallet(
            String walletAddress, String contractId, Integer limit, Integer page, OrderBy orderBy
    );
    GenericResponse<Collection<TokenIndex>> nonFungibleTokenBalancesOfWalletByType(
            String walletAddress, String contractId, String tokenType,
            Integer limit, Integer page, OrderBy orderBy
    );
    GenericResponse<TokenIndex> nonFungibleTokenBalanceOfWallet(String walletAddress, String contractId, String tokenType, String tokenIndex);
    GenericResponse<TransactionResponse> transferNonFungibleTokenOfWallet(
            String walletAddress, String contractId, String tokenType, String tokenIndex, TransferNonFungibleRequest request
    );
    GenericResponse<TransactionResponse> batchTransferNonFungibleTokenOfWallet(String walletAddress, String contractId, BatchTransferNonFungibleRequest request);
    GenericResponse<ItemToken> itemToken(String contractId);
    GenericResponse<Collection<FungibleToken>> fungibleTokens(String contractId, Integer limit, Integer page, OrderBy orderBy);
    GenericResponse<FungibleToken> fungibleToken(String contractId, String tokenType);
    GenericResponse<Collection<FungibleTokenHolder>> fungibleTokenHolders(
            String contractId, String tokenType, Integer limit, Integer page, OrderBy orderBy
    );
    GenericResponse<TransactionResponse> createFungible(String contractId, FungibleTokenCreateUpdateRequest request);
    GenericResponse<TransactionResponse> updateFungible(String contractId, String tokenType, FungibleTokenCreateUpdateRequest request);
    GenericResponse<TransactionResponse> mintFungible(String contractId, String tokenType, FungibleTokenMintRequest request);
    GenericResponse<TransactionResponse> burnFungible(String contractId, String tokenType, FungibleTokenItemTokenBurnRequest request);
    GenericResponse<Collection<ItemTokenType>> nonFungibleTokenTypes(String contractId, Integer limit, Integer page, OrderBy orderBy);

    GenericResponse<TransactionResponse> createNonFungibleType(String contractId, NonFungibleTokenCreateUpdateRequest request);
    GenericResponse<NonFungibleTokenType> nonFungibleTokenType(String contractId, String tokenType, Integer limit, Integer page, OrderBy orderBy);
    GenericResponse<TransactionResponse> updateNonFungibleTokenType(String contractId, String tokenType, NonFungibleTokenCreateUpdateRequest request);
    GenericResponse<NonFungibleId> nonFungibleToken(String contractId, String tokenType,String tokenIndex);
    GenericResponse<TransactionResponse> updateNonFungibleToken(String contractId, String tokenType,String tokenIndex, NonFungibleTokenCreateUpdateRequest request);
    GenericResponse<TransactionResponse> mintNonFungible(String contractId, String tokenType, NonFungibleTokenMintRequest request);
    GenericResponse<Collection<NonFungibleTokenTypeHolder>> nonFungibleTokenTypeHolders(String contractId, String tokenType, Integer limit, Integer page, OrderBy orderBy);

    GenericResponse<NonFungibleTokenHolder> nonFungibleTokenHolder(String contractId, String tokenType,String tokenIndex);
    GenericResponse<TransactionResponse> multiMintNonFungible(String contractId, NonFungibleTokenMultiMintRequest request);
    GenericResponse<TransactionResponse> burnNonFungible(String contractId, String tokenType, String tokenIndex, NonFungibleTokenItemTokenBurnRequest request);
    GenericResponse<Collection<NonFungibleId>> nonFungibleTokenChildren(String contractId, String tokenType, String tokenIndex, Integer limit, Integer page, OrderBy orderBy);

    GenericResponse<NonFungibleId> nonFungibleTokenParent(String contractId, String tokenType, String tokenIndex);
    GenericResponse<NonFungibleId> nonFungibleTokenRoot(String contractId, String tokenType, String tokenIndex);
    GenericResponse<TransactionResponse> attachNonFungible(String contractId, String tokenType, String tokenIndex, NonFungibleTokenItemTokenAttachRequest request);
    GenericResponse<TransactionResponse> detachNonFungible(String contractId, String tokenType, String tokenIndex, NonFungibleTokenItemTokenDetachRequest request);
    GenericResponse<UserIdAddress> userDetail(String userId);

    GenericResponse<Collection<TxResultResponse>> transactionOfUser(String userId, Integer limit, Integer page, OrderBy orderBy, Long before, Long after);
    GenericResponse<BaseCoinBalance> baseCoinBalanceOfUser(String userId);

    GenericResponse<Collection<ServiceTokenBalance>> serviceTokenBalancesOfUser(String userId, Integer limit, Integer page, OrderBy orderBy);
    GenericResponse<ServiceTokenBalance> serviceTokenBalanceOfUser(String userId, String contractId);
    GenericResponse<Collection<FungibleBalance>> fungibleTokenBalancesOfUser(String userId, String contractId, Integer limit, Integer page, OrderBy orderBy);
    GenericResponse<FungibleBalance> fungibleTokenBalanceOfUser(String userId, String contractId, String tokenType);

    GenericResponse<Collection<NonFungibleBalance>> nonFungibleTokenBalancesOfUser(String userId, String contractId, Integer limit, Integer page, OrderBy orderBy);
    GenericResponse<Collection<TokenIndex>> nonFungibleTokenBalancesOfUser(String userId, String contractId, String tokenType, Integer limit, Integer page, OrderBy orderBy);

    GenericResponse<TokenIndex> nonFungibleTokenBalanceOfUser(String userId, String contractId, String tokenType, String tokenIndex);

    GenericResponse<RequestSessionStatus> requestSessionToken(String requestSessionToken);
    GenericResponse<TransactionResponse> commitRequestSession(String requestSessionToken);
    GenericResponse<RequestSession> issueSessionTokenForBaseCoinTransfer(String userId, RequestType requestType);
    GenericResponse<RequestSession> issueSessionTokenForServiceTokenProxy(String userId, String contractId, RequestType requestType, UserAssetProxyRequest requestUser);
    GenericResponse<RequestSession> issueSessionTokenForServiceTokenTransfer(String userId, String contractId, RequestType requestType, UserServiceTokenTransferRequest request);
    GenericResponse<RequestSession> issueSessionTokenForItemTokenProxy(String userId, String contractId, RequestType requestType, UserAssetProxyRequest requestUser);
    GenericResponse<ProxyStatus> isProxyOfServiceToken(String userId, String contractId);
    GenericResponse<ProxyStatus> isProxyOfItemToken(String userId, String contractId);

    GenericResponse<TransactionResponse> transferServiceTokenOfUser(String userId, String contractId, TransferTokenOfUserRequest request);
    GenericResponse<TransactionResponse> transferFungibleTokenOfUser(String userId, String contractId, String tokenType, TransferTokenOfUserRequest request);
    GenericResponse<TransactionResponse> transferNonFungibleTokenOfUser(String userId, String contractId, String tokenType, String tokenIndex, TransferNonFungibleOfUserRequest request);
    GenericResponse<TransactionResponse> batchTransferNonFungibleTokenOfUser(String userId, String contractId, BatchTransferNonFungibleOfUserRequest request);

//    KOTLIN::CHECK
//    fun LocalDateTime.toEpochMilli(): Long = this.toInstant(ZoneOffset.UTC).toEpochMilli()
}
