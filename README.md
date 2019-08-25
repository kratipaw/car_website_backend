# Backend for a Car Sales company
The code for this project is present [here](https://github.com/kratipaw/car_website_backend).

Develop REST and GraphQL APIs, also focuses on how to secure, consume, document, and test those APIs and web services. The API documentation is developed using Swagger.

# Sub-projects inside the main project

## boogle-maps
This is a Mock that simulates a Maps WebService where, given a latitude longitude, will return a random address.

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

## eurekaServer

### EurekaServerApplication.java
### application.properties

## pricing-service
The Pricing Service is a REST WebService that simulates a backend that would store and retrieve the price of a vehicle given a vehicle id as input. We will be converting this into a microservice.

To run the service we execute:
```bash
$ mvn clean package

$ java -jar target/pricing-service-0.0.1-SNAPSHOT.jar
```

Again, this project too can be imported in as a Maven project.


## vehicles-api
A REST API to maintain vehicle data and to provide a complete view of vehicle details including price and address.

### Features
- REST API exploring the main HTTP verbs and features
- Hateoas
- Custom API Error handling using ControllerAdvice
- Swagger API docs
- HTTP WebClient
- MVC Test
- Automatic model mapping

To run the service execute:
```bash
$ mvn clean package

$ java -jar target/vehicles-api-0.0.1-SNAPSHOT.jar
```

The API docs are available at [LINK](http://localhost:8080/swagger-ui.html). Below is a snapshot of how <> service doc generated by Swagger looks.

# How to run the Project?
- clone the project
```bash
$ git clone https://github.com/kratipaw/car_website_backend.git
```

- navigate to the project directory and build individual components of the project
```bash
$ cd car_website_backend; 
```

# Demo
REPLACE: update with demo gif of the entire run of the project
