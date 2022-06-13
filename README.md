# modelsis-springboot-fullstack

# Application Backend
Ce repertoire contient la partie backend de l'application  
## Table of Contents
1. [Technologies](#technologies)
2. [Installation](#installation)


## Technologies
***

* [Java 8]
* [Spring Boot 2.5.2 ou supérieur]
* [Spring Rest]
* [Spring Data]
* [JPA]
* [Maven 3.2]
* [Postgres 14]
* [Lombok (no getters and setters)]

### Installation
#### \> Configuration
***
  Configuration.(application.properties)

# Information generales de connexion a la base de donnees postgres
***
```
spring.datasource.url=jdbc:postgresql://localhost:5432/modelsis  //  Nom de la base de donnee
spring.datasource.username=postgres                             //  Utilisateur Postgres	
spring.datasource.password=Ibrahimaly01                        //  Mot de passe Utilisateur  
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
server.error.include-message=always
server.error.include-binding-errors=always
spring.jpa.hibernate.ddl-auto=create

```

# Demarage de l'application

1.Suivre ces instruction:
   
    1.1 Run (Demarage) du projet
    1.2	Commentez cette methode  dans la racine du projet (classe qui demarre le projet ModelsisSpringbootFullstackApplication.java):
	
		``` 		
			@Bean
			CommandLineRunner start(AccountService accountService){
				return args->{
					accountService.save(new AppRole(null,"USER"));
					accountService.save(new AppRole(null,"ADMIN"));

				};
			}		
		```
    1.3 Changer dans l'application.properties la valeur de  spring.jpa.hibernate.ddl-auto en update :
	
		```
			spring.jpa.hibernate.ddl-auto=update

        ```
2. Run
    	



