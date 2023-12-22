Feature: Create User

	Scenario: create new user
		Given the client sends a POST request to "/api/person"
		And the request body is:
		"""
		{
			"firstName":"testCucu",
		}"""
		when the request is executed
		Then the response status code should be 200
		And the response body not null