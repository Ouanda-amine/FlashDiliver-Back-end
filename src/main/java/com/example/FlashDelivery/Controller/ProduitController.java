package com.example.FlashDelivery.Controller;

import com.example.FlashDelivery.Dto.ProduitDto;
import com.example.FlashDelivery.Service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ProduitController {

    public ProduitService produitService;


    @PostMapping("/AddProduct")
    public ProduitDto AddProduct(@RequestBody ProduitDto produitDto){
        return produitService.AddProduct(produitDto);
    }

    @GetMapping("/AllProducts")
    public List<ProduitDto> getAllProducts(){
        return produitService.getAllProducts();
    }


    @PutMapping("/Product/{id}")
    public ProduitDto UpdateProduct(@RequestBody ProduitDto produitDto ,@PathVariable Long id){
        return produitService.UpdateProduct(produitDto , id);
    }

    @GetMapping("/product/{id}")
    public ProduitDto getProductById(@PathVariable Long id){
        return produitService.getProductById(id);
    }

    @DeleteMapping("/SupProduct/{id}")
    public void DeleteProduct(@PathVariable Long id){
        produitService.DeleteProduct(id);
    }

}
