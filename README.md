# Travelab 
[![Build Status](https://travis-ci.org/notjuanortiz/travelab.svg?branch=master)](https://travis-ci.org/notjuanortiz/travelab)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/b7866157e30248428541817fee0f7868)](https://www.codacy.com/manual/notjuanortiz/travelab?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=notjuanortiz/travelab&amp;utm_campaign=Badge_Grade)

## Purpose 
This project was to created to showcase mastery of Java, and the the Spring Framework.
Travelab is a traveling platform built with a microservices architecture to emphasis horizontal scalability and resilience.

## Modules

### Customer

- [*]  `travelab-customer-flight-checkin` view/add their check-in status including number of bags being checked in
- [*]  `travelab-customer-flight-reservation` add/update/delete existing flight reservations
- [ ]  `travelab-customer-cart` shopping cart functionality, including checkout.
- [ ]  `travelab-customer-payment` payment integration, view payment history.
 
### Vendors
- [ ]  `travelab-vendor-flight-management` add/update/delete available flights
- [ ]  `travelab-vendor-discounts` create/read/update/delete discounts for available flights

### Both
- [ ]  `travelab-authorization` intercepts and processes each customer/vendor request   
- [ ]  `travelab-authentication` - user account authentication for both customers and vendors.
- [ ]  `travelab-flight-search` - search available flights

## Built With

* [Spring Framework](https://spring.io/projects) - The web framework used
* [Gradle](https://gradle.org/) - Dependency and Build Management
* [MySQL](https://www.mysql.com/) - Data storage and querying
* [Swagger](https://swagger.io/) - API Documentation
* [JUnit](https://junit.org) - Testing framework

## Lessons Learned

A lot of research was done for the lifespan of the project. The topics covered specifically are as follows:

| Topic	| 	|   |   |   |
|:-:	|---|---|---|---|
| Efficient dependency management   |   |   |   |   |
| Behavior-driven development (BDD) |   |   |   |   |
| API Documentation 				|   |   |   |   |
| Database role management (MySQL) 	|	|	|	|	|
| Resilience design patterns 		|	|	|	|	|

## Authors

* **Juan Ortiz** - *Initial work* - [NotJuanOrtiz](https://github.com/notjuanortiz)

See the list of [contributors](https://github.com/notjuanortiz/flight-management-backend/contributors) who participated in this project.

## License

TBD