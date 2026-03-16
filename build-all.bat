@echo off
echo Building accounts...
cd accounts
call mvn clean compile jib:dockerBuild
cd ..

echo Building loans...
cd loans
call mvn clean compile jib:dockerBuild
cd ..

echo Building cards...
cd cards
call mvn clean compile jib:dockerBuild
cd ..

echo Building configserver...
cd configserver
call mvn clean compile jib:dockerBuild
cd ..

echo All services built successfully!