package com.github.kokochi.link.developers.sdk.login.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginApiClient {

    @Value("${line.login.baseUrl}")
    private String baseUrl;

    @Value("${line.login.redirectUrl}")
    private String redirectUrl;

    @Autowired
    private LoginUtils utils;

    private HttpClient httpClient;

    public LoginApiClient() {
        this.httpClient = HttpClientBuilder.create().build();
    }

    public Map<String,Object> issueAccessToken(String code) {
        String path = LoginConstants.ISSUE_ACCESS_TOKEN;
        Map<String, Object> body = new HashMap<>();
        body.put("grant_type", "authorization_code");
        body.put("redirect_uri", redirectUrl);
        body.put("code", code);
//        System.out.println("redirectUrl :: " + redirectUrl);
//        System.out.println("code :: " + code);

        String result = httpPostRequest(path, body);
//        System.out.println("result :: " + result);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> res = objectMapper.readValue(result, Map.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String,Object> getUserProfile(String accessToken) {
        String path = LoginConstants.GET_USER_PROFILE;
//        System.out.println("redirectUrl :: " + redirectUrl);
//        System.out.println("code :: " + code)

        String result = "";
        try {
            HttpGet httpGet = new HttpGet(baseUrl + path);
            httpGet.addHeader("Authorization", "Bearer "+accessToken);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                result = EntityUtils.toString(respEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("result :: " + result);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> res = objectMapper.readValue(result, Map.class);
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
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
