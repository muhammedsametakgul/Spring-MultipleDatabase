# Spring Boot ile Birden Fazla Veritabanı Bağlama

Bu proje, Spring Boot kullanarak MySQL ve PostgreSQL veritabanlarına bağlanmayı gösteren bir örnektir. Proje, Docker ile veritabanlarını çalıştırır ve Spring Data JPA kullanarak her iki veritabanı ile etkileşimde bulunur. 

## İçindekiler

- [Proje Tanıtımı](#proje-tanıtımı)
- [Gereksinimler](#gereksinimler)
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [Veritabanı Tabloları](#veritabanı-tabloları)
- [Test](#test)
- [Kaynak Kodlar](#kaynak-kodlar)
- [İletişim](#iletişim)
- [Kısayollar](#kısayollar)

## Proje Tanıtımı

Bu proje, Spring Boot uygulamasında birden fazla veritabanını nasıl yapılandıracağınızı ve kullanacağınızı göstermektedir. Docker Compose kullanarak MySQL ve PostgreSQL veritabanlarını ayağa kaldırır ve Spring Boot ile bu veritabanlarına bağlantı sağlar. Ayrıca, CRUD işlemlerini gerçekleştirmek için gerekli olan Repository, Service ve Controller katmanlarını içerir.

## Gereksinimler

- Java 17
- Maven
- Docker
- Postman

## Kurulum

1. **Spring Boot Projesi Oluşturma**
   - Spring Initializr üzerinden proje oluşturun ve aşağıdaki bağımlılıkları ekleyin:
     - MySQL Driver
     - Lombok
     - Spring Data JPA
     - PostgreSQL Driver
     - Spring Web

2. **Docker Compose Dosyası**
   - Proje kök dizinine `docker-compose.yml` dosyasını ekleyin ve aşağıdaki kodu yapıştırın:

     ```yaml
     version: '3.8'
     services:
       mysql-db:
         image: mysql
         container_name: mysql-db
         environment:
           MYSQL_ROOT_PASSWORD: rootpassword
           MYSQL_DATABASE: myfirstdb
           MYSQL_USER: user
           MYSQL_PASSWORD: password
         ports:
           - "3306:3306"
         volumes:
           - mysql-data:/var/lib/mysql

       postgres-db:
         image: postgres
         container_name: postgres-db
         environment:
           POSTGRES_DB: myseconddb
           POSTGRES_USER: user
           POSTGRES_PASSWORD: password
         ports:
           - "5432:5432"
         volumes:
           - postgres-data:/var/lib/postgresql/data

     volumes:
       mysql-data:
       postgres-data:
     ```

3. **Docker ile Veritabanlarını Çalıştırma**
   - Terminale geçiş yapın ve proje dizininde aşağıdaki komutu çalıştırın:
     
     ```bash
     docker-compose up -d
     ```

4. **Spring Boot Konfigürasyonu**
   - `src/main/resources/application.yml` dosyasını oluşturun ve aşağıdaki konfigürasyonu yapıştırın:

     ```yaml
     spring:
       datasource:
         mysql:
           url: jdbc:mysql://localhost:3306/myfirstdb
           username: user
           password: password
           driver-class-name: com.mysql.cj.jdbc.Driver
         postgresql:
           url: jdbc:postgresql://localhost:5432/myseconddb
           username: user
           password: password
           driver-class-name: org.postgresql.Driver

       jpa:
         mysql:
           properties:
             hibernate:
               dialect: org.hibernate.dialect.MySQL8Dialect
         postgresql:
           properties:
             hibernate:
               dialect: org.hibernate.dialect.PostgreSQLDialect
         hibernate:
           ddl-auto: update
     ```

## Kullanım

### Model

- **MySQLUser.java**: MySQL veritabanı için model.
- **PostgreSQLUser.java**: PostgreSQL veritabanı için model.

### Repository

- **MySQLUserRepository.java**: MySQL veritabanı için Repository.
- **PostgreSQLUserRepository.java**: PostgreSQL veritabanı için Repository.

### Service

- **UserService.java**: Veritabanı işlemleri için servis katmanı.

### Controller

- **UserController.java**: API uç noktalarını sağlayan kontrolcü.

## Veritabanı Tabloları

Aşağıdaki SQL komutları ile tabloları oluşturabilirsiniz:

**MySQL:**

```sql
docker exec -it mysql-db mysql -u user -p
USE myfirstdb;
CREATE TABLE MySQLUser (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
SHOW TABLES;
```

**POSTGRESQL:**
```sql
docker exec -it postgres-db psql -U user -d myseconddb
CREATE TABLE PostgreSQLUser (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
\dt
```

