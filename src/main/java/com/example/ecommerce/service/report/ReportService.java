package com.example.ecommerce.service.report;

import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    /* =========================
       MAIN ENTRY POINT
    ========================= */
    public void generateReports() {
        printProductCatalog();
        printOrdersByStatus(OrderStatus.PAID);
        printOrdersByStatus(OrderStatus.SHIPPED);
        printFinalStock();
    }

    /* =========================
       PRODUCT CATALOG REPORT
    ========================= */
    public void printProductCatalog() {
        List<Product> products = productRepository.findAll();

        System.out.println("\nINITIAL PRODUCT STOCK:");
        System.out.println("==========================================================");
        System.out.println("                       PRODUCT CATALOG                    ");
        System.out.println("==========================================================");
        System.out.printf("%-5s %-20s %-15s %-10s %-6s%n",
                "ID", "Product Name", "Category", "Price", "Stock");
        System.out.println("----------------------------------------------------------");

        for (Product p : products) {
            System.out.printf("%-5d %-20s %-15s %-10.2f %-6d%n",
                    p.getId(),
                    p.getName(),
                    p.getCategory().getName(),
                    p.getPrice(),
                    p.getStock()
            );
        }

        System.out.println("==========================================================");
    }

    /* =========================
       ORDER REPORT (BILL STYLE)
    ========================= */
    public void printOrdersByStatus(OrderStatus status) {

        List<Order> orders = orderRepository.findByStatus(status);

        for (Order order : orders) {

            System.out.println("\nORDER " + order.getId() + ":");
            System.out.println("============================================");
            System.out.println("                ORDER RECEIPT              ");
            System.out.println("============================================");

            Customer customer = order.getCustomer();

            System.out.println("Order ID   : " + order.getId());
            System.out.println("Date       : " + order.getOrderDate());
            System.out.println("Status     : " + order.getStatus());
            System.out.println("Customer   : " + customer.getFirstName() + " " + customer.getLastName());
            System.out.println("Email      : " + customer.getEmail());

            System.out.println("--------------------------------------------");
            System.out.printf("%-15s %-5s %-10s %-10s%n",
                    "Product", "Qty", "Price", "Total");
            System.out.println("--------------------------------------------");

            BigDecimal grandTotal = BigDecimal.ZERO;

            for (OrderItem item : order.getItems()) {

                BigDecimal total = item.getPriceAtPurchase().multiply(
                        BigDecimal.valueOf(item.getQuantity())
                );

                grandTotal = grandTotal.add(total);

                System.out.printf("%-15s %-5d %-10.2f %-10.2f%n",
                        item.getProduct().getName(),
                        item.getQuantity(),
                        item.getPriceAtPurchase(),
                        total
                );
            }

            System.out.println("--------------------------------------------");
            System.out.println("TOTAL: " + grandTotal);
            System.out.println("============================================");
        }
    }

    /* =========================
       FINAL STOCK REPORT
    ========================= */
    public void printFinalStock() {

        List<Product> products = productRepository.findAll();

        System.out.println("\nFINAL PRODUCT STOCK:");
        System.out.println("==========================================================");
        System.out.println("                       PRODUCT CATALOG                    ");
        System.out.println("==========================================================");
        System.out.printf("%-5s %-20s %-15s %-10s %-6s%n",
                "ID", "Product", "Category", "Price", "Stock");
        System.out.println("----------------------------------------------------------");

        for (Product p : products) {
            System.out.printf("%-5d %-20s %-15s %-10.2f %-6d%n",
                    p.getId(),
                    p.getName(),
                    p.getCategory().getName(),
                    p.getPrice(),
                    p.getStock()
            );
        }

        System.out.println("==========================================================");
    }
}