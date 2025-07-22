package com.example.FlashDelivery.Repository;

import com.example.FlashDelivery.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRipository extends JpaRepository<User , Long> {
    Optional<User> findByEmail(String email);

}
