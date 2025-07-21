package com.example.FlashDelivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProduitDto {
    private Long id;
    private String nom;
    private Double prix;

}
