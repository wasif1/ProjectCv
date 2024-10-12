
# Spring Boot Application (Microservices)

## Structure

```
spring-boot-microservices/
│
├── users/
│   ├── src/
│   ├── pom.xml (or build.gradle)
│   └── application.properties
│
├── experience/
│   ├── src/
│   ├── pom.xml (or build.gradle)
│   └── application.properties
│
├── projects/
│   ├── src/
│   ├── pom.xml (or build.gradle)
│   └── application.properties
│
├── reviews/
│   ├── src/
│   ├── pom.xml (or build.gradle)
│   └── application.properties
│
├── services/
│   ├── src/
│   ├── pom.xml (or build.gradle)
│   └── application.properties
│
├── skills/
│   ├── src/
│   ├── pom.xml (or build.gradle)
│   └── application.properties
│
```

[//]: # (## Explanation:)

[//]: # (* Each microservice has its own directory, with its source code inside the src/ folder.)

[//]: # (* Each microservice also has its own Dockerfile, build configuration &#40;Maven or Gradle&#41;, and application.properties &#40;for configuration&#41;.)

[//]: # (* Dockerfile for each microservice: Each microservice has its own Dockerfile tailored to its specific requirements.)

[//]: # ()
[//]: # (* docker-compose.yml: Use this file to define and run multiple containers for all your microservices. This will allow you to easily start all microservices with a single command.)

## Tools & Technology

![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)



<!-- GETTING STARTED -->
## Getting Started

Spring Boot application featuring full CRUD operations with seamless PostgreSQL integration. Postman-tested and ready to go! 🚀


### Prerequisites

List of software and tools which you need to get started

* Java JDK 17
* IntelliJ IDEA (Community Edition)
* Gradle
* Xcode Command Line Tools
  ```sh
  (for install) --> xcode-select --install
  (for verify) --> xcode-select -p 
  ```
* Homebrew
  ```sh
  (for install) --> /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
  (for verify) --> brew --version
  (if issue set PATH) -->  (echo; echo 'eval "$(/opt/homebrew/bin/brew shellenv)"') >> /Users/waxif/.zprofile eval "$(/opt/homebrew/bin/brew shellenv)"
  ```
* PostgreSQL
  ```sh
  (for install) --> brew install postgresql
  ```

* Start the PostgreSQL service:
   ```sh
   brew services start postgresql
   ```
* Verify that PostgreSQL is running by checking its status:
   ```sh
   brew services list
   ```

## Configure PostgreSQL

* Switch to the default postgres user:
   ```sh
   psql postgres
   ```

* Create a new databases for each module:
   ```sh
   CREATE DATABASE userdb;
   CREATE DATABASE projectsdb;
   CREATE DATABASE skillsdb;
   CREATE DATABASE reviewsdb;
   CREATE DATABASE experiencedb;
   CREATE DATABASE servicesdb;
   ```

* Create a new user:
   ```sh
   CREATE USER your_username WITH PASSWORD 'your_password';
   ```

* Grant all privileges on all the databases to the user:
   ```sh
   GRANT ALL PRIVILEGES ON DATABASE your_database_name TO your_username;
   ```

* To check if the spring boot application process is running or not you can use this command :
   ```sh
   lsof -i :8080
   ```

* To Kill the process you can use this command by passing process id which mention above screenshot as PID:
   ```sh
   kill -9 <PID>
   ```

  ### Now Goto Each module and run its main class to start the microservice:
   ```sh
   User module -> MainUser class
   Experience module -> MainExperience class
   Projects module -> MainProjects class
   Reviews module -> MainReviews class
   Services module -> MainServices class
   Skills module -> MainSkills class
   ```
  
* Once all the services are running. Then you can check the following api URL in Postman.
  ### Users Api (PORT 8081)
  ```sh
   GET -> http://localhost:8081/api/users/{user_id}
   POST -> http://localhost:8081/api/users
   
   Param -> Body -> raw -> JSON 
   
   { //Required fields
    "name": "Name",
    "email": "name@xyz.com"
   }
   ```

  ### Experience Api (PORT 8080)
  ```sh
   GET -> http://localhost:8080/api/experience/users/{user_id}
   POST -> http://localhost:8080/api/experience/users/{user_id}
   
   Param -> Body -> raw -> JSON 
   
   { //Required fields
    "employer": "test1",
    "start_date": "12/11/2023",
    "end_date": "12/11/2023"
   }
   ```

  ### Projects Api (PORT 8082)
    ```sh
     GET -> http://localhost:8082/api/projects
     POST -> http://localhost:8082/api/projects/users/{user_id}
     
     Param -> Body -> raw -> JSON 
     
     { //Required fields
      "name": "test",
      "start_date": "12/11/2023",
      "end_date": "12/11/2023"
     }
     ```

  ### Reviews Api (PORT 8083)
    ```sh
     GET -> http://localhost:8083/api/reviews
     POST -> http://localhost:8083/api/reviews/users/{user_id}
     
     Param -> Body -> raw -> JSON 
     
     { //Required fields
      "name": "test",
      "start_date": "12/11/2023",
      "end_date": "12/11/2023"
     }
     ```

  ### Services Api (PORT 8084)
    ```sh
     GET -> http://localhost:8084/api/services
     POST -> http://localhost:8084/api/services/users/{user_id}
     
     Param -> Body -> raw -> JSON 
     
     { //Required fields
      "name": "test",
      "start_date": "12/11/2023",
      "end_date": "12/11/2023"
     }
     ```

  ### Skills Api (PORT 8085)
    ```sh
     GET -> http://localhost:8085/api/skills
     POST -> http://localhost:8085/api/skills/users/{user_id}
     
     Param -> Body -> raw -> JSON 
     
     { //Required fields
      "name": "test",
      "start_date": "12/11/2023",
      "end_date": "12/11/2023"
     }
     ```

### NOTE: If you notice all microservices have different PORTS, so its very important to use the correct port to get the expected result.

* You can get the `POSTMAN` file from
  ```sh
  ProjectCv -> postman -> postman_collection.json
  ```

<!-- CONTACT -->
## Contact

Wasif Mujahid - [@LinkedIn](https://www.linkedin.com/in/wasif-mujahid-android-developer/) - waxif.1@gmail.com


<!-- Medium Articles -->
## Medium Articles
If you need more details, here are my few articles where i explained everything step by step. 
* [Spring Boot CRUD Operations Guide](https://medium.com/@wasifmujahid/spring-boot-to-make-crud-operations-part-1-eaab260c99f7)
* [PostgreSQL Integration with Spring Boot](https://medium.com/@wasifmujahid/spring-boot-crud-postgresql-part-2-9a3281275105)
* [API Testing with Postman](https://medium.com/@wasifmujahid/spring-boot-to-make-crud-operations-postman-testing-part-3-3ecd68721982)
* [Containerized with dockers](https://medium.com/@wasifmujahid/containerized-microservices-architecture-using-docker-4f032ed853a3)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



