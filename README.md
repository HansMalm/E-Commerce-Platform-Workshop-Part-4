# 🛒 E-Commerce Platform (Spring Boot + JPA) Part3

A **Spring Boot + Spring Data JPA backend system** implementing a full e-commerce workflow using a **clean layered architecture** with DTOs, services, and mappers.

---
## 🚀 Project Overview

This project demonstrates how to build a scalable backend system using Spring Boot with a strong focus on **clean architecture and separation of concerns**.

The system models a complete e-commerce flow including:

- Customer management
- Product catalog with categories
- Promotion-based pricing
- Order processing with stock validation

It emphasizes **business logic encapsulation inside service layers**, while keeping entities and repositories isolated from the API layer.

---

## 🧱 Architecture

The project follows a layered architecture:

```
Service Layer (business logic)
        ↓
Mapper Layer (DTO ↔ Entity conversion)
        ↓
Repository Layer (data access)
        ↓
Database
```
### Key Design Principles

- Entities are not exposed outside the service layer
- DTOs are used for all input/output operations
- Business logic is centralized in services
- Mappers handle all transformations
- Transactions ensure consistency in order processing

---

## ⚙️ Core Features

### 👤 Customer Management

- Register customer with validation
- Fetch and update customer data
- Email uniqueness enforcement

### 📦 Product Catalog

- Create products with category validation
- Search products by name
- Manage stock and pricing

### 🏷️ Category Management

- Organize products into categories
- Prevent duplicate categories

### 🎯 Promotion System

- Time-based active promotions
- Best discount selection per product
- Discount applied during order processing

### 🧾 Order Processing

- Place orders with multiple items
- Stock validation before purchase
- Promotion-based discount calculation
- Price snapshot at purchase time
- Fully transactional order creation

---
## 🔄 Business Flow

- Customer places order
- System validates customer and products
- Stock availability is checked
- Active promotions are evaluated
- Discount is calculated via PromotionService
- Order + OrderItems are created
- Stock is updated
- Transaction commits

---

## 🧠 Key Learning Outcomes

- Designing layered Spring Boot architecture
- Using DTOs (Java Records) for API safety
- Implementing service-based business logic
- Writing reusable mapper components
- Handling complex order workflows
- Applying `@Transactional` for consistency
- Managing `Many-to-Many` relationships (Products ↔ Promotions)

---

## 📌 Workshop Documents
[Workshop Document - Part 3](SpringBoot-DataJPA-Service-Layer-Workshop-Part3.md)

[Workshop Document - Part 2](SpringBoot-DataJPA-Workshop-Part2.md)

[Workshop Document - Part 1](SpringBoot-DataJPA-Workshop-Part1.md)

---

## 🧱 Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate
- Maven
- Lombok

---

## 📂 Updated Project Structure

```
com.example.ecommerce
├── entity
├── exception
├── repository
├── service
│   ├── impl
│   ├── CustomerService
│   ├── ProductService
│   ├── OrderService
│   ├── PromotionService
│   ├── seeder
│   └── report
├── dto
│   ├── request
│   └── response
├── mapper
├── runner
└── JpaEcommerceSystemApplication
```
---

## 🚀 How to Run

```
git clone https://github.com/jayani-athukorala/jpa-ecommerce-system.git
cd jpa-ecommerce-system

docker compose up -d
mvn clean install
mvn spring-boot:run
```
