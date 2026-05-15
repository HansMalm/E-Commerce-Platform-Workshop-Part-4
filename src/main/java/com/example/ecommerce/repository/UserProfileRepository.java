package com.example.ecommerce.repository;

import com.example.ecommerce.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByNickname(String nickname);

    List<UserProfile> findByPhoneNumberContaining(String phoneNumber);

    List<UserProfile> findByBioIsNotNull();

    List<UserProfile> findByNicknameStartingWith(String prefix);

    List<UserProfile> findByPhoneNumberStartingWith(String prefix);

    long countByPhoneNumberStartingWith(String prefix);
}