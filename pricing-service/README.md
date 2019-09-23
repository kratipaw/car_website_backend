# Pricing Service

The Pricing Service is a micro-service that simulates a backend that would store and retrieve the price of a vehicle given a vehicle id as input. 


## Details

Packages and classes

- __RepositoryConfig.java__: Its a configuration file that reads JSON data from a file and populates the repository store.

- __Price.java__: It is the entity file that defines currency, amount and vehicle id.

- __PriceRepository.java__: Its the repository interface that extends CRUDRepository to implement basic CRUD functions on Price repository. The rest resource to expose is '/price'

- __PricingServiceApplciation.java__: It is the main class the starts our pricing-service micro-service that is registered to our Eureka server for discovery.

- __application.properties__: It defines the H2 database properties as well as the Eureka client properties as mentioned below:

```properties
spring.application.name=pricing-service
server.port=8082
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
eureka.client.service-url.default-zone=http://localhost:8761/eureka/
eureka.instance.prefer-ip-address=false

#To map to custom URL
spring.data.rest.basePath=/services
```

The last line the properties defines custom URL for pricing-service.

Once the application is running, you can check on : http://localhost:8082/services/price 


#### Run the application

To run this service you execute:

```
$ mvn clean package
```

```
$ java -jar target/pricing-service-0.0.1-SNAPSHOT.jar
```

It can also be imported in your IDE as a Maven project.
