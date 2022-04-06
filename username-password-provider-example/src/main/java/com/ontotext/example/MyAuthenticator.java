package com.ontotext.example;

import com.ontotext.trree.plugin.externalsync.auth.UsernamePasswordProvider;

public class MyAuthenticator implements UsernamePasswordProvider {
    @Override
    public Credentials getCredentials(String url, String instanceId) {

        String username = "my-username";
        String password = "my-password";

        //You can create а custom class that implements Credentials
        Credentials credentials = new SimpleCredentials(username, password);

        return credentials;
    }
}
