# Boogle Maps

This is a Mock Rest API service that simulates a Maps WebService where, given a latitude
longitude, will return a random address.

## Details

Classes and package

- __Address.java__: Declares a class that consists of address, city, state, zip.

- __MapsController__: Its a controller class for Boogle maps rest api.

- __MockAddressRepository.java__: Implements a mock repository for generating a random address. It basically gets a random address from the pre-defined list.

- __BoogleMapsApplication.java__: It is the main spring boot class that runs the appplication.

## How to run?

Via shell it can be started using

```
$ mvn clean package
```

```
$ java -jar target/boogle-maps-0.0.1-SNAPSHOT.jar
```

The service is available by default on port `9191`. You can check it on the 
command line by using

```
$ curl http://localhost:9191/maps\?lat\=20.0\&lon\=30.0
``` 

You can also import it as a Maven project on your preferred IDE and 
run the class `BoogleMapsApplication`.