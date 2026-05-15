package com.example.ecommerce.config;

import com.example.ecommerce.entity.Address;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.entity.UserProfile;
import com.example.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String @NonNull ... args) {

        // Avoid duplicate inserts on restart
        if (customerRepository.count() > 0) {
            IO.println("Data already exists. Skipping initialization...");
            runQueries();
            return;
        }

        Customer c1 = createCustomer(
                "Jayani", "Athukorala", "jayani@email.com",
                "Gothenburg", "41101",
                "jayani", "123456789", "Java Developer"
        );

        Customer c2 = createCustomer(
                "John", "Doe", "john.doe@email.com",
                "Stockholm", "11122",
                "johnny", "987654321", "Backend Engineer"
        );

        Customer c3 = createCustomer(
                "Anna", "Smith", "anna.smith@email.com",
                "Gothenburg", "41101",
                "anna", "555111222", "Frontend Developer"
        );

        customerRepository.saveAll(List.of(c1, c2, c3));

        IO.println("\n===== DATA INSERTED SUCCESSFULLY =====\n");

        customerRepository.findAll().forEach(c -> {
            IO.println(
                    c.getFirstName() + " " +
                            c.getLastName() + " | " +
                            c.getEmail() + " | " +
                            c.getAddress().getCity()
            );
        });

        runQueries();
    }

    // =========================
    // QUERIES SECTION
    // =========================
    private void runQueries() {

        IO.println("\n--- Find by email ---");
        customerRepository.findByEmail("john.doe@email.com")
                .ifPresent(this::printCustomer);

        IO.println("\n--- Find by last name ---");
        customerRepository.findByLastNameIgnoreCase("smith")
                .forEach(this::printCustomer);

        IO.println("\n--- Find by city ---");
        customerRepository.findByAddressCity("Gothenburg")
                .forEach(this::printCustomer);

        IO.println("\n--- Email contains ---");
        customerRepository.findByEmailContaining("doe")
                .forEach(this::printCustomer);

        IO.println("\n--- Created after now-1 hour ---");
        customerRepository.findByCreatedAtAfter(Instant.now().minusSeconds(3600))
                .forEach(this::printCustomer);

        IO.println("\n--- Count by city ---");
        IO.println(customerRepository.countByAddressCity("Gothenburg"));

        IO.println("\n--- Exists by email ---");
        IO.println(customerRepository.existsByEmail("anna.smith@email.com"));
    }

    // =========================
    // CREATE CUSTOMER
    // =========================
    private Customer createCustomer(
            String firstName,
            String lastName,
            String email,
            String city,
            String zip,
            String nickname,
            String phone,
            String bio
    ) {
        Address address = new Address();
        address.setStreet("Main Street");
        address.setCity(city);
        address.setZipCode(zip);

        UserProfile profile = new UserProfile();
        profile.setNickname(nickname);
        profile.setPhoneNumber(phone);
        profile.setBio(bio);

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setCreatedAt(Instant.now());
        customer.setAddress(address);
        customer.setProfile(profile);

        return customer;
    }

    // =========================
    // PRINT METHOD
    // =========================
    private void printCustomer(Customer c) {
        IO.println(
                "Name: " + c.getFirstName() + " " + c.getLastName() +
                        " | Email: " + c.getEmail() +
                        " | City: " + c.getAddress().getCity() +
                        " | Nickname: " + c.getProfile().getNickname()
        );
    }
}