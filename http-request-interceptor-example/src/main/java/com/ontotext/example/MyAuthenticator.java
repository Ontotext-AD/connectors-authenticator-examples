package com.ontotext.example;

import com.ontotext.trree.plugin.externalsync.auth.HttpClientConfigurator;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyAuthenticator implements HttpClientConfigurator {
    @Override
    public HttpRequestInterceptor getHttpRequestInterceptor(String url, String instanceId) {
        String username = "my-username";
        String password = "my-password";

        byte[] credentials = Base64.encodeBase64((username + ":" + password).getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + new String(credentials, StandardCharsets.UTF_8);

        HttpRequestInterceptor interceptor = (httpRequest, httpContext) -> {
            // This example provides HTTP Basic pre-emptive authentication by injecting the Authorization header
            // on every HTTP request.
            httpRequest.setHeader("Authorization", authHeader);
        };

        return interceptor;
    }

    @Override
    public CredentialsProvider getCredentialsProvider(String url, String instanceId) {
        // Returning null means we don't want to provide a credentials provider
        return null;
    }
}
