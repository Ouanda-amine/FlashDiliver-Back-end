package com.example.FlashDelivery.Repository;

import com.example.FlashDelivery.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRipository extends JpaRepository<User , Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "select nom from user where email = ?" , nativeQuery = true)
    String getnom(String email);

}
