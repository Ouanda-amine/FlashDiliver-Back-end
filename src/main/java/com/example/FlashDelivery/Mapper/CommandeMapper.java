package com.example.FlashDelivery.Mapper;

import com.example.FlashDelivery.Dto.CommandeDto;
import com.example.FlashDelivery.Model.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface CommandeMapper {

    @Mapping(source = "livreur.id", target = "idLivreur")
    @Mapping(source = "client.id", target = "idClient")
    CommandeDto ToCommandeDTO (Commande commande);

    @Mapping(target = "livreur.id", source = "idLivreur")
    @Mapping(target = "client.id", source = "idClient")
    Commande ToCommandeEntity (CommandeDto commandeDto);
}
