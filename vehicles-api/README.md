# Vehicles API

A Spring Data Rest micro-service to maintain vehicle data and to provide a complete view of vehicle details including price and address.

## Classes and packages 

- __com.vehicles__: It is main package which contains main application file `VehiclesApiApplication` that runs the application.
- __api__: It contains the controller classes for car and its assembly as well as error handling
    - __ApiError.java__: Declares methods to return errors and other messages from the API.
    - __CarController.java__: Implements a REST-based controller for the Vehicles API.
    - __CarResourceAssembler.java__: Maps the CarController to the Car class using HATEOAS
    - __ErrorController.java__: Implements the Error controller related to any errors handled by the Vehicles API

- __client.maps__: It contains the classes related to store or interact with boogle-maps service for location related data of the vehicle
    -__Address.java__: Declares a class to store an address, city, state and zip code.
    - __MapsClient.java__: Implements a class to interface with the boogle-maps service for location data.
- __client.prices__: It contains the classes related to price and pricing-service of the vehicle.
    - __Price.java__: Represents the price of a given vehicle, including currency.
    - __PriceClient.java__: Implements a class to interface with the Pricing Client (pricing-service) for price data.
- __config__: It consists of config file `SwaggerConfig.java` that configures Swagger to expose various functions of the Vehicles API. On successful running of the application, Check out : __http://localhost:8080/swagger-ui.html__    
- __domain__: It consists of various data-models and its repositories required by vehicles-api.
- __domain.car__: It contains `Car` and `Details` data models and its repository `CarRepository`.
- __domain.manufacturer__: It contains `Manufacturer` data model and its repository `ManufacturerRepository`.
- __service__: 
    - __CarNotFoundException.java__: A subclass of RunTimeException which defines Car not found exception
    - __CarService.java__: Implements the car service to create, get, update or delete information about vehicles, as well as gather related location and price data.
- __resources\application.properties__: Defines and location and pricing services URLS as well as makes vehicles-api discoverable by Eureka server

```properties
pricing.endpoint=http://localhost:8082
maps.endpoint=http://localhost:9191

#Eureka
spring.application.name=vehicles-api
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
instance.preferIpAddress=true
```


## Run the application

To properly run this application we need to first start the `boggle-maps` API and the `pricing-service` API. 

```
$ mvn clean package
```

```
$ java -jar target/vehicles-api-0.0.1-SNAPSHOT.jar
```

Alternatively, we can import it our IDE and run the main class `VehiclesApiApplicaion`.

## Using Swagger to test the application

Swagger UI: http://localhost:8080/swagger-ui.html

### Create a Vehicle

`POST` `/cars`
```json
{
   "condition":"USED",
   "details":{
      "body":"sedan",
      "model":"Impala",
      "manufacturer":{
         "code":101,
         "name":"Chevrolet"
      },
      "numberOfDoors":4,
      "fuelType":"Gasoline",
      "engine":"3.6L V6",
      "mileage":32280,
      "modelYear":2018,
      "productionYear":2018,
      "externalColor":"white"
   },
   "location":{
      "lat":40.73061,
      "lon":-73.935242
   }
}
```

### Retrieve a Vehicle

`GET` `/cars/{id}`

This feature retrieves the Vehicle data from the database
and access the Pricing Service and Boogle Maps to enrich 
the Vehicle information to be presented

### Update a Vehicle

`PUT` `/cars/{id}`

```json
{
   "condition":"USED",
   "details":{
      "body":"sedan",
      "model":"Impala",
      "manufacturer":{
         "code":101,
         "name":"Chevrolet"
      },
      "numberOfDoors":4,
      "fuelType":"Gasoline",
      "engine":"3.6L V6",
      "mileage":32280,
      "modelYear":2018,
      "productionYear":2018,
      "externalColor":"white"
   },
   "location":{
      "lat":40.73061,
      "lon":-73.935242
   }
}
```

### Delete a Vehicle

`DELETE` `/cars/{id}`
