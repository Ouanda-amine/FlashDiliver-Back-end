package com.example.FlashDelivery.Controller;

import com.example.FlashDelivery.Dto.CommandeDto;
import com.example.FlashDelivery.Service.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class CommandeController {
    public CommandeService commandeService;


   @PostMapping("/AddCommande")
    public CommandeDto AddCommande(@RequestBody CommandeDto commandeDto){
        return commandeService.CreateCommande(commandeDto);
    }

    @GetMapping("/AllCommandes")
    public List<CommandeDto> getAllCommandes(){
       return commandeService.getAllCommandes();
    }

    @GetMapping("/commande/{id}")
    public CommandeDto getCommandeById(@PathVariable Long id){
       return commandeService.getCommandeById(id);
    }

    @DeleteMapping("/SupCommande/{id}")
    public void DeleteCommande(@PathVariable Long id){
       commandeService.DeleteCommande(id);
    }

    @GetMapping("/commandesOfClient")
    public List<CommandeDto> getCommandesByemail(){
       return commandeService.getCommandeByUseremail();
    }

    @GetMapping("/commandesOfLivreur")
    public List<CommandeDto> getCommandesBylivreur(){
        return commandeService.getCommandeLivreuremail();
    }

    @GetMapping("/nbrCommande")
    public Integer getNombreDeCommande(){
       return commandeService.nbrcommandedelivreur();
    }




}
