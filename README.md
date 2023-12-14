Getting Started

Clone 
 ``` https://github.com/nandiniverma08/MatchHubProject.git ```


 Install Dependencies 
 1. Mysql-connector
 2. Data-JPA
 3. spring-web

    ``` https://maven.apache.org/ ```

 Database configurations in Applications.properties file 
```/com/resources/application.properties```
 ```# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Run Application 
 ``` /com/main/springbootapplication```

 ``` @SpringBootApplication
public class YourSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(YourSpringBootApplication.class, args);
    }
}
```


Install Database
MacOS

``` brew install mysql
brew services start mysql
```

Linux
```sudo apt update
sudo apt install mysql-server
sudo systemctl start mysql
sudo systemctl enable mysql
```

Important : ``` Carefully Connect the Database created in mysql with the name given in application.properties file. ```


