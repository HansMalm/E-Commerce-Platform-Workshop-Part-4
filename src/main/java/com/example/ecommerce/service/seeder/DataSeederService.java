package com.example.ecommerce.service.seeder;

import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DataSeederService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final UserProfileRepository profileRepository;

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PromotionRepository promotionRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public void seedAll() {
        seedCustomers();
        seedCategories();
        seedProducts();
        seedPromotions();
        seedOrders();
    }

    // ---------------- CUSTOMER ----------------
    private void seedCustomers() {

        if (customerRepository.count() > 0) return;

        // 1. CREATE ADDRESS FIRST
        Address a1 = addressRepository.save(new Address(null, "Street 1", "Gothenburg", "11111"));
        Address a2 = addressRepository.save(new Address(null, "Street 2", "Stockholm", "22222"));
        Address a3 = addressRepository.save(new Address(null, "Street 3", "Malmö", "33333"));

        // 2. CREATE PROFILES
        UserProfile p1 = profileRepository.save(new UserProfile(null, "jayani", "111", "bio1", null));
        UserProfile p2 = profileRepository.save(new UserProfile(null, "johnny", "222", "bio2", null));
        UserProfile p3 = profileRepository.save(new UserProfile(null, "emma", "333", "bio3", null));

        // 3. CREATE CUSTOMERS (NOW SAFE)
        Customer c1 = new Customer();
        c1.setFirstName("Jayani");
        c1.setLastName("A");
        c1.setEmail("j1@mail.com");
        c1.setCreatedAt(Instant.now());
        c1.setAddress(a1);
        c1.setProfile(p1);

        Customer c2 = new Customer();
        c2.setFirstName("John");
        c2.setLastName("Doe");
        c2.setEmail("j2@mail.com");
        c2.setCreatedAt(Instant.now());
        c2.setAddress(a2);
        c2.setProfile(p2);

        Customer c3 = new Customer();
        c3.setFirstName("Emma");
        c3.setLastName("J");
        c3.setEmail("j3@mail.com");
        c3.setCreatedAt(Instant.now());
        c3.setAddress(a3);
        c3.setProfile(p3);

        customerRepository.saveAll(List.of(c1, c2, c3));
    }

    // ---------------- CATEGORY ----------------
    private void seedCategories() {

        if (categoryRepository.count() > 0) return;

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category books = new Category();
        books.setName("Books");

        Category home = new Category();
        home.setName("Home");

        categoryRepository.saveAll(List.of(electronics, books, home));
    }

    // ---------------- PRODUCT ----------------
    private void seedProducts() {

        if (productRepository.count() > 0) return;

        Category electronics = categoryRepository.findByNameIgnoreCase("Electronics")
                .orElseThrow(() -> new RuntimeException("Electronics not found"));

        Category books = categoryRepository.findByNameIgnoreCase("Books")
                .orElseThrow(() -> new RuntimeException("Books not found"));

        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(new BigDecimal("1000"));
        p1.setCategory(electronics);
        p1.setStock(100);

        Product p2 = new Product();
        p2.setName("Phone");
        p2.setPrice(new BigDecimal("800"));
        p2.setCategory(electronics);
        p2.setStock(50);

        Product p3 = new Product();
        p3.setName("Java Book");
        p3.setPrice(new BigDecimal("50"));
        p3.setCategory(books);
        p3.setStock(88);

        Product p4 = new Product();
        p4.setName("Spring Book");
        p4.setPrice(new BigDecimal("60"));
        p4.setCategory(books);
        p4.setStock(20);

        Product p5 = new Product();
        p5.setName("Headphones");
        p5.setPrice(new BigDecimal("200"));
        p5.setCategory(electronics);
        p5.setStock(66);

        productRepository.saveAll(List.of(p1, p2, p3, p4, p5));
    }

    // ---------------- PROMOTION ----------------
    private void seedPromotions() {
        if (promotionRepository.count() > 0) return;

        Promotion p1 = new Promotion(null, "DISC10",
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(10));

        promotionRepository.save(p1);
    }

    // ---------------- ORDERS ----------------
    private void seedOrders() {

        if (orderRepository.count() > 0) return;

        Customer c1 = customerRepository.findAll().getFirst();
        Product product = productRepository.findAll().getFirst();

        Order order = new Order();
        order.setCustomer(c1);
        order.setStatus(OrderStatus.PAID);

        OrderItem item = new OrderItem();
        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(2);
        product.setStock(product.getStock() - 2);
        item.setPriceAtPurchase(product.getPrice());

        order.setItems(List.of(item));

        orderRepository.save(order);
    }
}