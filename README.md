# Search Engine Project

## Introduction
This repository contains code for a Search Engine application, along with instructions on how to build a Docker image and run tests using Selenium.

### For local run
## Prerequisites
- Java 8
- Apache Maven 3.9.6

## Project Structure
- `src/main/java`: Contains main Java files.
- `src/test/java`: Contains test files.
- `src/test/java/resources`: Contains resources files.
- `pom.xml`: Contains project configuration and dependencies.

## Dependencies
- **JUnit:** 3.8.1
- **Selenium:** 4.0.0
- **TestNG:** 7.3.0
- **JSON Simple:** 1.1.1
- **Gson:** 2.10.1

## Installation
1. Ensure you have Java 8 and Maven 3.9.6 installed.
2. Clone the repository: "https://github.com/suleymanatmaca/Search_Engine.git"
3. Navigate to the project directory: `cd SearchEngine`

## Running the Tests
To execute the tests, use the following command: 
```terminal
mvn test -Dsearch_param=selenium
```

This command runs Maven tests while passing the search_param property with the value selenium to your tests

### Building the Docker Image

To build the Docker image for the Search Engine application, follow these steps:

1. Ensure Docker is installed on your system.
2. Open a terminal or command prompt.
3. Navigate to the directory containing the Dockerfile for the Search Engine application.
4. Run the following command to build the Docker image:

```terminal
   docker build -t searchengine .
```

This command will build the Docker image named searchengine.

### Running Tests with "selenium" keyword

After building the Docker image, you can run tests for the Search Engine application using "selenium" with specific parameters. Use the following command:

```terminal
docker run -t searchengine clean test -Dsearch_param=selenium
```

This command executes the tests inside the Docker container created from the searchengine image. It uses the Maven command clean test and passes the search_param property with the value "selenium" to the tests.


Make sure the Docker container is properly configured to execute the tests based on your project setup.

## Docker image for Java automated UI tests.
Includes:
    JDK 8
    Maven 3.9.5
    Chrome latest
    ChromeDriver 120.0.6099.71
