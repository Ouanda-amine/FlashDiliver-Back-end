package com.example.FlashDelivery.Repository;

import com.example.FlashDelivery.Dto.Returntype;
import com.example.FlashDelivery.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Produit , Long> {

    @Query(value = "select (p.nom) from produit p inner join commande_produit cp  on p.id = cp.produit_id inner join commande c on c.id = cp.commande_id where c.status = 'EN_ATTENTE'" , nativeQuery = true)
    List<String> productNams();



}
