# GraphDB connectors authenticator class examples

GraphDB 9.11 introduced support for providing authentication to Solr, Elasticsearch and Kafka via a custom authenticator class.

## Supported interfaces

The Connectors Authenticator SDK provides three interfaces that should cover all scenarios.

### The `UsernamePasswordProvider` interface

This interface provides a simple mechanism that allows a custom class to supply a username and a password. It can be used with Solr, Elasticsearch and Kafka.

This is the most straightforward and basic scenario.

Example project: [username-password-provider-example](username-password-provider-example) 

### The `HttpClientConfigurator` interface

This interface provides flexible support for custom authentication for the connectors that use HTTP for server communication -- Solr and Elasticsearch.

It has two mechanisms:

#### The `CredentialsProvider` mechanism

This mechanism is based on [Apache HttpClient's CredentialsProvider](https://hc.apache.org/httpcomponents-client-4.5.x/current/httpclient/apidocs/org/apache/http/client/CredentialsProvider.html). It can be used to instantiate a `CredentialsProvider` and let it handle the authentication.

This mechanism covers well-defined authentication scenarios, for which there might exist a ready-to-use `CredentialsProvider`.

#### The `HttpRequestInterceptor` mechanism

This mechanism is based on [Apache HttpCore's HttpRequestInterceptor](https://hc.apache.org/httpcomponents-core-4.4.x/current/httpcore/apidocs/org/apache/http/HttpRequestInterceptor.html). It can be used to inject any header into the request, including custom authentication headers.

This is the most flexible mechanism and should be able to cover all kinds of scenarios.

### The `PropertiesConfigurator` interface

This interface provides support for specifying custom properties for the Kafka producer. All authentication configuration in Kafka is done through setting properties.

Example project: [properties-configurator-example](properties-configurator-example)
