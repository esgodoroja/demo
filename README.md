# Demo application

## Requirements ##

* Java 8
* [Gradle](https://gradle.org/)
* Docker

## Pre Configuration ##

* Add [Lombok Plugin](https://plugins.jetbrains.com/plugin/6317-lombok) 

## Generate Swagger Api/Models ##
```
    ./gradlew clean
    ./gradlew generateSwaggerCode

Note: After generation, please remove *ApiClient.java classes, reduce additional dependencies.
    - path: "${buildDir.path}/generated/src/main/java/com/example/demo/apis/"
```
 
## Development

* Start **Keycloak with Realm**
    * Docker/Podman: `podman run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin\
                       -v {projectDir.path}/resources/keycloack-realms/:/tmp/out/\
                        -e KEYCLOAK_IMPORT=/tmp/out/realm-example.json quay.io/keycloak/keycloak:11.0.0`
        * NOTE: `keycloack-realms` - better to put in shared(public) folder.
* Start **Service**
    * IDE: run `com.example.demo.DemoApplication.java` class
    * Windows: `./gradlew bootRun`

## Implemented endpoints
* **Add Pet**
    `POST: /pet`
* **Get Pet**
    `GET: /pet/{petId}`

## Docker run(optional)

* run `./gradlew bootJar`
* build image ` docker build .`
* run container `docker run -p 8080:8080 {Generated Id}`

##Examples:
* Auth:
    `curl -d '{"grant_type":"password", "username":"user", "password":"password", "client_id":"js-console"}' \
    -H "Content-Type: application/json" \
    -X POST http://localhost:8080/auth/realms/example/protocol/openid-connect/token`
* Resource:
    `curl -X GET 'http://localhost:8000/v2/pet/{petId}' \
     --header 'Authorization: bearer <ACCESS_TOKEN>'`

  
