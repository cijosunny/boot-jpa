# SPRING BOOT - DATA JPA 
## Steps To Create Spring Boot Application
	1. Create a maven project
	2. Set "spring-boot-starter-parent" as parent project and then add "spring-boot-starter-web" as dependency
	3. Create an Application.java class in the root package, it should have @SpringBootApplication annotation at class level and a main method
	4. Write a Controller class under the root package (@RestController and @RequestMapping/@GetMapping)

## Steps to connect to Database
	1. Add "spring-boot-starter-data-jpa" and the JDBC connector based on DB [mysql-connector-java] as dependencies
	2. In the application.properties add the database connection parameters [refer application-dev.properties]
	3. Create an interface with @Repository annotation with implements JpaRepository<ModelClass, IdDataType>
	4. Create a model java class with @Entity annotation and the primary key should have @Id annotation
	5. Create a service class with @Service annotation and create a method to save the model which calls the save method of Repository Interface which we created earlier. The repository interface will be injected in the service class.
	
## Steps to add Spring Security
	1. Add "spring-boot-starter-security" dependency [this itself gives basic security]
	2. For customizing create a configuration java class with @Configuration annotation, also add @EnableWebSecurity at class level
	3. Add extends WebSecurityConfigurerAdapter
	4. Override the method - *protected void configure(HttpSecurity http)* and write the logic for authorization in there
	5. Write a method *public void configureGlobal(AuthenticationManagerBuilder auth)* with @Autowired annotation to add Authentication logic
	
## Run SpringBoot Application in Embedded Tomcat
	1. Run as *spring-boot:run*	
	
	

## Run SpringBoot Application in External Tomcat
	1. Add the following dependency to pom.xml in order to tell Spring Boot not to use its embedded Tomcat.
		<dependency>
	    	<groupId>org.springframework.boot</groupId>
	    	<artifactId>spring-boot-starter-tomcat</artifactId>
	    	<scope>provided</scope>
		</dependency>
	2. Change the packaging property to war in pom.xml.
		<packaging>war</packaging>
	3. Replace your initializer class with the following:
		- 	extends SpringBootServletInitializer
		- 	@Override
	    	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    	}
	4. Define it as starting class in pom.xml
		<properties>
	      <start-class>com.boot.jpa.Application</start-class>
		</properties>	    		