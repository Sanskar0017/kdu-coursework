SmartHome Project
The SmartHome project is a Java-based mini-project developed on February 10th, aiming to provide functionalities for managing smart home systems. It offers features such as creating houses, adding rooms and devices, managing inventory items, user authentication, and more.

Table of Contents
Introduction
Technologies Used
Project Structure
Setup
Usage
Contributing
License
Introduction
The SmartHome project is designed to simplify the management of smart home systems by providing a centralized platform for users to control their devices, monitor their homes, and manage user access. It offers various functionalities to interact with houses, rooms, devices, inventory items, and users.

Technologies Used
The SmartHome project utilizes the following technologies:

Java
Spring Boot
Spring Security
Hibernate
MySQL
Lombok
JSON Web Tokens (JWT)
Maven
Project Structure
The SmartHome project follows a typical Java project structure:

css
Copy code
3-javaminiproject-feb10
│   .gitignore
│   mvnw
│   mvnw.cmd
│   pom.xml
│   README.md
│   smartHome.iml
├───.idea
├───src
│   ├───main
│   │   ├───java
│   │   │   └───smarthome
│   │   │       ├───config
│   │   │       ├───controllers
│   │   │       ├───dto
│   │   │       │   ├───request
│   │   │       │   └───response
│   │   │       ├───entity
│   │   │       ├───exception
│   │   │       ├───filter
│   │   │       ├───mapper
│   │   │       ├───models
│   │   │       ├───repository
│   │   │       └───services
│   │   └───resources
│   └───test
│       └───java
│           └───smarthome
│               └───configuration
│                   ├───controller
│                   ├───DTO
│                   └───utility
└───target
Setup
To set up the SmartHome project locally, follow these steps:

Clone the repository to your local machine.
Configure the database connection in the application.properties file.
Build the project using Maven: mvn clean install.
Run the application: mvn spring-boot:run.
Usage
Once the application is running, you can use the provided endpoints to interact with the system. These endpoints are typically mapped to controller classes and provide functionalities for managing houses, rooms, devices, inventory items, and users.

Contributing
Contributions to the SmartHome project are welcome! If you'd like to contribute, please follow these steps:

Fork the repository.
Create a new branch (git checkout -b feature/your-feature).
Make your changes.
Commit your changes (git commit -am 'Add new feature').
Push to the branch (git push origin feature/your-feature).
Create a new Pull Request.
License
The SmartHome project is licensed under the MIT License.

