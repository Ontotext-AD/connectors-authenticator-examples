package com.ontotext.example;

import com.ontotext.trree.plugin.externalsync.auth.PropertiesConfigurator;

import java.util.Properties;

public class MyAuthenticator implements PropertiesConfigurator {
    @Override
    public Properties getProperties(String url, String instanceId) {
        String username = "my-username";
        String password = "my-password";

        Properties properties = new Properties();

        // This example sets the necessary properties for SASL PLAIN authentication
        properties.setProperty("sasl.jaas.config", createPlaintextJaasFromCredentials(username, password));
        properties.setProperty("sasl.mechanism", "PLAIN");
        properties.setProperty("security.protocol", "SASL_PLAINTEXT");

        return properties;
    }

    private String createPlaintextJaasFromCredentials(String username, String password) {
        return String.format("org.apache.kafka.common.security.plain.PlainLoginModule required " +
                        "username=\"%s\" password=\"%s\";",
                username.replace("\"", "\\\""),
                password.replace("\"", "\\\""));
    }
}
