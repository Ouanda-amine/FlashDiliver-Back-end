package com.example.FlashDelivery.Service;

import com.example.FlashDelivery.Dto.ClientDto;
import com.example.FlashDelivery.Mapper.ClientMapper;
import com.example.FlashDelivery.Model.Client;
import com.example.FlashDelivery.Repository.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepo clientRepo;

    public ClientDto AddClient(ClientDto clientDto){
        return clientMapper.toClientDto(clientRepo.save(clientMapper.toCliententity(clientDto)));

    }

    public List<ClientDto> getAllClients(){
        return clientRepo.findAll().stream()
                .map(client->clientMapper.toClientDto(client))
                .toList();
    }

    public ClientDto getClientById(Long id){
        return clientRepo.findById(id).map(client -> clientMapper.toClientDto(client))
                .orElseThrow(()->new RuntimeException("client non trouvé"));
    }

    public ClientDto UpdateClient(ClientDto clientDto , Long id){
        Client client = clientRepo.findById(id).get();
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());

        return clientMapper.toClientDto(clientRepo.save(client));

    }

    public void DeleteClient(Long id){
        clientRepo.deleteById(id);
    }


}
