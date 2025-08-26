package com.example.FlashDelivery.Dto;

import com.example.FlashDelivery.Model.Status;
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
    private String idLivreur;
    private List<Long> productsList;
    private String adresse;
    private String status;



}
