#!/bin/bash

echo "Building accounts..."
cd accounts
./mvnw clean compile jib:dockerBuild
cd ..

echo "Building loans..."
cd loans
./mvnw clean compile jib:dockerBuild
cd ..

echo "Building cards..."
cd cards
./mvnw clean compile jib:dockerBuild
cd ..

echo "Building configserver..."
cd configserver
./mvnw clean compile jib:dockerBuild
cd ..

echo "All services built successfully!"