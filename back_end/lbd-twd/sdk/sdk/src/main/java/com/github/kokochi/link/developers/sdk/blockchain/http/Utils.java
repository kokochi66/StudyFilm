package com.github.kokochi.link.developers.sdk.blockchain.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kokochi.link.developers.sdk.blockchain.model.dto.ApiKeySecret;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

public class Utils {

    private String baseUrl;
    private ApiKeySecret apiKeySecret;

    public Utils(String baseUrl, ApiKeySecret apiKeySecret) {
        this.baseUrl = baseUrl;
        this.apiKeySecret = apiKeySecret;
    }

    public HttpGet installGet(String path, Map<String, Object> query) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String nonce = generatedRandomString(8);
        String currentMilliseconds = Long.toString(System.currentTimeMillis());
        String signature = signatureGenerator(apiKeySecret.secret, nonce, currentMilliseconds, "GET",path, mapToBodyString(query), "");

//        System.out.println("apiKey :: " + apiKeySecret.key);
//        System.out.println("nonce :: " + nonce);
//        System.out.println("currentMilliseconds :: " + currentMilliseconds);
//        System.out.println("signature :: " + signature);
//        System.out.println("url :: " + baseUrl + path + mapToBodyString(query));
//        System.out.println("query :: " + mapToBodyString(query));

        HttpGet httpGet = new HttpGet(baseUrl + path + mapToBodyString(query));
        httpGet.addHeader("service-api-key", apiKeySecret.key);
        httpGet.addHeader("nonce", nonce);
        httpGet.addHeader("timestamp", currentMilliseconds);
        httpGet.addHeader("signature", signature);
        return httpGet;
    }

    public HttpPost installPost(String path, Map<String, Object> body) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
        String nonce = generatedRandomString(8);
        String currentMilliseconds = Long.toString(System.currentTimeMillis());
        String signature = signatureGenerator(apiKeySecret.secret, nonce, currentMilliseconds, "POST",path, "" , mapToBodyString(body));

//        System.out.println("apiKey :: " + apiKeySecret.key);
//        System.out.println("nonce :: " + nonce);
//        System.out.println("currentMilliseconds :: " + currentMilliseconds);
//        System.out.println("signature :: " + signature);
//        System.out.println("url :: " + baseUrl + path);
//        System.out.println("body :: " + mapToBodyString(body));

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
        HttpPost httpPost = new HttpPost(baseUrl + path);
        httpPost.addHeader("Service-api-key", apiKeySecret.key);
        httpPost.addHeader("nonce", nonce);
        httpPost.addHeader("timestamp", currentMilliseconds);
        httpPost.addHeader("signature", signature);

        StringEntity requestEntity = new StringEntity(requestBody , "utf-8");
        requestEntity.setContentType(new BasicHeader("Content-Type", "application/json"));
        httpPost.setEntity(requestEntity);
        return httpPost;
    }

    public HttpPut installPut(String path, Map<String, Object> body) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
        String nonce = generatedRandomString(8);
        String currentMilliseconds = Long.toString(System.currentTimeMillis());
        String signature = signatureGenerator(apiKeySecret.secret, nonce, currentMilliseconds, "POST",path, "" , mapToBodyString(body));

//        System.out.println("apiKey :: " + apiKeySecret.key);
//        System.out.println("nonce :: " + nonce);
//        System.out.println("currentMilliseconds :: " + currentMilliseconds);
//        System.out.println("signature :: " + signature);
//        System.out.println("url :: " + baseUrl + path);
//        System.out.println("body :: " + mapToBodyString(body));

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
        HttpPut httpPut = new HttpPut(baseUrl + path);
        httpPut.addHeader("Service-api-key", apiKeySecret.key);
        httpPut.addHeader("nonce", nonce);
        httpPut.addHeader("timestamp", currentMilliseconds);
        httpPut.addHeader("signature", signature);

        StringEntity requestEntity = new StringEntity(requestBody , "utf-8");
        requestEntity.setContentType(new BasicHeader("Content-Type", "application/json"));
        httpPut.setEntity(requestEntity);
        return httpPut;
    }

    public String installDelete(String path, Map<String, Object> body) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
        String nonce = generatedRandomString(8);
        String currentMilliseconds = Long.toString(System.currentTimeMillis());
        String signature = signatureGenerator(apiKeySecret.secret, nonce, currentMilliseconds, "POST",path, "" , mapToBodyString(body));

