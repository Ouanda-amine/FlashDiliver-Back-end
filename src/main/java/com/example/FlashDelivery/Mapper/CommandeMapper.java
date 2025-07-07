package com.example.FlashDelivery.Mapper;

import com.example.FlashDelivery.Dto.CommandeDto;
import com.example.FlashDelivery.Model.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface CommandeMapper {

    CommandeDto ToCommandeDTO (Commande commande);
    Commande ToCommandeEntity (CommandeDto commandeDto);
}
