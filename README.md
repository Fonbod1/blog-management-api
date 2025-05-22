# Blog-Management-Api
## This is a Spring Boot Rest API for creating articles within a blog.
It supports  Article creation, viewing, updating, and deletion.
#
# Features
#
## The blog management API has the following features

+ User Validation
+ Create Article
+ Get All Articles
+ Get Articles by ID
+ Update Article and Delete Article
+ Swagger API Documentation
#
# Tech Stack
## The following are the software that was used to create this API
+ Java 24
+ Spring Boot
+ Intellij
+ Postgresql

# 
# Setup Instructions
## git clone https://github.com/Fonbd1/blog-management-api
#
## Access API Docs
http://localhost:8084/swagger-ui.html
#
# HOW TO ACCESS THE API
## 
1 Clone the repository and open it from IntelliJ.
2 Launch PostgreSQL
3. Open Postman and run the different endpoints.

 Creating an Article

<img src="https://github.com/Fonbod1/blog-management-api/blob/master/blog-management/src/main/resources/Screenshot%20Blog%20Management/Screenshot%20Create%20Article.png?raw=true" alt="Create Article Screenshot" width="800"/>

 Updating an Article

<img src="https://github.com/Fonbod1/blog-management-api/blob/master/blog-management/src/main/resources/Screenshot%20Blog%20Management/Screenshot%20update%20Article.png?raw=true" alt= "Update an Article Screenshot" width="800"/>

 View all Articles

<img src="https://github.com/Fonbod1/blog-management-api/blob/master/blog-management/src/main/resources/Screenshot%20Blog%20Management/Screenshot%20Get%20All%20Article.png?raw=true" alt= "get all ArticleScreenshot" width="800"/>

  View a particular Article

 <img src ="https://github.com/Fonbod1/blog-management-api/blob/master/blog-management/src/main/resources/Screenshot%20Blog%20Management/Screenshot%20Get%20article%20ById.png?raw=true" alt = "View All Articles" width = "900">
 
  Delete an Article
 
  <img src ="https://github.com/Fonbod1/blog-management-api/blob/master/blog-management/src/main/resources/Screenshot%20Blog%20Management/Screenshot%20Delete%20Article.png?raw=true" alt = "Delete an Articles" width = "900">

 
#
# Article Management Endpoints
## Base URL: /api/articles  
#

|     Method    |     Endpoint  |    Description                                        |
| :-----------: | :-----------: | :---------------------------------------------------: |
|               |               |                                                       |
| Get           |   /all        |  View all Articles and                                   |
| Get           |  /{id}        |  Get Article by ID                                    |
| Put           | /{id}         | Update Article                                        |
| Delete        | /{id}         | Delete article                                        |
| POST          | /create       | Create a new Aricle                                   |
#
# Folder Structure

blog-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── blog/
│   │   │           └── management/
│   │   │               ├── BlogManagementApplication.java
│   │   │               ├── controller/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               └── service/
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── static/
│   │   │   └── templates/
│   └── test/
│       └── java/
│           └── com/
│               └── blog/
│                   └── management/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```
