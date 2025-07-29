package com.example.FlashDelivery.Service;

import com.example.FlashDelivery.Dto.ProduitDto;
import com.example.FlashDelivery.Mapper.ProduitMapper;
import com.example.FlashDelivery.Model.Produit;
import com.example.FlashDelivery.Repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitService {
    private final ProduitMapper produitMapper;
    private final ProductRepo productRepo;

    public ProduitDto AddProduct(ProduitDto produitDto){
        System.out.println(produitDto.getNom());
        return produitMapper.ToProduitDto(productRepo.save(produitMapper.ToProduitEntity(produitDto)));

    }

    public List<ProduitDto>  getAllProducts(){
        return productRepo.findAll().stream()
                .map(produitMapper::ToProduitDto)
                .toList();
    }

    public ProduitDto UpdateProduct(ProduitDto produitDto , Long id){
        Produit produit = productRepo.findById(id).get();
        produit.setNom(produitDto.getNom());
        produit.setPrix(produitDto.getPrix());

        return produitMapper.ToProduitDto(productRepo.save(produit));
    }

    public ProduitDto getProductById(Long id){
        return productRepo.findById(id).map(produitMapper::ToProduitDto)
                .orElseThrow(()->new RuntimeException("product not found"));
    }

    public void DeleteProduct(Long id){
        productRepo.deleteById(id);
    }
}
