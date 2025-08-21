package com.ontotext.auth.opensearch;

import java.net.URI;

import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.CredentialsProvider;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import com.ontotext.trree.plugin.externalsync.auth.HttpClient5Configurator;


public class MyAuthenticator implements HttpClient5Configurator {
	@Override
	public CredentialsProvider getCredentialsProvider(String url, String instanceId) {
		String username = "admin";
		String password = "admin";

		BasicCredentialsProvider provider = new BasicCredentialsProvider();
		AuthScope authScope = new AuthScope(
				URI.create(url).getHost(), URI.create(url).getPort() != -1 ? URI.create(url).getPort() : 9200);
		provider.setCredentials(authScope, new UsernamePasswordCredentials(username, password.toCharArray()));

		return provider;
	}

	@Override
	public HttpRequestInterceptor getHttpRequestInterceptor(String url, String instanceId) {
		return null;
	}

	@Override
	public boolean shouldDisableAuthCaching(String url, String instanceId) {
		return true;
	}
}