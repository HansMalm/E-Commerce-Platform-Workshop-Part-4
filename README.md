# 🛒 E-Commerce Platform (JPA Workshop - 3)

A **Spring Boot + Spring Data JPA** backend project that demonstrates **Entity relationships**, repository queries, and database initialization using `CommandLineRunner`.

---
## 🚀 Latest Update: Part 2 Completed

This project has been extended with **E-commerce Platform JPA (Part 2)**, adding full catalog management, ordering system, and advanced Spring Data JPA features.

---

## 🆕 Part 2 Highlights

In this extension, the system now supports a complete **E-commerce workflow**, including:

### 📦 Catalog Management
- Category → Product (One-to-Many)
- Product image handling
- Product search and filtering

### 🏷️ Promotions System
- Many-to-Many relationship between Product and Promotion
- Time-based active promotions
- Join table: `tbl_products_promotions`

### 🧾 Order Management System
- Customer → Order (Many-to-One)
- Order → OrderItems (One-to-Many)
- Product → OrderItem relationship
- Order status lifecycle (CREATED, PAID, SHIPPED, CANCELLED)

### 👤 Customer Enhancements (from Part 1)
- Customer entity reused
- One-to-One relationships:
    - Address
    - UserProfile

### ⚡ Advanced Spring Data JPA Features
- Derived query methods
- Custom JPQL queries
- EntityGraph / JOIN FETCH to avoid N+1 problem
- Nested property queries (e.g., `findByCategory_Name`)

### 🌱 Data Seeding
- Automatic database initialization using `CommandLineRunner`
- Seeded data includes:
    - Customers
    - Addresses
    - User Profiles
    - Categories
    - Products
    - Orders + OrderItems
- Duplicate-safe seeding logic

---

## 🧠 Key Learning Outcomes

- Designing full relational database models in JPA
- Handling complex entity relationships (1–1, 1–M, M–M)
- Writing derived query methods in Spring Data JPA
- Using JPQL for advanced queries
- Solving N+1 performance problems
- Implementing application-level data initialization

---

## 📌 Workshop Documents
[Workshop Document - Part 3](SpringBoot-DataJPA-Service-Layer-Workshop-Part3.md)

[Workshop Document - Part 2](SpringBoot-DataJPA-Workshop-Part2.md)

[Workshop Document - Part 1](SpringBoot-DataJPA-Workshop-Part1.md)

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

```
com.example.ecommerce
├── entity
│   ├── Customer
│   ├── Address
│   ├── UserProfile
│   ├── Category
│   ├── Product
│   ├── Promotion
│   ├── Order
│   ├── OrderItem
│   └── OrderStatus
├── repository
│   ├── CustomerRepository
│   ├── CategoryRepository
│   ├── ProductRepository
│   ├── OrderRepository
│   ├── OrderItemRepository
│   └── PromotionRepository
├── service
│   ├── seeder
│   │     └── DataSeederService
│   └── report
│         └── ReportService
├── runner
│   └── AppRunner   (CommandLineRunner entry point)
└── JpaEcommerceSystemApplication
```
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
INITIAL PRODUCT STOCK:
==========================================================
                       PRODUCT CATALOG                    
==========================================================
ID    Product Name         Category        Price      Stock 
----------------------------------------------------------
1     Laptop               Electronics     1000.00    98    
2     Phone                Electronics     800.00     50    
3     Java Book            Books           50.00      88    
4     Spring Book          Books           60.00      20    
5     Headphones           Electronics     200.00     66    
==========================================================

ORDER 1:
============================================
                ORDER RECEIPT              
============================================
Order ID   : 1
Date       : 2026-05-29T12:48:51.329447Z
Status     : PAID
Customer   : Jayani A
Email      : j1@mail.com
--------------------------------------------
Product         Qty   Price      Total     
--------------------------------------------
Laptop          2     1000.00    2000.00   
--------------------------------------------
TOTAL: 2000.00
============================================

FINAL PRODUCT STOCK:
==========================================================
                       PRODUCT CATALOG                    
==========================================================
ID    Product              Category        Price      Stock 
----------------------------------------------------------
1     Laptop               Electronics     1000.00    98    
2     Phone                Electronics     800.00     50    
3     Java Book            Books           50.00      88    
4     Spring Book          Books           60.00      20    
5     Headphones           Electronics     200.00     66    
==========================================================
```

---

