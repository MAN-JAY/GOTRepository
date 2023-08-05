package com.developer.GreatHouseOfWesteros.controller;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.developer.GreatHouseOfWesteros.GotEntityWrapper.GotEntityWrapper;
import com.developer.GreatHouseOfWesteros.entity.GotEntity;
import com.developer.GreatHouseOfWesteros.service.GotCharacterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GotCharacterController {

    private final GotCharacterService gotCharacterService;

    public GotCharacterController(GotCharacterService gotCharacterService) {
        this.gotCharacterService = gotCharacterService;
    }
    

    @PostMapping("/characters/import")
    public ResponseEntity<String> importCharactersFromJson(@RequestBody Map<String, List<GotEntity>> charactersMap) {
        List<GotEntity> characters = charactersMap.get("characters");
        if (characters != null && !characters.isEmpty()) {
            gotCharacterService.saveCharacters(characters);
            return ResponseEntity.ok("Characters imported successfully.");
        } else {
            return ResponseEntity.badRequest().body("characters array not found or empty");
        }
    }
    
    @PostMapping("/import")
    public ResponseEntity<String> importCharactersFromJson(@RequestParam("file") MultipartFile file) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            GotEntityWrapper characterWrapper = objectMapper.readValue(file.getBytes(), GotEntityWrapper.class);

            gotCharacterService.saveCharacters(characterWrapper.getCharacters());

            return ResponseEntity.ok("Characters imported successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing characters: " + e.getMessage());
        }
    } 
    
    
    @GetMapping("/api/characters/houses")
    public ResponseEntity<List<String>> getAllUniqueHouseNames() {
        List<String> houseNames = gotCharacterService.getAllUniqueHouseNames();
        return ResponseEntity.ok(houseNames);
    }
    
    @GetMapping("/api/characters/familytree/{houseName}")
    public ResponseEntity<List<GotEntity>> getCharactersByHouseName(@PathVariable String houseName) {
        List<GotEntity> characters = gotCharacterService.getCharactersByHouseName(houseName);
        if (characters.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(characters);
    }

    @PutMapping("/api/characters/{id}/favourite")
    public ResponseEntity<Void> markAsFavorite(@PathVariable Long id,@RequestBody Boolean isFavorite) {
        gotCharacterService.markCharacterAsFavorite(id,isFavorite);
        return ResponseEntity.noContent().build();
    }
    
//    @PutMapping("/api/characters/{characterLink}/favourite")
//    public ResponseEntity<Void> markAsFavorite1(@PathVariable String characterLink,@RequestBody Boolean isFavorite) {
//        gotCharacterService.markCharacterAsFavorite1(characterLink,isFavorite);
//        return ResponseEntity.noContent().build();
//    }
}