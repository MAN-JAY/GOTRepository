package com.developer.GreatHouseOfWesteros.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.developer.GreatHouseOfWesteros.entity.GotEntity;
import com.developer.GreatHouseOfWesteros.repository.GotCharacterRepository;


// ...

@Service
public class GotCharacterService {

    private final GotCharacterRepository gotCharacterRepository;

    public GotCharacterService(GotCharacterRepository gotCharacterRepository) {
        this.gotCharacterRepository = gotCharacterRepository;
    }

    public void saveCharacters(List<GotEntity> characters) {
        gotCharacterRepository.saveAll(characters);
    }
    //new
    public List<String> getAllUniqueHouseNames() {
        return gotCharacterRepository.findUniqueHouseNames();
    }

    public List<GotEntity> getCharactersByHouseName(String houseName) {
        return gotCharacterRepository.findByHouseName(houseName);
    }

    public void markCharacterAsFavorite(Long id, boolean isFavorite) {
        GotEntity character = gotCharacterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Character with id " + id + " not found"));

        character.setFavorite(isFavorite);
        gotCharacterRepository.save(character);
    }
    
//    public void markCharacterAsFavorite1(String characterLink, boolean isFavorite) {
//        GotEntity character = gotCharacterRepository.findByCharacterLink(characterLink)
//                .orElseThrow(() -> new IllegalArgumentException("Character with characterLink " + characterLink + " not found"));
//
//        character.setFavorite(isFavorite);
//        gotCharacterRepository.save(character);
//    }
}
