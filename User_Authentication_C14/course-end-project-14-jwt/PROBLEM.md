### Project - "User Authentication Service with Spring Boot and MySQL"

This project focuses on creating a User Authentication Service using Spring Boot, MySQL database, JWT and Spring Data JPA. Learners will develop a RESTful API with CRUD operations for User Authentication. The project covers the implementation of a layered architecture including controllers, services, and repositories, emphasizing best practices in Spring Boot application develop


### Step 1: Set up your Spring Boot project
Create a new Spring Boot project: Use Spring Initializr to create a new Spring Boot project. Include all the required dependencies for developing the solution and also for writing the test cases.
Configure MySQL database: In the application.properties or application.yml file, configure your MySQL database connection properties such as URL, username, and password. Also, set the Hibernate property spring.jpa.hibernate.ddl-auto=update to automatically create/update the database schema.

### Step 2: Define Entity Class
Create an Entity class: User and annotate it with @Entity annotations to map it to a database table. Include fields representing the attributes of the entity (userId, username, password, address) along with appropriate annotations (@Id, @GeneratedValue, etc.).Create the Constructors and generate the getter and setters for all the given attributes.

### Step 3: Create the User-defined Exception classes
Define a UserAlreadyExistException class that extends the Exception class and is annotated with @ResponseStatus. This exception is specifically designed to handle cases where a user already exists within the system, and it should return an HTTP status code of 409 (CONFLICT) along with the reason "User already exists" when thrown.
Create a UserNotFoundException class that extends the Exception class and is annotated with @ResponseStatus. This exception is intended to handle situations where a user is not found within the system. When this exception is thrown, it should result in an HTTP status code of 404 (NOT_FOUND) with the reason "User Not Found" as part of the response.

### Step 4: Create Repository Interface
Define Repository interface: Create a repository interface (e.g., UserRepository) that extends JpaRepository provided by Spring Data JPA. This interface inherits basic CRUD operations like save, findById, findAll, deleteById. Without needing to write their implementations.
Implement custom methods: Additionally, implement the given below user-defined/custom methods.
Fine User by Username and Password - This method will return the user with given username and password.

### Step 5: Implement Service Layer
Develop a UserService implementation that interacts with a UserRepository to manage user data in a system. The UserService should provide functionality to:
Save a new user, throwing a UserAlreadyExistException if a user with the same ID already exists.
Find a user by their username and password, throwing a UserNotFoundException if the user does not exist.
Retrieve all users from the system.
Delete a user by their user ID, throwing a UserNotFoundException if the user with the given ID does not exist

Inside the service package you also need to generate the JWT token:
Design a SecurityTokenGenerator interface responsible for generating security tokens for user authentication and authorization purposes. The interface should define a method:
generateToken(User user): This method takes a User object as input and returns a Map<String, String> containing the generated security token required for authentication.

Implement a JwtSecurityTokenGeneratorImpl class that serves as an implementation of the SecurityTokenGenerator interface. This class is responsible for generating JWT (JSON Web Token) security tokens for user authentication and authorization within a system.
The class should contain a method:
generateToken(User user): This method takes a User object as input and returns a Map<String, String> containing a JWT token along with a success message indicating that the user has successfully logged in. The JWT token is generated using the user's username as the subject, the current date as the issued date, and a secret key for signing using the HS256 algorithm.

### Step- 6 Implement the Filter Layer

Develop a JwtFilter class that extends GenericFilterBean and is responsible for handling JWT (JSON Web Token) authentication in a web application. The JwtFilter should perform the following actions in its doFilter method:

Extract the JWT token from the Authorization header in the incoming HTTP request.
If the token is missing or not in the correct format (does not start with "Bearer"), set the HTTP response status to 401 (UNAUTHORIZED) and return a message indicating a missing or invalid token.
If the token is present and valid, extract the username from the token using a specified secret key for verification.
Set the username in the HttpServletRequest attribute for further processing in subsequent filters or controllers.
Proceed with the filter chain to allow the request to pass through additional filters and reach the controller for handling the request.

### Step 7: Build Controller Layer
Create Controller class: Develop a controller class (e.g., UserController) annotated with @RestController and @RequestMapping to define the base URL for your API endpoints
Define endpoint mappings: Define methods in the controller class to handle HTTP requests for various operations (e.g., loginUser, saveUser, getAllUsers, deleteUser). Use appropriate annotations (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping) to map these methods to HTTP verbs and request paths.

### Step 8: Run and test the end-points in PostMan
Run the application: Use your IDE or command line to run the Spring Boot application.
Test API endpoints: Use Postman to send HTTP requests to your API endpoints and verify the functionality. Test CRUD operations (GET, POST, PUT, DELETE) as well as any custom methods you implemented in the service layer.

### Step 9: Implement the Junit Test cases.
Develop test case classes for the Repository, Service, and Controller layers, incorporating necessary annotations and utilizing tear-down (tear) and set-up (setUp) methods.