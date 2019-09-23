# Backend for a Car Sales company
The code for this project is present [here](https://github.com/kratipaw/car_website_backend).

Develop REST and GraphQL APIs, also focuses on how to secure, consume, document, and test those APIs and web services. The API documentation is developed using Swagger.

## Overview

The Car Backend consists of four modules (or sub-projects), namely:

If you want to read about these modules in detail, click on the links below are you will be redirected to the README page for each one of them. Instead, if you would like to see the application in action first (highly recommended) and later come back to know the details, keep reading this README.

1. __[boogle-maps](https://kratipaw.github.io/car_website_backend/boogle-maps/)__: This is a Mock SPI that simulates a Maps    WebService where, given a latitude and longitude, it  will return a random address.

2. __[eurekaServer](https://kratipaw.github.io/car_website_backend/eurekaServer/)__: Its a simple eureka server application that holds all information about the client-service applications. All micro-services will register to this eureka server and all client application will register to this server so that it knows what client applications are on which port and IP address

3. __[pricing-service](https://kratipaw.github.io/car_website_backend/pricing-service/)__: Its a micro-service registered to the Eureka server that simulates a backend that would store and retrieve the price of a vehicle given a vehicle id as input.

4. __[vehicles-api](https://github.com/kratipaw/car_website_backend/vehicles-api)__: Its a micro-service registered to the Eureka server. It maintains the vehicle data and provides a complete view of vehicle details including price and address. The API documentation is done for this service.

 
## Run above modules simultaneously:

### Boogle Maps
Below are the commands to build and run this project.

```bash
$ mvn clean package

$ java -jar target/boogle-maps-0.0.1-SNAPSHOT.jar
```

To verify if the service is up, you can check the below URL.
```bash
$ curl http://localhost:9191/maps\?lat\=20.0\&lon\=30.0
```

Alternately, we can also import this project as a Maven project and run the main class i.e. __BoogleMapsApplication__.

With the maps mock set up let's move on to the other important components of the project.

### Eureka Server

Below are the commands to build and run this project.

```bash
$ mvn clean package

$ java -jar target/eurekaServer-0.0.1-SNAPSHOT.jar
```

You can also import it as a Maven project on your preferred IDE and run the class `EurekaServerApplication`.

### Pricing Service
To run the service we execute:

```bash
$ mvn clean package

$ java -jar target/pricing-service-0.0.1-SNAPSHOT.jar
```

Again, this project too can be imported in as a Maven project.

### Vehicles API

To properly run this application we need to first start the `boggle-maps` API and the `pricing-service` API. 

```bash
$ mvn clean package

$ java -jar target/vehicles-api-0.0.1-SNAPSHOT.jar
```

Alternatively, we can import it our IDE and run the main class `VehiclesApiApplicaion`.
