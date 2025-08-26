package com.example.FlashDelivery.Service;

import com.example.FlashDelivery.Dto.CommandeDto;
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

        var res = commandeRepo.save(new Commande(null , client,livreur , commandeDto.getAdresse() , Status.valueOf(commandeDto.getStatus())));

        for (Long id : commandeDto.getProductsList()){
            commanderProduit(res.getId(), id);
        }

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




}
