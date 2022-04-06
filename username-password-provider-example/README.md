# Example custom authenticator using `UsernamePasswordProvider`

This example implements `UsernamePasswordProvider` and supplies a username and password to a connector instance. 

Hint: you may want to edit the `com.ontotext.MyAuthenticator` class and change the supplied username and password to the actual credentials used by your connector.

## Build

Run `mvn clean install` to build the project.

## Install

1. Copy the output jar file to the relevant plugin directory, e.g. if you need it for Elasticsearch, copy the jar to `lib/plugins/elasticsearch-connector`.
2. Restart GraphDB or the repository.
3. Create a connector with `authenticationConfiguratorClass` set to `com.ontotext.example.MyAuthenticator`.

