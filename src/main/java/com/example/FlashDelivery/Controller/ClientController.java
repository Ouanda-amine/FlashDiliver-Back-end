package com.example.FlashDelivery.Controller;

import com.example.FlashDelivery.Dto.ClientDto;
import com.example.FlashDelivery.Service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController {
    public ClientService clientService;


    @PostMapping("/AddClient")
    public ClientDto AddClient(@RequestBody ClientDto clientDto){
        return clientService.AddClient(clientDto);
    }

    @GetMapping("/AllClients")
    public List<ClientDto> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/client/{id}")
    public ClientDto getClientById(@PathVariable Long id ){
        return clientService.getClientById(id);
    }

    @PutMapping("/Client/{id}")
    public ClientDto UpdateClient(@RequestBody ClientDto clientDto ,@PathVariable Long id){
        return clientService.UpdateClient(clientDto , id);
    }


    @DeleteMapping("/SupClient/{id}")
    public void DeleteClient(@PathVariable Long id){
        clientService.DeleteClient(id);
    }

    


}
