# ApolloApp - courses manage app

Application to manage conduct of courses.

## Table of content
* [General info](#general-info)
* [Main features](#main-features)
* [Solutions](#solutions)
* [Technologies](#technologies)
* [Setup](#setup)
* [Agreements](#agreements)

-------------------------------------------

## General info
Project aims to develop system that supports conduct of courses for admin, instructor and students.
Application provides different functionalities depending on granted permissions for specific type of user.

-----------------------------------
### Main features

**ADMIN PANEL** (superior access)
* ...
* ...
* ...

**STUDENT PANEL** (limited access)
* ...
* ...
* ...

**INSTRUCTOR PANEL** (limited access)
* ...
* ...
* ...

---------------------------------------

### Solutions provided in the project
******* TU MOŻEMY ZAMIEŚCIĆ PRZYKŁADOWE FRAGMENTY KODU ILUSTRUJĄCE KONKRETNE ROZWIĄZANIA


----------------------------------
## Technologies
* HTML
* CSS
* JDBC
* SpringBoot

### Tools
* InteliiJ Ultimate
* PostMan

----------------------------------
## Setup
### Data Base
- data base type: h2
- data base name: apollodb
- data base username: apollo
- password: apollo

- login credentials: user name / user type / user password: ---> użytkownik testowy?
    * ewa / admin / admin (? dodajemy? )

Data base URL: 

    https://localhost:8080/h2-console 

### GitHub
- branches: feature - PR - master 
- branch's naming pattern: feature-taskName-....
- project name: ApolloApp
- repo link: https://github.com/katlazar/ApolloApp
- project task's link: https://github.com/users/katlazar/projects/2

----------------------------------
## Agreements
.....





NA PRZYSZŁOŚĆ PRZY ZMIANIE NA MySQL
### Data base

    CREATE DATABASE apollodb;
    CREATE USER 'apollo' identified by 'apollo';
    GRANT ALL ON apollodb.* to apollo;
    FLUSH PRIVILEGES;


