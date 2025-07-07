package com.example.FlashDelivery.Service;

import com.example.FlashDelivery.Dto.LivreurDto;
import com.example.FlashDelivery.Mapper.LivreurMapper;
import com.example.FlashDelivery.Model.Livreur;
import com.example.FlashDelivery.Repository.LivreurRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LivreurService {

    private final LivreurMapper livreurMapper;
    private final LivreurRepo livreurRepo ;

    public LivreurDto CreateLivreur(LivreurDto livreurDto){
        return livreurMapper.ToLivreurDTO(livreurRepo
                .save(livreurMapper.ToLivreurEntity(livreurDto)));

    }
    public List<LivreurDto> getAllLivreures(){
        return livreurRepo.findAll().stream()
                .map(livreur->livreurMapper.ToLivreurDTO(livreur))
                .toList();
    }

    public LivreurDto getlivreurById(Long id){
        return livreurRepo.findById(id).map(livreurMapper::ToLivreurDTO)
                .orElseThrow(()->new RuntimeException("livreur pas trouvé"));
    }

    public LivreurDto UpdateLivreur(LivreurDto livreurDto , Long id){
        Livreur livreur = livreurRepo.findById(id).get();
        livreur.setNom(livreurDto.getNom());
        livreur.setPrenom(livreurDto.getPrenom());
        livreur.setEmail(livreurDto.getEmail());
        livreur.setPassword(livreurDto.getPassword());

        return livreurMapper.ToLivreurDTO(livreurRepo.save(livreur));
    }

    public void DeleteLivreur(Long id){
        livreurRepo.deleteById(id);
    }
}
