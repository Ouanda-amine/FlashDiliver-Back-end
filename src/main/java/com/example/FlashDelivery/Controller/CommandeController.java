package com.example.FlashDelivery.Controller;

import com.example.FlashDelivery.Dto.CommandeDto;
import com.example.FlashDelivery.Dto.Returntype;
import com.example.FlashDelivery.Model.Status;
import com.example.FlashDelivery.Service.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class CommandeController {

    public final CommandeService commandeService;


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

    @PutMapping("/updateStatut/{id}")
    public CommandeDto UpdateStatut(@PathVariable Long id, @RequestParam String newst) {
        return commandeService.updateStatut(id, Status.valueOf(newst));
    }

    @GetMapping("/nbrcmdenatt")
    public Integer getNombredeCommandeEnAttente(){
       return commandeService.nbrCommandeEnAttente();
    }

    @GetMapping("/nbrcmdliv")
    public Integer getNombredeCommandeliv(){
        return commandeService.nbrCommandeLivree();
    }

    @GetMapping("/nombreproductByCommande")
    public List<Returntype> nbrPro(){
       return commandeService.nbrByCmd();
    }




}
