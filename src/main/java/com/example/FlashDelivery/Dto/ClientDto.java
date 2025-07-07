package com.example.FlashDelivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class ClientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
