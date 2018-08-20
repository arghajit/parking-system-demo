# README #

## Parking Ticket System

Author: Arghajit Bhattacharya

### Execute

```
#!unix

mvn jetty:run
```
### Services

* POST	localhost:8080/parking-ticket-system/rest/parking/new
* GET	localhost:8080/parking-ticket-system/rest/parking
* GET	localhost:8080/parking-ticket-system/rest/parking/cost/{id}
* PUT	localhost:8080/parking-ticket-system/rest/parking/close/{id}

### Reporting

* GET localhost:8080/parking-ticket-system/rest/report

### Package ###

* Jetty
* Jersy Core
* Jersy-bundle


### IDE ###
* IntelliJ IDEA