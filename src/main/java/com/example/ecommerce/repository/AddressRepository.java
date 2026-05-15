package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByZipCode(String zipCode);

    List<Address> findByCity(String city);

    List<Address> findByStreetContaining(String street);

    List<Address> findByZipCodeStartingWith(String prefix);

    long countByCity(String city);
}
