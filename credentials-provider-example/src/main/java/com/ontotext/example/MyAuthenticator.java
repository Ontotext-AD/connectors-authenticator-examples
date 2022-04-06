package com.ontotext.example;

import com.ontotext.trree.plugin.externalsync.auth.HttpClientConfigurator;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;

public class MyAuthenticator implements HttpClientConfigurator {
    @Override
    public CredentialsProvider getCredentialsProvider(String url, String instanceId) {
        String username = "my-username";
        String password = "my-password";

        // This example creates a CredentialsProvider for HTTP Basic authentication
        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

        return provider;
    }

    @Override
    public HttpRequestInterceptor getHttpRequestInterceptor(String url, String instanceId) {
        // Returning null means we don't want to provide an interceptor
        return null;
    }
}
