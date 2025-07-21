package com.example.FlashDelivery.Service;

import com.example.FlashDelivery.Dto.CommandeDto;
import com.example.FlashDelivery.Mapper.CommandeMapper;
import com.example.FlashDelivery.Model.Commande;
import com.example.FlashDelivery.Repository.ClientRepo;
import com.example.FlashDelivery.Repository.CommandeRepo;
import com.example.FlashDelivery.Repository.LivreurRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommandeService {

    private final CommandeMapper commandeMapper;
    private final CommandeRepo commandeRepo;
    private final ClientRepo clientRepo;
    private final LivreurRepo livreurRepo;

    public CommandeDto CreateCommande(CommandeDto commandeDto){
        var client = clientRepo.findById(commandeDto.getIdClient()).orElse(null);
        var livreur = livreurRepo.findById(commandeDto.getIdLivreur()).orElse(null);

        var res = commandeRepo.save(new Commande(null , client,livreur));

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


}
