package com.example.FlashDelivery.Mapper;

import com.example.FlashDelivery.Dto.ProduitDto;
import com.example.FlashDelivery.Model.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ProduitMapper {

    ProduitDto ToProduitDto (Produit produit);
    Produit ToProduitEntity (ProduitDto produitDto);
}
