package com.example.FlashDelivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommandeDto {
    private Long id;
    private Long idClient;
    private Long idLivreur;
    private Long idProduct;

}
