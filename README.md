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
1 clone the repository and open it from intellij.
2 launch postgresql
3 open postman and run the different end points.
#
<img src="" alt=" Screenshot" width="800"/>
#
2. Sign in with a user email and password that you have created. NB: Use your own names to sign up.
  Once you sign in, a Token and a refresh token will be generated. Copy the refresh token and paste it
  Inside the token in the refresh endpoint
#
<img src="https://github.com/Fonbod1/User-Management-Api/blob/main/Endpoint%20photo/Signin.png?raw=true" alt="Signup Screenshot" width="1000"/>
#
3. Get Token: Paste the refresh token that was generated when you sign in, paste it within the "token": "paste here", this will generate a token once you click POST. Copy the token that has been generated to use it to authenticate and log in as a user or admin
#
<img src="https://github.com/Fonbod1/User-Management-Api/blob/main/Endpoint%20photo/Token.png?raw=true" alt="Signup Screenshot" width="1000"/>
#
4. AUTHENTICATION: At your user endpoint in Postman, select the authentication submenu, paste the token you copied from the sign-in, and click Get. This will authenticate you as a user or admin. From here, you can use the different user or admin endpoints within the API.
#
 <img src ="https://github.com/Fonbod1/User-Management-Api/blob/main/Endpoint%20photo/Authenticate%20User.png?raw=true" alt = "Authentication" width = "1000">
 #

# Authentication Endpoints
## Base URL: /api/v1/auth

|     Method    |     Endpoint  |    Description                                        |
| :-----------: | :-----------: | :---------------------------------------------------: |
| POST          |  /signup      |  Register a new user                                  |
| POST          |  /signin      |  Authenticate and get JWT                             |
| POST          |  /refresh     |  Refresh access token using refresh token             |

#
# User And Admin Management Endpoints
## Base URL: /api/v1/user  ,  /api/v1/admin
#

|     Method    |     Endpoint  |    Description                                        |
| :-----------: | :-----------: | :---------------------------------------------------: |
| Get           |   Base URL    |  Check user and admin login status                    |
| Get           |  /get/all     |  View all users and                                   |
| Get           |  /get/{id}    |  Get user by ID                                       |
| Put           | /update/{id}  | Update user                                           |
| Delete        | /delete/{id}  | Delete user                                           |
| POST          | /create       | Create a new user                                     |
#
# Folder Structure

src/
├── controller/
│   ├── AuthenticationController.java
│   └── UserController.java
├── dto/
│   ├── SignUpRequest.java
│   ├── SigninRequest.java
│   └── JwtAuthenticationResponse.java
├── model/
│   └── User.java
├── service/
│   └── AuthenticationService.java
│   └── UserService1.java

