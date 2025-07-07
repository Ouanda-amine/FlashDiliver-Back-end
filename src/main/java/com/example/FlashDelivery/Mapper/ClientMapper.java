package com.example.FlashDelivery.Mapper;

import com.example.FlashDelivery.Dto.ClientDto;
import com.example.FlashDelivery.Model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    ClientDto toClientDto(Client client);
    Client toCliententity(ClientDto clientDto);
    
}

