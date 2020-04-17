## Shop web service

### Stack

* Java 11

* Maven

* Docker

* Oracle Database Image: https://hub.docker.com/r/truevoly/oracle-12c

* Oracle driver: https://mvnrepository.com/artifact/com.oracle/ojdbc7/12.1.0.2

### Instructions

* install globally oracle driver with:
`mvn install:install-file -Dfile=./lib/ojdbc7.jar> -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar`

* start database with: `docker-compose up`

* create user and grant permissions like in `database.sql` 

* start application with maven / IntelliJ