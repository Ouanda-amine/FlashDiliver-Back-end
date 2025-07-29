package com.example.FlashDelivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CommandeDto {
    private Long id;
    private Long idClient;
    private Long idLivreur;
    private List<Long> productsList;

}
