# 🛒 E-Commerce Platform (JPA Workshop - Part 1)

A **Spring Boot + Spring Data JPA** backend project that demonstrates **One-to-One entity relationships**, repository queries, and database initialization using `CommandLineRunner`.

---

## 📌 Workshop Document

You can find the workshop description here:

[Workshop Document](SpringBoot-DataJPA-Workshop-Part1.md)

---
## 📌 Workshop Overview

This project is part of a JPA workshop focused on building the **foundation of an E-commerce system**, including:

- Customer management
- Address information (One-to-One)
- User profile data (One-to-One)
- Derived query methods in Spring Data JPA
- Database initialization and testing via console output

---

## 🧱 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate
- Maven
- Lombok

---

## 📂 Project Structure

- `entity/` → JPA entities (Customer, Address, UserProfile)
- `repository/` → Spring Data JPA repositories
- `config/` → DataInitializer (test data runner)

---

## 🚀 How to Run

### 1. Clone the repository
```bash
git clone https://github.com/jayani-athukorala/jpa-ecommerce-system.git
cd jpa-ecommerce-system

```
### 2. Configure Database

```bash
docker compose up -d
```

### 3. Build the project
```bash
mvn clean install
```

4. Run the application
```bash
mvn spring-boot:run
```

OR run the main class:
```bash
JpaEcommerceSystemApplication.java
```

## ⚡ Expected Output :

```
===== DATA INSERTED SUCCESSFULLY =====

Jayani Athukorala | jayani@email.com | Gothenburg
John Doe | john.doe@email.com | Stockholm
Anna Smith | anna.smith@email.com | Gothenburg

--- Find by email ---
Name: John Doe | Email: john.doe@email.com | City: Stockholm | Nickname: johnny

--- Find by last name ---
Name: Anna Smith | Email: anna.smith@email.com | City: Gothenburg | Nickname: anna

--- Find by city ---
Name: Jayani Athukorala | Email: jayani@email.com | City: Gothenburg | Nickname: jayani
Name: Anna Smith | Email: anna.smith@email.com | City: Gothenburg | Nickname: anna

--- Email contains ---
Name: John Doe | Email: john.doe@email.com | City: Stockholm | Nickname: johnny

--- Created after now-1 hour ---
Name: Jayani Athukorala | Email: jayani@email.com | City: Gothenburg | Nickname: jayani
Name: John Doe | Email: john.doe@email.com | City: Stockholm | Nickname: johnny
Name: Anna Smith | Email: anna.smith@email.com | City: Gothenburg | Nickname: anna

--- Count by city ---
2

--- Exists by email ---
true
```

---

