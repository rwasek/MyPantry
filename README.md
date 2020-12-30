## MyPantry

### Full-Stack Java Spring Boot/Angular Web Application for keeping track of your groceries

## Overview

MyPantry is an easy to use application to keep track of groceries in your fridge and pantry, particularly for those with roommates and a full fridge, so nothing is left to go to waste!

I developed the application from scratch, using a MySQL Database, Java 8 and Spring Boot, Spring JPA, REST API, with an Angular SPA front-end design.  My goal was to get more
familiar with Angular Material UI, so the majority of the frontend utilizes Material components and very limited CSS outside of the homepage.

Spring Security was implemented with BCrypt for generating hashed passwords, and Users can register accounts to sign in and access their own individual table of Groceries.  A user can add a new grocery, edit existing ones,
and delete them when they are used up.

## Demo

Hosted to Tomcat via AWS EC2 to Demo: http://3.132.231.203:8080/MyPantry/

Demo username and password: mypantry


## API Endpoints

|Returns   | Verb        | URI    | Description |
|----------|-------------|--------|-------------|
| User | POST | /register | Register User |
| User | GET | /authenticate | Return logged in User |
| Grocery | GET | api/groceries/{groceryId} | Retrieves an individual Grocery |
| List&lt;Groceries&gt; | GET  | api/groceries | Retrieve List of Groceries for logged in User |
| Grocery | POST | api/groceries | Creates a new Grocery |
| Grocery | PUT | api/groceries/{groceryId} | Updates an existing Grocery |
| Void | DELETE | api/groceries/{groceryId} | Deletes an existing Grocery |


## Technologies Used
* MySQL, MySQL Workbench
* Java/Hibernate
* Spring Boot
* Spring Data JPA
* Angular
* TypeScript
* HTML/CSS
* Angular Bootstrap
* Angular Material UI
* Gradle
* Git/Github
* Postman
* MAMP/Apache Tomcat
* AWS/EC2
* Visual Studio Code
