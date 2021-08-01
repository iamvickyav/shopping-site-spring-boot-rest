# Welcome to Shopping product

## Requirements

* MySQL
* IntelliJ Idea Community Edition
* Java 8 or Java 11
* Postman

### Basic DB Setup

```sql
CREATE DATABASE shopping;

USE shopping;

CREATE TABLE product 
(id INT, 
name VARCHAR(30), 
description VARCHAR(30), 
category VARCHAR(30), 
price INT, 
PRIMARY KEY(id));

ALTER TABLE product MODIFY description VARCHAR(100);

INSERT INTO product VALUES (1, "HP 15S", "HPs finest & thinnest laptop ever", "Laptop", 42500);
INSERT INTO product VALUES (2, "HP 14", "HPs finest & thinnest laptop ever", "Laptop", 32500);
INSERT INTO product VALUES (3, "Lenovo Thinkpad", "Lenovo's best laptop ever", "Laptop", 48000);
INSERT INTO product VALUES (4, "HP 15", "HPs finest & thinnest laptop ever", "Laptop", 42500);
INSERT INTO product VALUES (5, "Micromax TV", "thinnest TV ever", "TV", 13000);
INSERT INTO product VALUES (6, "Samsung TV", "finest picture ever", "TV", 18000);
INSERT INTO product VALUES (7, "LG TV", "fastest TV ever", "TV", 16000);
```

### Connection String

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/shopping
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### In Java Side

* Autowire JDBCTemplate
* Write RowMapper

```java
String query = "SELECT * FROM product where category = ? and price < ?";
List<ProductResponse> productResponses = jdbcTemplate.query(query,
                new Object[]{category, price}, new ProductMapper());
return productResponses;
```