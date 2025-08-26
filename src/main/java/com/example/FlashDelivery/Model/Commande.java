package com.example.FlashDelivery.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    private Client client;

    @ManyToOne
    private Livreur livreur;

    @OneToMany
    private List<CommandeProduit> listcommandeProduit;

    private String adresse ;

    @Enumerated(EnumType.STRING)
    private Status status;




    public Commande(Long id, Client client, Livreur livreur , String adresse , Status status) {
        this.id = id;
        this.client = client;
        this.livreur = livreur;
        this.adresse = adresse;
        this.status = Status.EN_ATTENTE;
    }
}
