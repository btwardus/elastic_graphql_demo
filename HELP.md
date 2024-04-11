# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/gradle-plugin/reference/html/#build-image)
* [Spring Data Elasticsearch (Access+Driver)](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#data.nosql.elasticsearch)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web.graphql)

### Usage
Set the following environment variables:
```shell
export ELASTICSEARCH_HOST=localhost
export ELASTICSEARCH_PASSWORD=changeme
```

Alternatively you can source them from .env file:
```shell
source .env
```

To build the project use gradle wrapper:
```shell
./gradlew build
```
To run the project use gradle wrapper:
```shell
./gradlew bootRun
```

In 1 step:
```shell
source .env && ./gradlew build && ./gradlew bootRun
```

### Guides
The following guides illustrate how to use some features concretely:

* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

