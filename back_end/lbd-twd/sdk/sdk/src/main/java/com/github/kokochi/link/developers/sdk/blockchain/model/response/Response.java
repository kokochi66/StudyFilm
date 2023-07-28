package com.github.kokochi.link.developers.sdk.blockchain.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@ToString
public class Response {

    @Getter @Setter
    @ToString
    public static class GenericResponse<T> {
        Long responseTime;
        Integer statusCode;
        String statusMessage;
        T responseData;
    }

    @Getter @Setter
    public class ServiceDetail {
        String serviceId;
        String name;
        String description;
        String category;
    }


    @Getter @Setter
    public class UserRequestStatus {RequestSessionTokenStatus status;}
    enum RequestSessionTokenStatus {
        Authorized, Unauthorized;
    }

    @Getter @Setter
    public class ServiceToken {
        String contractId;
        String ownerAddress;
        Long createdAt;
        String serviceId;
        Integer decimals;
        String name;
        String symbol;
        String meta;
        String imgUri;
        String totalSupply;
        String totalMint;
        String totalBurn;
    }

    @Getter @Setter
    public class ServiceTokenHolder {
        String address;
        String userId;
        String amount;
    }

    @Getter @Setter @ToString
    public class TransactionResponse {String txHash;}

    @Getter @Setter @ToString
    public class TxResultResponse {
        Long height;
//        @JsonProperty("txhash")
        String txHash;
        String codespace;
        Integer code;
        Integer index;
        String data;
        List<LogResponse> logs;
        String info;
        Long gasWanted;
        Long gasUsed;
        TypedValueResponse<StdTxResponse> tx;
        Date timestamp;
    }
    @Getter @Setter @ToString
    public class LogResponse {
        Integer msgIndex;
        String log;
        List<EventResponse> events;
    }
    @Getter @Setter @ToString
    public class EventResponse {
        String type;
        List<KeyValueResponse<String>> attributes;
    }
    @Getter @Setter @ToString
    public class KeyValueResponse<T> {String key;T value;}
    @Getter @Setter @ToString
    public class TypedValueResponse<T> {String type;T value;}

    @Getter @Setter
    public class StdTxResponse {
        List<TypedValueResponse<?>> msg;
        FeeResponse fee;
        String memo;
        List<SignatureResponse> signatures;
    }

    @Getter @Setter public class FeeResponse {
        BigInteger gas;
        List<CoinResponse> amount;
    }
    @Getter @Setter public class SignatureResponse {
        TypedValueResponse<Byte[]> pubKey;
        Byte[] signature;
    }

    @Getter @Setter public class BaseCoinBalance {
        String symbol;
        Long decimals;
        String amount;
    }

    @Getter @Setter public class CoinResponse {
        String denom;
        BigInteger amount;

        @Override
        public String toString() {
            return amount.toString() + denom;
        }
    }

    @Getter @Setter public class Memo {
        String memo;
    }

    @Getter @Setter
    public static class WalletResponse {
        String name;
        String walletAddress;
        Long createdAt;
    }

    @Getter @Setter public class ServiceTokenBalance {
        String contractId;
        String name;
        String symbol;
        String imgUri;
        Long decimals;
        String amount;
    }

    @Getter @Setter public class FungibleBalance {
        String tokenType;
        String name;
        String meta;
        String amount;
    }

    @Getter @Setter public class NonFungibleBalance {
        String tokenType;
        String name;
        String meta;
        String numberOfIndex;
    }

    @Getter @Setter public class TokenIndex{String tokenIndex; String name; String meta;}

    @Getter @Setter public class ItemToken {
        String contractId;
        String baseImgUri;
        String ownerAddress;
        String serviceId;
        Long createdAt;
    }

    @Getter @Setter public class FungibleToken {
        String name;
        String meta;
        String tokenType;
        String totalSupply;
        String totalMint;
        String totalBurn;
        Long createdAt;
    }

    @Getter @Setter public class FungibleTokenHolder {
        String userId;
        String walletAddress;
        String amount;
    }

    @Getter @Setter public class ItemTokenType {
        String name;
        String meta;
        String tokenType;
        String totalSupply;
        String totalMint;
        String totalBurn;
        Long createdAt;
    }

    @Getter @Setter public class NonFungibleTokenType {
        String name;
        String meta;
        String tokenType;
        BigInteger totalSupply;
        BigInteger totalMint;
        BigInteger totalBurn;
        Long createdAt;
        List<NonFungibleIndex> token;
    }

    @Getter @Setter public class NonFungibleIndex {
        String tokenIndex;
        String name;
        String meta;
        Long createdAt;
        Long burnedAt;
    }

    @Getter @Setter public class NonFungibleId {
        String tokenId;
        String name;
        String meta;
        Long createdAt;
        Long burnedAt;
    }

    @Getter @Setter public class NonFungibleTokenTypeHolder {
        String userId;
        String walletAddress;
        String numberOfIndex;
    }

    @Getter @Setter public class NonFungibleTokenHolder {
        String tokenId;
        String userId;
        String walletAddress;
        String amount;
    }

    @Getter @Setter public class UserIdAddress {String userId; String address;}
    @Getter @Setter public class RequestSession {String requestSessionToken; String redirectUri;}

    @JsonDeserialize(using = RequestSessionStatusDeserializer.class)
    public enum RequestSessionStatus {
        AUTHORIZED, UNAUTHORIZED
    }

    @Getter @Setter public class RequestSessionStatusDeserializer extends StdDeserializer<RequestSessionStatus> {

        protected RequestSessionStatusDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public RequestSessionStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
            JsonNode node = jsonParser.getCodec().readTree(jsonParser);
            String status = node.get("status").asText();

            return RequestSessionStatus.values()[0];
        }
//        KOTLIN:CHECK
//        return RequestSessionStatus.values().firstOrNull() {
//            it.name == status.toUpperCase()
//        } ?: throw InvalidResponseValueException("invalid request-session-status")
    }

    @Getter @Setter public class ProxyStatus {
        Boolean isApproved;
    }

    @Getter @Setter public class Unit {}









}
