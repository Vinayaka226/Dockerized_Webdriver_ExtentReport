```bash
├── Dockerized_Webdriver_ExtentReport
│   ├── src
│   │   ├── test
│   ├──     ├── java
│   │       │    ├── driverFactory
│   │       │    ├── pageObjects
│   │       │    │   ├── automationExercise
│   │       │    │        ├── agent
│   │       │    │        ├── records
│   │       │    │        ├── wiring
│   │       │    ├── tests
│   │       │    ├── util
│   │       │        ├── Listeners
│   │       ├── resources
│   │       │   ├── test-data
│   │       │   ├── test-suites
│   ├── pom.xml
│   ├── Dockerfile
│   ├── docker-compose.yaml
│   ├── grid.yaml
│   ├── runner.sh
│   ├── SampleExtent.html
```

# Package 

```
mvn clean package -DskipTests
```
### Run after packaging

Chrome Browser
```
java -Dbrowser=chrome -cp 'libs/*' org.testng.TestNG test-suites/functional.xml
```
Firefox Browser
```
java -Dbrowser=firefox -cp 'libs/*' org.testng.TestNG test-suites/functional.xml
```

# Build Docker Image

```
docker build -t=<username>/selenium .
```

# Bring Up Grid

Bring up grid with scalable nodes
```
docker-compose -f grid.yaml up --scale firefox=3 -d
```

# Run test

Run with needed browser and threads
```
BROWSER=firefox THREAD_COUNT=3 docker-compose up
```

# Sample Report
[Example ExtentReport] (/SampleExtent.html)