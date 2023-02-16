# Fatecando REST API

This is the backend of the [Fatecando application](https://github.com/guto-alves/fatecando), providing only a REST API. <b>There is no UI</b>. The [fatecando-web](https://github.com/guto-alves/fatecando) project is a front-end application that consumes the REST API.

## Running locally
### With maven command line
```
git clone https://github.com/guto-alves/fatecando-api.git
cd fatecando-api
mvnw spring-boot:run -Dspring-boot.run.profiles=dev,h2
```

You can then access fatecando here: [http://localhost:8081](http://localhost:8081)

## Swagger REST API documentation presented here (after application start):
You can reach the swagger UI with this URL [http://localhost:8081/swagger-ui/](http://localhost:8081/swagger-ui/)

## Screenshot of the Fatecando Application Client
<img width="1042" alt="everyone-screenshot" src="https://user-images.githubusercontent.com/48946749/140944337-07f98804-6fc6-4671-8f2a-9673247f6dd8.png">

## In case you find a bug/suggested improvement for Fatecando
Our issue tracker is available here: https://github.com/guto-alves/fatecando-api/issues

## Database Configuration
In its default configuration, Fatecando uses an in-memory database (H2) which
gets populated at startup with data. The h2 console is exposed at `http://localhost:8081/h2-console`,
and it is possible to inspect the content of the database using the `jdbc:h2:mem:testdb` url.
 
A similar setup is provided for MySQL and PostgreSQL if a persistent database configuration is needed. Note that whenever the database type changes, the app needs to run with a different profile: `spring.profiles.active=mysql` for MySQL or `spring.profiles.active=postgresql` for PostgreSQL.

## Working with Fatecando in Eclipse / Spring Tool Suite (STS)

### Prerequisites
The following items should be installed in your system:
* Java 17 or newer (full JDK, not a JRE).
* [git command line tool](https://help.github.com/articles/set-up-git)
* Your preferred IDE 
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
  not there, follow the install process [here](https://www.eclipse.org/m2e/)
  
### Steps:

1) On the command line run:
    ```
    git clone https://github.com/guto-alves/fatecando-api.git
    ```
2) Inside Eclipse or STS:
    ```
    File -> Import -> Maven -> Existing Maven project
    ```

## Looking for something in particular?

| Layer | Source |
|--|--|
| REST API controllers | [REST folder](/src/main/java/com/gutotech/fatecandoapi/rest) |
| Service | [Service folder](/src/main/java/com/gutotech/fatecandoapi/service) |
| Spring Data JPA | [JPA folder](/src/main/java/com/gutotech/fatecandoapi/repository) |
| Security | [Security folder](/src/main/java/com/gutotech/fatecandoapi/security) |
