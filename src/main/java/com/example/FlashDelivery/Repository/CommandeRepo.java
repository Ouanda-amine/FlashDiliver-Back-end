package com.example.FlashDelivery.Repository;

import com.example.FlashDelivery.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepo extends JpaRepository<Commande , Long> {
}
