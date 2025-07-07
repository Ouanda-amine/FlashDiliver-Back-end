package com.example.FlashDelivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivreurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
