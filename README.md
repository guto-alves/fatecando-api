# fatecando-api

This is the backend of the Fatecando application, providing only a REST API. <b>There is no UI</b>. The [fatecando-web](https://github.com/guto-alves/fatecando-web) project is a front-end application that consumes the REST API.

## Running locally

### With maven command line

```
https://github.com/guto-alves/fatecando-api.git
cd fatecando-api
./mvnw spring-boot:run
```

## Working with Fatecando in Eclipse / Spring Tool Suite (STS)

### Prerequisites
The following items should be installed in your system:

 - Maven 3 (https://maven.apache.org/install.html)
 - git command line tool (https://help.github.com/articles/set-up-git)
 - Eclipse with the m2e plugin (m2e is installed by default when using the STS (https://spring.io/tools) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog. If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/

### Steps:

1) On the command line
    ```
    git clone https://github.com/guto-alves/fatecando-api.git
    ```
2) Inside Eclipse or STS
    ```
    File -> Import -> Maven -> Existing Maven project
    ```

    Then either build on the command line `./mvnw generate-resources` or using the Eclipse launcher (right click on project and `Run As -> Maven install`) to generate the css. Run the application main method by right clicking on it and choosing `Run As -> Java Application`.

## Looking for something in particular?

| Layer | Source |
|--|--|
| REST API controllers | [REST folder](/src/main/java/com/gutotech/fatecandoapi/rest) |
| Service | [Service folder](/src/main/java/com/gutotech/fatecandoapi/service) |
| Spring Data JPA | [JPA folder](/src/main/java/com/gutotech/fatecandoapi/repository) |
| Security | [Security folder](/src/main/java/com/gutotech/fatecandoapi/security) |
