package com.github.kokochi.link.developers.sdk.blockchain.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

public class Request {

    @Getter @Setter public static class UpdateServiceTokenRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String name;
        private String meta;
    }

    @Getter @Setter public static class BurnServiceTokenRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String amount;
        private String fromUserId;
        private String fromAddress;
    }

    @Getter @Setter public static class MintServiceTokenRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String toAddress;
        private String toUserId;
        private String amount;
    }

    @Getter @Setter public static class MemoRequest {
        private String memo;
        private String walletAddress;
        private String walletSecret;
    }

    @Getter @Setter public static class TransferBaseCoinRequest extends AbstractTransactionRequest {
        private String walletSecret;
        private String toAddress;
        private String toUserId;
        private String amount;
    }

    @Getter @Setter public static class TransferServiceTokenRequest extends AbstractTransactionRequest {
        private String walletSecret;
        private String toAddress;
        private String toUserId;
        private String amount;
    }

    @Getter @Setter public static class TransferFungibleTokenRequest extends AbstractTransactionRequest {
        private String walletSecret;
        private String toAddress;
        private String toUserId;
        private String amount;
    }

    @Getter @Setter public static class TransferTokenOfUserRequest extends AbstractTransactionRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String toAddress;
        private String toUserId;
        private String amount;
    }

    @Getter @Setter public static class TransferNonFungibleRequest extends AbstractTransactionRequest {
        private String walletSecret;
        private String toAddress;
        private String toUserId;
    }

    @Getter @Setter public static class TransferNonFungibleOfUserRequest extends AbstractTransactionRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String toAddress;
        private String toUserId;
    }

    @Getter @Setter public static class BatchTransferNonFungibleRequest extends AbstractTransactionRequest {
        private String walletSecret;
        private String toAddress;
        private String toUserId;
        Collection<TokenId> transferList;
    }

    @Getter @Setter public static class BatchTransferNonFungibleOfUserRequest extends AbstractTransactionRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String toAddress;
        private String toUserId;
        Collection<TokenId> transferList;
    }

    @Getter @Setter public static class TokenId {
        private String tokenId;
        private String tokenIdFormat = "\\d{8}\\d{8}";
        private Integer tokenIdLength = 16;
//        KOTLIN::CHECK
//        init {
//            require(tokenId.length == tokenIdLength) { "Invalid tokenId: length of token-id has to be 16" }
//            require(tokenIdFormat.matches(tokenId)) { "Invalid tokenId: invalid format of tokenId, valid format is $tokenIdFormat" }
//        }
    }

    @Getter
    @Setter
    public static class FungibleTokenCreateUpdateRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String name;
        private String meta;
    }

    @Getter @Setter public static class FungibleTokenMintRequest extends AbstractTransactionRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String toAddress;
        private String toUserId;
        private String amount;
    }

    @Getter @Setter public static class FungibleTokenItemTokenBurnRequest extends AbstractItemTokenBurnTransactionRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String fromUserId;
        private String fromAddress;
        private String amount;
    }

    @Getter @Setter public static class NonFungibleTokenCreateUpdateRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String name;
        private String meta;
    }

    @Getter @Setter public static class NonFungibleTokenMintRequest extends AbstractTransactionRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String toAddress;
        private String toUserId;
        private String name;
        private String meta;
    }

    @Getter @Setter public static class NonFungibleTokenMultiMintRequest extends AbstractTransactionRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String toAddress;
        private String toUserId;
        Collection<MultiMintNonFungible> mintList;
    }


    @Getter @Setter public static class MultiMintNonFungible {
        private String tokenType;
        private String name;
        private String meta;
    }

    @Getter @Setter public static class NonFungibleTokenItemTokenBurnRequest extends AbstractItemTokenBurnTransactionRequest {
        private String ownerAddress;
        private String ownerSecret;
        private String fromUserId;
        private String fromAddress;
    }

    @Getter @Setter public static class NonFungibleTokenItemTokenAttachRequest {
        private String parentTokenId;
        private String serviceWalletAddress;
        private String serviceWalletSecret;
        private String tokenHolderAddress;
        private String tokenHolderUserId;
//        KOTLIN:CHECK
//        init {
//            require(tokenHolderAddress != null || tokenHolderUserId != null) {
//                "tokenHolderAddress or tokenHolderUserId, one of them is required"
//            }
//        }
    }

    @Getter @Setter public static class NonFungibleTokenItemTokenDetachRequest {
        private String serviceWalletAddress;
        private String serviceWalletSecret;
        private String tokenHolderAddress;
        private String tokenHolderUserId;
//        KOTLIN:CHECK
//        init {
//            require(tokenHolderAddress != null || tokenHolderUserId != null) {
//                "tokenHolderAddress or tokenHolderUserId, one of them is required"
//            }
//        }
    }


    @Getter @Setter public static class UserServiceTokenTransferRequest extends AbstractTransactionRequest {
        private String toAddress;
        private String toUserId;
        private String amount;
        private String landingUri;
//        KOTLIN:CHECK
//        init {
//            try {
//                if (amount.toBigInteger() <= BigInteger.ZERO) {
//                    throw IllegalArgumentException("Invalid amount - $amount is less than zero ")
//                }
//            } catch (e: NumberFormatException) {
//                throw IllegalArgumentException("Invalid amount - $amount is not a number ")
//            }
//        }
    }

    @Getter @Setter public static class UserAssetProxyRequest {
        private String ownerAddress;
        private String landingUri;
    }

    public abstract static class AbstractItemTokenBurnTransactionRequest {
        private String fromUserId;
        private String fromAddress;
//        KOTLIN:CHECK
//        init {
//            require(fromAddress != null || fromUserId != null) { "fromAddress or fromUserId, one of them is required" }
//        }
    }

    @Getter @Setter public static class AbstractTransactionRequest {
        private String toAddress;
        private String toUserId;
//        KOTLIN::CHECK
//        init {
//            require(toAddress != null || toUserId != null) { "toAddress or toUserId, one of them is required" }
//        }
    }

    public enum OrderBy {
        ASC {
            @Override
            public String toString() {
                return "asc";
            }
        }, DESC {
            @Override
            public String toString() {
                return "desc";
            }
        };
//        KOTLIN::CHECK
//        fun toParameter(): private String = this.name.toLowerCase()
    }

    public enum RequestType {
        REDIRECT_URI, AOA;
//        KOTLIN:CHECK
//        REDIRECT_URI("redirectUri"), AOA("aoa");
//        fun toParameter(): private String = this.type
    }

}
