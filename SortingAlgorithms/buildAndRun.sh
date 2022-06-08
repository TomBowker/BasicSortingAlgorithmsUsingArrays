#!/bin/sh
mvn clean package && docker build -t com.tombowker/SortingAlgorithms .
docker rm -f SortingAlgorithms || true && docker run -d -p 8080:8080 -p 4848:4848 --name SortingAlgorithms com.tombowker/SortingAlgorithms 
