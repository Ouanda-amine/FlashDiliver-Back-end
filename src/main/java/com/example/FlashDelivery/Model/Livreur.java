package com.example.FlashDelivery.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
public class Livreur extends User{

    public Livreur (){this.setRole(Role.LIVREUR);}

    public Livreur(Long id, String nom, String prenom, String email, String password) {
        super(id, nom, prenom, email, password, Role.LIVREUR);
    }

    @OneToMany
    private List<Commande> commandes;
}
