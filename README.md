# BankingApp

Banking Application with Microservices

## Running with Docker

### Prerequisites

- Docker and Docker Compose
- Maven (or mvnw wrapper)

### Database Setup

The application uses MySQL databases for each microservice. Docker Compose automatically sets up the databases, but if you need to run them manually:

- Accounts DB: `docker run --name accountsdb -e MYSQL_DATABASE=accountsdb -e MYSQL_ROOT_PASSWORD=root -p 3307:3306 -d mysql`
- Loans DB: `docker run --name loansdb -e MYSQL_DATABASE=loansdb -e MYSQL_ROOT_PASSWORD=root -p 3308:3306 -d mysql`
- Cards DB: `docker run --name cardsdb -e MYSQL_DATABASE=cardsdb -e MYSQL_ROOT_PASSWORD=root -p 3309:3306 -d mysql`

All databases listen on their default port 3306 inside the container, but are exposed on different host ports (3307, 3308, 3309) to avoid conflicts.

### Automated Build and Run

1. Build all services and create Docker images:

   ```
   ./build-all.bat  # For Windows
   # or ./build-all.sh  # For Linux/Mac
   ```

2. Start services (default environment):

   ```
   docker-compose -f docker-compose/default/docker-compose.yml up -d
   ```

3. For production environment:

   ```
   docker-compose -f docker-compose/prod/docker-compose.yml up -d
   ```

4. For QA environment:
   ```
   docker-compose -f docker-compose/qa/docker-compose.yml up -d
   ```

### Manual Build (If script doesn't work)

For each service separately:

```
cd accounts
mvn clean compile jib:dockerBuild
cd ../loans
mvn clean compile jib:dockerBuild
cd ../cards
mvn clean compile jib:dockerBuild
cd ../configserver
mvn clean compile jib:dockerBuild
```

### Service Ports

- Configserver: 8071
- Accounts: 8080
- Loans: 8090
- Cards: 9000
- Accounts DB (MySQL): 3307
- Loans DB (MySQL): 3308
- Cards DB (MySQL): 3309

### Stopping

```
docker-compose -f docker-compose/default/docker-compose.yml down
```

## Step-by-Step Setup and Running

If the automated script doesn't work or you want to do it step by step:

### 1. Building All Services

Compile each microservice with Maven and create Docker images:

```
cd configserver
.\mvnw clean compile jib:dockerBuild
cd ..

cd accounts
.\mvnw clean compile jib:dockerBuild
cd ..

cd loans
.\mvnw clean compile jib:dockerBuild
cd ..

cd cards
.\mvnw clean compile jib:dockerBuild
cd ..
```

### 2. Verifying Images

Check that Docker images are created:

```
docker images
```

Look for images: `sadoyol/configserver:0.0.2-SNAPSHOT`, `sadoyol/accounts:0.0.2-SNAPSHOT`, etc.

### 3. Running Services

Start all services with Docker Compose:

```
docker-compose -f docker-compose/default/docker-compose.yml up -d
```

If previous containers exist, stop them first:

```
docker-compose -f docker-compose/default/docker-compose.yml down
docker stop accountsdb loansdb cardsdb  # If run manually
docker rm accountsdb loansdb cardsdb
```

### 4. Port and Health Check

Check running containers:

```
docker ps
```

Test that services are healthy:

- Configserver: `curl http://localhost:8071/actuator/health/readiness`
- Accounts: `curl http://localhost:8080/actuator/health`
- Loans: `curl http://localhost:8090/actuator/health`
- Cards: `curl http://localhost:9000/actuator/health`

### 5. Troubleshooting

- If port conflict: `netstat -ano | findstr :PORT` to check.
- For logs: `docker logs <container-name>`
- To restart: `docker-compose -f docker-compose/default/docker-compose.yml restart`
- Database connection issues: Ensure MySQL containers are healthy (`docker ps`) and credentials match (root/root).
