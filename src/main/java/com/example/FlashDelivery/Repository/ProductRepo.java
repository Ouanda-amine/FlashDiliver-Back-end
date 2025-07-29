package com.example.FlashDelivery.Repository;

import com.example.FlashDelivery.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Produit , Long> {

//    @Query(value = "select * from " ,nativeQuery = true)
}
