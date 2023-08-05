package com.developer.GreatHouseOfWesteros.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.developer.GreatHouseOfWesteros.entity.GotEntity;

@Repository
public interface GotCharacterRepository extends JpaRepository<GotEntity, Long> {
	
    @Query("SELECT DISTINCT g.houseName FROM GotEntity g")
    List<String> findUniqueHouseNames();

    List<GotEntity> findByHouseName(String houseName);
    
//    @Query("SELECT * FROM GotEntity g Where g.characterLink = characterLink")
//	Optional<GotEntity> findByCharacterLink(String characterLink);
}
