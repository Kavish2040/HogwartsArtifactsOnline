# Hogwarts Artifacts Online - Spring Boot Application 

[![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/Washingtonwei/hogwarts-artifacts-online/maven-build.yml?logo=apachemaven&label=Maven%20Build)](https://github.com/Washingtonwei/hogwarts-artifacts-online/actions/workflows/maven-build.yml) [![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/Washingtonwei/hogwarts-artifacts-online/azure-webapps-deploy.yml?logo=microsoftazure&label=Azure%20Deployment)](https://github.com/Washingtonwei/hogwarts-artifacts-online/actions/workflows/azure-webapps-deploy.yml) ![Dynamic XML Badge](https://img.shields.io/badge/dynamic/xml?url=https%3A%2F%2Fraw.githubusercontent.com%2FWashingtonwei%2Fhogwarts-artifacts-online%2Fmain%2Fpom.xml&query=%2F*%5Blocal-name()%3D'project'%5D%2F*%5Blocal-name()%3D'properties'%5D%2F*%5Blocal-name()%3D'java.version'%5D&label=Java) ![Dynamic XML Badge](https://img.shields.io/badge/dynamic/xml?url=https%3A%2F%2Fraw.githubusercontent.com%2FWashingtonwei%2Fhogwarts-artifacts-online%2Fmain%2Fpom.xml&query=%2F*%5Blocal-name()%3D'project'%5D%2F*%5Blocal-name()%3D'parent'%5D%2F*%5Blocal-name()%3D'version'%5D&label=Spring%20Boot) ![Dynamic XML Badge](https://img.shields.io/badge/dynamic/xml?url=https%3A%2F%2Fraw.githubusercontent.com%2FWashingtonwei%2Fhogwarts-artifacts-online%2Fmain%2Fpom.xml&query=%2F*%5Blocal-name()%3D'project'%5D%2F*%5Blocal-name()%3D'properties'%5D%2F*%5Blocal-name()%3D'spring-cloud-azure.version'%5D&label=Spring%20Cloud%20Azure)

## What is Hogwarts Artifacts Online 🧙‍♀️?

Welcome to *Hogwarts Artifacts Online*, a sample back-end application designed to demonstrate typical use cases and best practices in Spring Boot development. I wrote this sample application as part of "**CITE 30363 -  Web Technologies**" class by **Dr. Bingyang Wei**.

Throughout the course, *Hogwarts Artifacts Online* serves as a running example and is developed progressively. That is, each episode introduces new Spring Boot features that adds functionality or improvements to this project. This approach helps you see how different concepts fit together in a practical context.

## Topics Covered

- **Dependency Injection** and the use of Spring Framework's core container.
- Building the web layer with **Spring MVC (Model-View-Controller)**.
- Data persistence in relational databases using **Spring Data JPA (Jakarta Persistence API)**.
- User authentication and authorization with **Spring Security** and **JWT (JSON Web Tokens)**.
- Deploying a Spring Boot application to a cloud platform with **Spring Cloud Azure**.
- Monitoring a running Spring Boot application in the production with **Spring Boot Actuator**.
- Making requests to OpenAI API with **RestClient**.
- Paging and sorting.
- Writing dynamic queries with Spring Data JPA Specifications.
- And more.

Additionally, this course emphasizes good software engineering practices, such as:

- Defining software requirements with **User Stories**.
- Version control and project planning using **Git and GitHub**.
- The **API-First Approach** in designing effective REST APIs.
- **Test-Driven Development (TDD)**: writing tests first, then coding to pass the tests, and refactoring.
- **Object-Oriented Design** with UML.
- **CI/CD (Continuous Integration and Continuous Delivery)** with GitHub Actions.


## Run Hogwarts Artifacts Online Locally

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/vishalseelam/hogwarts-artifacts-online-main.git
   ```

2. **Navigate to the project directory:**

   ```bash
   cd hogwarts-artifacts-online
   ```

3. **Run the application:**

Since *Hogwarts Artifacts Online* is a Spring Boot application built using Maven, you can  run it from Maven directly using the Spring Boot Maven plugin:

   ```bash
   ./mvnw spring-boot:run
   ```

Or on Windows:

   ```bash
   .\mvnw.cmd spring-boot:run
   ```

## Building a Container

There is a `Dockerfile` in this project. You can build a container image (if you have a docker daemon):

```bash
docker build .
```

## Database Configuration

In its default configuration, *Hogwarts Artifacts Online* uses an in-memory database (H2) which
gets populated at startup with data. The H2 console is available at <http://localhost/h2-console>,
and it is possible to inspect the content of the database using the `jdbc:h2:mem:hogwarts` URL.

I have defined a class [`edu.tcu.cs.hogwartsartifactsonline.system.DBDataInitializer`](https://github.com/Washingtonwei/hogwarts-artifacts-online/blob/main/src/main/java/edu/tcu/cs/hogwartsartifactsonline/system/DBDataInitializer.java) to populate the H2 database at startup.

## Accessing the API Endpoints

[![Static Badge](https://img.shields.io/badge/Postman-white?logo=postman&logoColor=red)](https://www.postman.com/bingyang-wei/workspace/youtube-workspace/collection/7025773-2279d7bf-70f4-4825-9a74-8f46a6b6efaa?action=share&creator=7025773) [<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://god.gw.postman.com/run-collection/7025773-2279d7bf-70f4-4825-9a74-8f46a6b6efaa?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D7025773-2279d7bf-70f4-4825-9a74-8f46a6b6efaa%26entityType%3Dcollection%26workspaceId%3D4369fd7f-4a25-4f67-bc60-4acc92fc0c9e)

