package com.example.FlashDelivery.Controller;

import com.example.FlashDelivery.Dto.CommandeDto;
import com.example.FlashDelivery.Service.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
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


}
