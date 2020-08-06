# Demo application

## Requirements ##

* Java 8
* [Gradle](https://gradle.org/)
* Docker(Optional)

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
* Start **Service**
    * IDE: run `com.example.demo.DemoApplication.java` class
    * Windows: `./gradlew bootRun`

## Docker run

* run `./gradlew bootJar`
* build image ` docker build .`
* run container `docker run -p 8080:8080 {Generated Id}`

