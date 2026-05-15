package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    List<Customer> findByLastNameIgnoreCase(String lastName);

    List<Customer> findByAddressCity(String city);

    List<Customer> findByEmailContaining(String keyword);

    List<Customer> findByCreatedAtAfter(Instant date);

    List<Customer> findByCreatedAtBetween(Instant start, Instant end);

    long countByAddressCity(String city);

    boolean existsByEmail(String email);
}
