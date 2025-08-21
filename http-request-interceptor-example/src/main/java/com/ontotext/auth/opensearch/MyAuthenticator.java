package com.ontotext.auth.opensearch;

import com.ontotext.trree.plugin.externalsync.auth.HttpClient5Configurator;

import java.nio.charset.StandardCharsets;

import org.apache.hc.client5.http.auth.CredentialsProvider;
import org.apache.hc.client5.http.utils.Base64;
import org.apache.hc.core5.http.HttpRequestInterceptor;

public class MyAuthenticator implements HttpClient5Configurator {
	@Override
	public HttpRequestInterceptor getHttpRequestInterceptor(String url, String instanceId) {
		String username = "admin";
		String password = "admin";

		byte[] credentials = Base64.encodeBase64((username + ":" + password).getBytes(StandardCharsets.UTF_8));
		String authHeader = "Basic " + new String(credentials, StandardCharsets.UTF_8);

		HttpRequestInterceptor interceptor = (httpRequest, entityDetails, httpContext) -> {
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

	@Override
	public boolean shouldDisableAuthCaching(String url, String instanceId) {
		return true;
	}

}
