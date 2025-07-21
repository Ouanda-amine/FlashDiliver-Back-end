package com.example.FlashDelivery.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity

public class Client extends  User{

    public Client(){this.setRole(Role.CLIENT);}

    @OneToMany
    private List<Commande> commandes;
}
