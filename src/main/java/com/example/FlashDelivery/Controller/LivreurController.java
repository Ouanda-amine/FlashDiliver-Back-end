package com.example.FlashDelivery.Controller;

import com.example.FlashDelivery.Dto.LivreurDto;
import com.example.FlashDelivery.Service.LivreurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class LivreurController {
    public LivreurService livreurService;


    @PostMapping("/AddLivreur")
    public LivreurDto AddLivreur(@RequestBody LivreurDto livreurDto){
        return livreurService.CreateLivreur(livreurDto);
    }

    @GetMapping("/AllLivreurs")
    public List<LivreurDto> getAllLivreures(){
        return livreurService.getAllLivreures();
    }

    @PutMapping("/Livreur/{id}")
    public LivreurDto UpdateLivreur(@RequestBody LivreurDto livreurDto ,@PathVariable Long id){
        return livreurService.UpdateLivreur(livreurDto , id);
    }


    @GetMapping("/livreur/{id}")
    public LivreurDto getLivreurById(@PathVariable Long id){
        return livreurService.getlivreurById(id);
    }

    @DeleteMapping("/SupLivreur/{id}")
    public void DeleteLivreur(@PathVariable Long id){
        livreurService.DeleteLivreur(id);
    }

}