//        System.out.println("apiKey :: " + apiKeySecret.key);
//        System.out.println("nonce :: " + nonce);
//        System.out.println("currentMilliseconds :: " + currentMilliseconds);
//        System.out.println("signature :: " + signature);
//        System.out.println("url :: " + baseUrl + path);
//        System.out.println("body :: " + mapToBodyString(body));

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
        HttpDelete httpDelete = new HttpDelete(baseUrl + path);
        httpDelete.addHeader("Service-api-key", apiKeySecret.key);
        httpDelete.addHeader("nonce", nonce);
        httpDelete.addHeader("timestamp", currentMilliseconds);
        httpDelete.addHeader("signature", signature);

        StringEntity requestEntity = new StringEntity(requestBody , "utf-8");
        requestEntity.setContentType(new BasicHeader("Content-Type", "application/json"));


        HttpHeaders headers = new HttpHeaders();
        headers.add("Service-api-key", apiKeySecret.key);
        headers.add("nonce", nonce);
        headers.add("timestamp", currentMilliseconds);
        headers.add("signature", signature);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(baseUrl + path, HttpMethod.DELETE, entity, String.class);

        return responseEntity.toString();
    }

    private String generatedRandomString(int length) {
        Random random = new Random();
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        return  random.ints(leftLimit,rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static String HmacAndBase64(String secret, String data, String Algorithms) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes("utf-8"), Algorithms);
        Mac hasher = Mac.getInstance(Algorithms);
        hasher.init(secretKey);
        byte[] hash = hasher.doFinal(data.getBytes());
        return Base64.encodeBase64String(hash);
    }

    private String signatureGenerator(String serviceApiSecret, String nonce, String timeStamp, String method, String url, String query, String body) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String sig_temp = nonce + timeStamp + method + url + query + body;
        System.out.println("signatureGenerator :: " + sig_temp);
        return HmacAndBase64(serviceApiSecret, sig_temp, "HmacSHA512");
    }


    public String mapToBodyString(Map<String, Object> map) {
        if(map == null || map.isEmpty() || map.size() == 0) return "";
        return mapToBodyStringConvert(sortMapByKey(map), null);
    }

    private String mapToBodyStringConvert(Map<String, Object> map, String name) {
        StringBuilder res = new StringBuilder("?");

        for (String s : map.keySet()) {
            if(map.get(s) instanceof Map) {
                res.append(mapToBodyStringConvert((Map<String,Object>) map.get(s), s));
                res.append("&");
            } else if(map.get(s) instanceof List) {
                Map<String, Object> tempMap = new HashMap<>();
                for (Map<String, Object> sMap : (List<Map<String, Object>>) map.get(s)) {
                    for (String s1 : sMap.keySet()) {
                        if(!tempMap.containsKey(s1)) {
                            tempMap.put(s1, sMap.get(s1));
                        } else {
                            tempMap.replace(s1, tempMap.get(s1)+","+sMap.get(s1));
                        }
                    }
                }
                for (String s1 : tempMap.keySet()) {
                    res.append(s+"."+s1+"="+tempMap.get(s1));
                    res.append("&");
                }
            }
            else {
                if(name != null) res.append(name+".");
                res.append(s + "=" + map.get(s));
                res.append("&");
            }

        }

        return res.deleteCharAt(res.length()-1).toString();
    }

    private Map<String, Object> sortMapByKey(Map<String, Object> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
