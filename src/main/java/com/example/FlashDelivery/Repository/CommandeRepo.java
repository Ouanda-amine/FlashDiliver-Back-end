package com.example.FlashDelivery.Repository;

import com.example.FlashDelivery.Dto.CommandeDto;
import com.example.FlashDelivery.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande , Long> {

    List<Commande> findCommandeByClient_Email(String clientEmail);

    List<Commande> findCommandeByLivreur_Email(String livreurEmail);

    Integer countCommandeByLivreurEmail(String email);

    String findCommandeByStatus(String statu);
}
