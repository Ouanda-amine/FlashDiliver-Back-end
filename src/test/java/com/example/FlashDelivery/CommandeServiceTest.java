package com.example.FlashDelivery;

import com.example.FlashDelivery.Dto.CommandeDto;
import com.example.FlashDelivery.Mapper.CommandeMapper;
import com.example.FlashDelivery.Model.Commande;
import com.example.FlashDelivery.Model.Status;
import com.example.FlashDelivery.Repository.CommandeRepo;
import com.example.FlashDelivery.Service.CommandeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CommandeServiceTest {

    @Mock
    private CommandeRepo commandeRepo;

    @Mock
    private CommandeMapper commandeMapper;

    @InjectMocks
    private CommandeService commandeService;

    @Test
    void testGetCommandeById_shouldReturnCommandeDto() {
        Long id = 1L;
        Commande commande = new Commande();
        commande.setId(id);

        CommandeDto expectedDto = new CommandeDto();
        expectedDto.setId(id);

        Mockito.when(commandeRepo.findById(id)).thenReturn(Optional.of(commande));
        Mockito.when(commandeMapper.ToCommandeDTO(commande)).thenReturn(expectedDto);

        CommandeDto result = commandeService.getCommandeById(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId());
    }

    @Test
    void testUpdateStatut_shouldUpdateAndReturnDto() {
        Long id = 2L;
        Status newStatus = Status.LIVRE;

        Commande commande = new Commande();
        commande.setId(id);
        commande.setStatus(Status.EN_ATTENTE);

        Commande updatedCommande = new Commande();
        updatedCommande.setId(id);
        updatedCommande.setStatus(newStatus);

        CommandeDto updatedDto = new CommandeDto();
        updatedDto.setId(id);
        updatedDto.setStatus(String.valueOf(newStatus));

        Mockito.when(commandeRepo.findById(id)).thenReturn(Optional.of(commande));
        Mockito.when(commandeRepo.save(Mockito.any(Commande.class))).thenReturn(updatedCommande);
        Mockito.when(commandeMapper.ToCommandeDTO(updatedCommande)).thenReturn(updatedDto);

        CommandeDto result = commandeService.updateStatut(id, newStatus);

        Assertions.assertEquals(newStatus, result.getStatus());
    }



}
