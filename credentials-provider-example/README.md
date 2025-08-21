# Example Custom Authenticator with Separate Packages

This repository contains two separate authenticator implementations for different HTTP client versions:

- **`com.ontotext.example.example.MyAuthenticator`**: Implements `HttpClientConfigurator` (for HttpClient 4.x) and provides 
  HTTP Basic authentication using a `HttpRequestInterceptor` used for most connectors.
- **`com.ontotext.opensearch.MyAuthenticator`**: Implements `HttpClient5Configurator` (for HttpClient 5.x) and provides 
  HTTP Basic authentication, designed for OpenSearch connectors.

**Hint**: Edit the respective `MyAuthenticator` class in each package and update the username and password to match your connector's credentials.

## Build

Run `mvn clean install` to build the project.

## Install

1. Copy the output jar file to the relevant plugin directory:
    - For Elasticsearch or other HttpClient 4.x connectors, use `lib/plugins/elasticsearch-connector`.
    - For OpenSearch (HttpClient 5.x), use `lib/plugins/opensearch-connector`.
2. Restart GraphDB or the repository.
3. Create a connector with `authenticationConfiguratorClass` set to:
    - `com.ontotext.auth.example.MyAuthenticator` for HttpClient 4.x connectors.
    - `com.ontotext.auth.opensearch.MyAuthenticator` for OpenSearch.
