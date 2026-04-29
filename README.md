# Overall Structure

- **controller** - Exposes REST endpoints and calls the service layer for underlying logic.
- **dto** - For validating request body.
- **model** - `EmployeeModel` is an implementation of the `Employee` interface.
- **repository** - Acts as a persistence layer using an in-memory HashMap.
- **security** - Added a basic authentication layer to protect the API.
- **service** - Contains the core logic of the API.

# Design Choices

- Enforcing email uniqueness
  - A HashSet is maintained alongside the main in-memory database (HashMap) to keep track of all the emails that are in use.
  - This prevents new employees from being created with a duplicate email.
  - Similar to a unique constraint in a relational database.
- Basic API key authentication
  - The problem statement expects a secure API and does not explicitly mention to not implement authentication.
  - Hence, I have implemented a basic security layer that uses an API Key in the request header.
- Strict validation on `CreateEmployeeRequest`
  - All fields are validated using annotations.
- The style guidelines have been followed using `./gradlew spotlessApply`.
- A postman collection is included in the root of the repository for quick testing.
