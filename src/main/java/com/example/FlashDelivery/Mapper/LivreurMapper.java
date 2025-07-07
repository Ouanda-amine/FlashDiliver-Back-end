package com.example.FlashDelivery.Mapper;

import com.example.FlashDelivery.Dto.LivreurDto;
import com.example.FlashDelivery.Model.Livreur;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LivreurMapper {

    LivreurDto ToLivreurDTO (Livreur livreur);
    Livreur ToLivreurEntity (LivreurDto livreurDto);
}
