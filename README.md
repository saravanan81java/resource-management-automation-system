# resource-management-automation-system
Resource Management Automation System

# Set Up the Project
	.	Initialize Spring Boot Projects: Use Spring Initializr to generate projects for each microservice.
		.	Resource Service: Handles inventory and resource tracking.
		.	User Service: Manages users (staff, volunteers, donors).
		.	Notification Service: Sends alerts for low stock, new donations, etc.
		.	API Gateway: Serves as a single entry point.
		.	Config Server: Manages centralized configurations.
		.	Service Registry (Eureka): Enables service discovery.
	.	Include dependencies:
		.	Spring Web: For building REST APIs.
		.	Spring Data JPA: For database operations.
		.	Spring Cloud: For microservice orchestration.
		.	Spring Boot Actuator: For monitoring.
		.	H2: As the database.
		.	Spring Security: For authentication/authorization.


#  Base URL
	Ensure your Spring Boot application is running locally or on a specific server. For example:
	Base URL: http://localhost:8080/resources
#  Endpoints Configuration
	A. Get All Resources
		. Method: GET
		. URL: http://localhost:8080/resources
		. Headers: None (or add Content-Type: application/json if required)
		. Body: Not applicable
		. Expected Response:
			[
				{
					"id": 1,
					"name": "Food Supplies",
					"quantity": 100,
					"category": "Food",
					"createdAt": "2025-01-01T12:00:00",
					"updatedAt": "2025-01-10T14:00:00"
				}
			]
	B. Get Resource by ID
		. Method: GET
		. URL: http://localhost:8080/resources/{id} (e.g., http://localhost:8080/resources/1)
		. Headers: None
		. Body: Not applicable
		. Expected Response:
			{
				"id": 1,
				"name": "Food Supplies",
				"quantity": 100,
				"category": "Food",
				"createdAt": "2025-01-01T12:00:00",
				"updatedAt": "2025-01-10T14:00:00"
			}
	C. Add a New Resource
		. Method: POST
		. URL: http://localhost:8080/resources
		. Headers:
		. Content-Type: application/json
		. Body (Raw, JSON):
			{
				"name": "Medical Kits",
				"quantity": 25,
				"category": "Medical"
			}
		. Expected Response:
			{
				"id": 2,
				"name": "Medical Kits",
				"quantity": 25,
				"category": "Medical",
				"createdAt": "2025-01-25T10:00:00",
				"updatedAt": "2025-01-25T10:00:00"
			}
	D. Update an Existing Resource
		. Method: PUT
		. URL: http://localhost:8080/resources/{id} (e.g., http://localhost:8080/resources/2)
		. Headers:
		. Content-Type: application/json
		. Body (Raw, JSON): 
			{
				"name": "Medical Kits",
				"quantity": 30,
				"category": "Medical"
			}
		.Expected Response:
			{
				"id": 2,
				"name": "Medical Kits",
				"quantity": 30,
				"category": "Medical",
				"createdAt": "2025-01-25T10:00:00",
				"updatedAt": "2025-01-25T12:00:00"
			}
	E. Delete a Resource
		. Method: DELETE
		. URL: http://localhost:8080/resources/{id} (e.g., http://localhost:8080/resources/2)
		. Headers: None
		. Body: Not applicable
		Expected Response: HTTP Status 204 No Content
	F. Search Resource by Name
		. Method: GET
		. URL: http://localhost:8080/resources/search?name={name} (e.g., http://localhost:8080/resources/search?name=Medical Kits)
		. Headers: None
		. Body: Not applicable
		. Expected Response:
		{
			"id": 2,
			"name": "Medical Kits",
			"quantity": 30,
			"category": "Medical",
			"createdAt": "2025-01-25T10:00:00",
			"updatedAt": "2025-01-25T12:00:00"
		}
	G. Filter Resources by Category
		. Method: GET
		. URL: http://localhost:8080/resources/filter?category={category} (e.g., http://localhost:8080/resources/filter?category=Medical)
		. Headers: None
		. Body: Not applicable
		. Expected Response:
		[
			{
				"id": 2,
				"name": "Medical Kits",
				"quantity": 30,
				"category": "Medical",
				"createdAt": "2025-01-25T10:00:00",
				"updatedAt": "2025-01-25T12:00:00"
			}
		]

#  Save Collection in Postman
	1.Create a new collection in Postman called Resource Management API.
	2.Add each endpoint as a request under this collection.
	3.Set up environments in Postman (e.g., Localhost) to easily switch between base URLs.

	POST /resources
	{
		"name": "Rice",
		"category": "Food",
		"quantity": 50,
		"threshold": 10
	}


# User API Endpoints
	Use Postman or Swagger UI to test the APIs:

	. GET /users - Get all users.
	. POST /users - Add a new user.
		{
			"username": "john_doe",
			"password": "password123",
			"email": "john.doe@example.com",
			"role": "ADMIN"
		}
	. PUT /users/{id} - Update a user.
	. DELETE /users/{id} - Delete a user.
	. GET /users/search?username=john_doe - Find a user by username.