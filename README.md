# Spring Boot JPA relationships demo

### Spring boot concepts in this project
- In memory h2 database
- Relationships between entities
    - OneToOne : 
    - ManyToOne
    -ManyToMany
    -JoinTable   
- Entity repositories
- Database initialization
    - DDL -> Data Definition Language
    - DML -> Data Manipulation Language
    - property: spring.jpa.hibernate.ddl-auto
    - Spring datasource initializer: data.sql file
    - bootstrapper class with recipe data
 - Recipe display with thymeleaf template
 
 - Project Lombok branch
 - Added Bootstrap css
 - Spring Boot Test
    - J-Unit tests
    - MockMVC tests
    - Integration tests
    - maven failsafe plugin configuration to run integration tests
    
 - Created added the command classes and tests for command classes
 - CRUD operations: POST recipe, update recipe, delete recipe
 - View ingredients
 - Save and display images from DB