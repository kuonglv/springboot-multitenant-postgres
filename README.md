# Spring Boot multi-tenant demo

## Implementation of Schema per tenant
This project is a demo of multi tenant application, running on Spring Boot and Hibernate using Postgres database.
Each tenant's data is separated in different schemas.

### Postgres docker-compose
Find in resourses/docker/postgres-docker-compose.yml for quick start your database server to test the application.

`cd` to folder contains docker-compose.yml file then run: 

`docker-compose -f ./postgres-docker-compose.yml up`

Your postgres database server will be run on port `5432` as default.
The `pgAdmin` UI will be run on `5050` port. Open your browser and go to `http://localhost:5050` to access pgAdmin.

### Test api
1. Get data from a specific tenant

- URL: `http://localhost:8080/person`
- Method: `GET`
- Header: `X-Tenant-ID: ${tenant_id}`

2. Add a person

- URL: `http://localhost:8080/person`
- Method: `POST`
- Header: `X-Tenant-ID: ${tenant_id}`
- Body: `{
  "name": "CUONGLV"
  }`
## References
- https://spring.io/blog/2022/07/31/how-to-integrate-hibernates-multitenant-feature-with-spring-data-jpa-in-a-spring-boot-application
- https://github.com/lealceldeiro/springboot-multitenant-hibernate