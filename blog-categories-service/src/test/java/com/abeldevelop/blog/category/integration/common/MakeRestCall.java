package com.abeldevelop.blog.category.integration.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.abeldevelop.blog.category.integration.config.CucumberTestContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MakeRestCall {

    private HttpEntity<?> requestHttpEntity;
    private CucumberTestContext testContext;
    
    public MakeRestCall(CucumberTestContext testContext) {
        this.testContext = testContext;
    }
    
    public void call(String method) throws Exception {
        log.debug(CucumberTestConstants.INTEGRATION_TEST + "Make {} call", method);
        switch(method) {
            case "POST":
                makeRestCall(HttpMethod.POST);
                break;
            case "PUT":
                makeRestCall(HttpMethod.PUT);
                break;
            case "GET":
                makeRestCall(HttpMethod.GET);
                break;
            case "DELETE":
                makeRestCall(HttpMethod.DELETE);
                break;
            default:
                throw new Exception("The method '" + method + "' is not supported");
        }
    }
    
    private void createRequestHttpEntity() {
        HttpHeaders requestHeaders = testContext.getRequestHeaders();
        if(requestHeaders == null) {
            requestHeaders = new HttpHeaders();
            requestHeaders.add("Content-Type", "application/json");
        }
        requestHttpEntity = new HttpEntity<Object>(testContext.getRequestBody(), requestHeaders);
    }
    
    private void makeRestCall(HttpMethod method) throws Exception {
        createRequestHttpEntity();
        try {
            log.debug(CucumberTestConstants.INTEGRATION_TEST + "RestTemplate REQUEST url: {}", testContext.getRequestEndpoint());
            log.debug(CucumberTestConstants.INTEGRATION_TEST + "RestTemplate REQUEST method: {}", method);
            log.debug(CucumberTestConstants.INTEGRATION_TEST + "RestTemplate REQUEST requestEntity: {}", requestHttpEntity);
            ResponseEntity<String> response = new RestTemplate().exchange(testContext.getRequestEndpoint(), method, requestHttpEntity, String.class);
            log.debug(CucumberTestConstants.INTEGRATION_TEST + "RestTemplate RESPONSE: {}", response);
            addResponseInformationToContext(response);
        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                addResponseInformationToContext((HttpClientErrorException) e);
            } else {
                e.printStackTrace();
                assertThat(false).isEqualTo(true);
                throw e;
            }
        }
    }
    
    private void addResponseInformationToContext(ResponseEntity<String> response) throws Exception {
        this.testContext.setResponseHeaders(response.getHeaders());
        this.testContext.setResponseBody(response.getBody());
        this.testContext.setResponseStatus(response.getStatusCode().value());
    }
    
    private void addResponseInformationToContext(HttpClientErrorException response) throws Exception {
        this.testContext.setResponseHeaders(response.getResponseHeaders());
        this.testContext.setResponseBody(response.getResponseBodyAsString());
        this.testContext.setResponseStatus(response.getStatusCode().value());
    }
    
}