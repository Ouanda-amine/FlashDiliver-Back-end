package com.example.FlashDelivery.Repository;

import com.example.FlashDelivery.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Produit , Long> {
}
