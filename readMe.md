SpringBoot Application using JPA and Hibernate ORM tool.
========================================================

Application to perform crud operations using Inventory items as a source/destination.

H2
--
JPA is the Java specification for managing relational databases. Hibernate is the chosen JPA implementation here. Hibernate is also
the default JPA implementation. Read further on [JPA](https://www.javatpoint.com/spring-boot-jpa).

[Click here](http://localhost:8080/h2-console) to open H2 UI.
Use the right JDBC URL mentioned in application.properties

Implementation
--------------
- Implementation reference of [Spring Boot + Hibernate + JPA](https://www.springboottutorial.com/hibernate-jpa-tutorial-with-spring-boot-starter-jpa)


- Mapping of entities to POJO is done using [Jackson ObjectMapper](https://www.tutorialspoint.com/jackson/jackson_objectmapper.htm)


- (Whitelabel Error Page Handling)[https://www.baeldung.com/spring-boot-custom-error-page]


- [Actuators](https://www.tutorialspoint.com/spring_boot/spring_boot_actuator.htm) - used for monitoring application. 
Path for actuator - http://localhost:9000/actuator. This lists actuator endpoints available.


- Swagger2 is an open source project used to generate the REST API documents for RESTful web services. Swagger2 is enabled on the boot up class and respective dependencies are added. View the swagger documentation at http://localhost:8080/swagger-ui.html



Interesting reads
-----------------
[Interface 'extends' interface](https://www.interviewsansar.com/interface-extends-interface-in-java/) Where is this used in this project ? ;)