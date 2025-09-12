package com.example.FlashDelivery.Repository;

import com.example.FlashDelivery.Dto.CommandeDto;
import com.example.FlashDelivery.Dto.Returntype;
import com.example.FlashDelivery.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande , Long> {

    List<Commande> findCommandeByClient_Email(String clientEmail);

    List<Commande> findCommandeByLivreur_Email(String livreurEmail);

    Integer countCommandeByLivreurEmail(String email);


    @Query(value = "select count(c.id) from commande c  inner join user u on u.id = c.livreur_id where u.email= ? and c.status = 'EN_ATTENTE'",nativeQuery = true)
    Integer countCommandeByStatus_EnAttente(String email);

    @Query(value = "select count(c.id) from commande c  inner join user u on u.id = c.livreur_id where u.email= ? and c.status = 'LIVRE' ",nativeQuery = true)
    Integer countCommandeByStatus_Livre(@Param("email") String email);

    @Query(value = "select c.id as id , count(p.id) as nbr from produit p inner join commande_produit cp  on p.id = cp.produit_id inner join commande c on c.id = cp.commande_id group by c.id",nativeQuery = true)
    List<Returntype> nbrProduitByidCommande();
}
