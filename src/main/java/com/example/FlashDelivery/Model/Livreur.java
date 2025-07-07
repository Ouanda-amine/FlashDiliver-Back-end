package com.example.FlashDelivery.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Livreur extends User{

    @OneToMany
    private List<Commande> commandes;
}
