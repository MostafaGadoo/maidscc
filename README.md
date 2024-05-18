1- Clone the repo : git clone https://github.com/MostafaGadoo/maidscc

2- Update the application.properties file in src/main/resources with your database configuration:
  spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  
3- Build the application:
  mvn clean package

4- Run the application using Maven:
  mvn spring-boot:run


