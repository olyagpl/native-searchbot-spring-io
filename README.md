# Native Spring Boot Search Bot

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

To run on a JVM: 
```
./mvnw spring-boot:run
```

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
./mvnw spring-boot:build-image -Pnative
```

Then, you can run the app like any other container:

```
docker run --rm -p 8080:8080 searchbot:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

To create the executable, run the following goal:

```
./mvnw native:compile -Pnative
```

Then, you can run the app as follows:
```
./target/searchbot
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
./mvnw test -PnativeTest
```