# Example custom authenticator using `PropertiesConfigurator`

This example implements `PropertiesConfigurator` and supplies the necessary properties for Kafka SASL PLAIN authentication using a username and a password.

Hint: you may want to edit the `com.ontotext.MyAuthenticator` class and change the supplied username and password to the actual credentials used by your connector.

## Build

Run `mvn clean install` to build the project.

## Install

1. Copy the output jar file to the relevant plugin directory, i.e. `lib/plugins/kafka-connector`.
2. Restart GraphDB or the repository.
3. Create a connector with `authenticationConfiguratorClass` set to `com.ontotext.example.MyAuthenticator`.

