# README #

## Parking Ticket System
This project is build with JAX-RS showcasing a small RESTful Service for parking lot. It contains a DAO part. No othe database were integrated.

Author: Arghajit Bhattacharya

### Execute

```
mvn jetty:run
```
### Services

* POST	localhost:8080/parking-ticket-system/rest/parking/new
* GET	localhost:8080/parking-ticket-system/rest/parking
* GET	localhost:8080/parking-ticket-system/rest/parking/cost/{id}
* PUT	localhost:8080/parking-ticket-system/rest/parking/close/{id}

### Reporting

* GET localhost:8080/parking-ticket-system/rest/report

### Structure
```
parking-system-demo/
├── README.md
└── parking-ticket-system
    ├── pom.xml
    └── src
        └── main
            ├── java
            │   ├── com
            │   │   ├── App.java
            │   │   └── Report.java
            │   ├── dao
            │   │   ├── Cost.java
            │   │   ├── ParkingDAO.java
            │   │   └── UID.java
            │   └── model
            │       └── Parking.java
            └── webapp
                └── WEB-INF
                    └── web.xml

```


### Package ###

* Jetty
* Jersy Core
* Jersy-bundle


### IDE ###
* IntelliJ IDEA
