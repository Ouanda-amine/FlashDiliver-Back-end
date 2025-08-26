package com.example.FlashDelivery.Repository;

import com.example.FlashDelivery.Model.CommandeProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComProRepository extends JpaRepository<CommandeProduit, Long> {
}

