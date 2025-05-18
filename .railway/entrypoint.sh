#!/bin/bash
chmod +x ./mvnw
./mvnw package
java -jar target/*.jar