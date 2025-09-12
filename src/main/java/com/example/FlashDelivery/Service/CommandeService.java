package com.example.FlashDelivery.Service;

import com.example.FlashDelivery.Dto.CommandeDto;
import com.example.FlashDelivery.Dto.Returntype;
import com.example.FlashDelivery.Mapper.CommandeMapper;
import com.example.FlashDelivery.Model.Commande;
import com.example.FlashDelivery.Model.CommandeProduit;
import com.example.FlashDelivery.Model.Produit;
import com.example.FlashDelivery.Model.Status;
import com.example.FlashDelivery.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommandeService {

    private final CommandeMapper commandeMapper;
    private final CommandeRepo commandeRepo;
    private final ClientRepo clientRepo;
    private final LivreurRepo livreurRepo;
    private final ProductRepo productRepo;
    private final ComProRepository comProRepository;

    public CommandeDto CreateCommande(CommandeDto commandeDto){
        var client = clientRepo.findById(commandeDto.getIdClient()).orElse(null);
        var livreur = livreurRepo.findByEmail((commandeDto.getIdLivreur()));

        var commande = new Commande(null, client, livreur, commandeDto.getAdresse());
        commande.setPrix(0.0);

        var res = commandeRepo.save(commande);

        double total = 0.0;
        for (Long id : commandeDto.getProductsList()) {
            Produit produit = productRepo.findById(id).orElse(null);
            if (produit != null) {
                commanderProduit(res.getId(), id);
                total += produit.getPrix();
            }
        }

        res.setPrix(total);
        commandeRepo.save(res);

        return commandeMapper.ToCommandeDTO(res);


    }

    public List<CommandeDto> getAllCommandes(){
        return commandeRepo.findAll().stream()
                .map(commandeMapper::ToCommandeDTO)
                .toList();
    }

    public CommandeDto getCommandeById(Long id){
        return commandeRepo.findById(id).map(commandeMapper::ToCommandeDTO)
                .orElseThrow(()->new RuntimeException("commande not found"));
    }

    public void DeleteCommande(Long id){
        commandeRepo.deleteById(id);
    }

    public List<CommandeDto> getCommandeByUseremail(){
        UserDetails userDetails1 = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails1.getUsername();

        return commandeRepo.findCommandeByClient_Email(email).stream()
                .map(commandeMapper::ToCommandeDTO)
                .toList();

    }

    public void commanderProduit(Long commandeId , Long productId){
        Commande commande = commandeRepo.findById(commandeId).orElse(null);

        Produit produit = productRepo.findById(productId).orElse(null);

        CommandeProduit commandeProduit = new CommandeProduit();
        commandeProduit.setProduit(produit);
        commandeProduit.setCommande(commande);


        comProRepository.save(commandeProduit);
    }

    public List<CommandeDto> getCommandeLivreuremail(){
        UserDetails userDetails2 = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails2.getUsername();

        return commandeRepo.findCommandeByLivreur_Email(email).stream()
                .map(commandeMapper::ToCommandeDTO)
                .toList();

    }

    public Integer nbrcommandedelivreur(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        return commandeRepo.countCommandeByLivreurEmail(email);

    }

    public CommandeDto updateStatut(Long id , Status newStatut){
        Commande c = commandeRepo.findById(id).get();
        c.setStatus(newStatut);
        return commandeMapper.ToCommandeDTO(commandeRepo.save(c));
    }

    public Integer nbrCommandeEnAttente(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        return commandeRepo.countCommandeByStatus_EnAttente(email);
    }

    public Integer nbrCommandeLivree(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        return commandeRepo.countCommandeByStatus_Livre(email);
    }

    public List<Returntype> nbrByCmd(){
        return commandeRepo.nbrProduitByidCommande();
    }




}
