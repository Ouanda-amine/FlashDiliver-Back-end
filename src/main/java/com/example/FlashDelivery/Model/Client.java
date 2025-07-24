package com.example.FlashDelivery.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity


public class Client extends  User{

    public Client(){this.setRole(Role.CLIENT);}

    public Client(Long id, String nom, String prenom, String email, String password) {
        super(id, nom, prenom, email, password, Role.CLIENT);
    }

    @OneToMany
    private List<Commande> commandes;
}
