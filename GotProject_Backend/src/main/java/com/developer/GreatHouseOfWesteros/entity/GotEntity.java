package com.developer.GreatHouseOfWesteros.entity;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.developer.GreatHouseOfWesteros.Actor.Actor;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.*;


@Entity
public class GotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String characterLink;
    private String characterName;
    @ElementCollection
    private List <String> houseName;
    private String characterImageThumb;
    private String characterImageFull;
    private String actorName;
    private String actorLink;
    private Boolean favorite = false;
    private boolean royal;
    @ElementCollection
    private List<String> parents;
    @ElementCollection
    private List<String> siblings;
    private String nickname;
    private boolean kingsguard;
    @ElementCollection
    private List<String> killed;
    @ElementCollection
    private List<String> killedBy;
    @ElementCollection
    private List<String> servedBy;
    @ElementCollection
    private List<String> serves;
    @ElementCollection
    private List<String> parentOf;
    @ElementCollection
    private List<String> marriedEngaged;
    @ElementCollection
    private List<String> guardedBy;
    @ElementCollection
    private List<Integer> seasonsActive;
    @ElementCollection
    private List<Actor> actors;
    @ElementCollection
    private List<String> guardianOf;
    @ElementCollection
    private List<String> allies;
    @ElementCollection
    private List<String> abductedBy;
    @ElementCollection
    private List<String> abducted;
    @ElementCollection
    private List<String> sibling;
    // Constructors, getters, and setters

    // Other Constructors, getters, and setters as before...

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    public List<String> getGuardianOf() {
        return guardianOf;
    }

    public void setGuardianOf(List<String> guardianOf) {
        this.guardianOf = guardianOf;
    }
    
    public List<String> getAllies() {
        return allies;
    }

    public void setAllies(List<String> allies) {
        this.allies = allies;
    }
    
    public List<String> getAbductedBy() {
        return abductedBy;
    }

    public void setAbductedBy(List<String> abductedBy) {
        this.abductedBy = abductedBy;
    }
    
    public List<String> getAbducted() {
        return abducted;
    }

    public void setAbducted(List<String> abducted) {
        this.abducted = abducted;
    }
    
    public List<String> getSibling() {
        return sibling;
    }

    public void setSibling(List<String> sibling) {
        this.sibling = sibling;
    }

    // Default constructor (required by JPA)
    public GotEntity() {
    }

    // Constructor with all fields except the ID
    public GotEntity(
            String characterName,String characterLink, List<String> houseName, String characterImageThumb,List<String> guardianOf,List<String> allies,List<String>abductedBy,List<String>abducted,
            String characterImageFull, String actorName, String actorLink, boolean royal,List<String> sibling,
            List<String> parents, List<String> siblings, String nickname, boolean kingsguard,
            List<String> killed, List<String> killedBy, List<String> servedBy, List<String> serves,
            List<String> parentOf, List<String> marriedEngaged, List<String> guardedBy, List<Integer> seasonsActive,List<Actor> actors, Boolean favorite, Long id
    ) {
    	this.id = id;
    	this.favorite =favorite;
    	this.sibling = sibling;
    	this.abductedBy = abductedBy;
    	this.abducted = abducted;
    	this.allies = allies;
    	this.guardianOf = guardianOf;
    	this.actors = actors;
    	this.characterLink = characterLink;
        this.characterName = characterName;
        this.houseName = houseName;
        this.characterImageThumb = characterImageThumb;
        this.characterImageFull = characterImageFull;
        this.actorName = actorName;
        this.actorLink = actorLink;
        this.royal = royal;
        this.parents = parents;
        this.siblings = siblings;
        this.nickname = nickname;
        this.kingsguard = kingsguard;
        this.killed = killed;
        this.killedBy = killedBy;
        this.servedBy = servedBy;
        this.serves = serves;
        this.parentOf = parentOf;
        this.marriedEngaged = marriedEngaged;
        this.guardedBy = guardedBy;
        this.seasonsActive = seasonsActive;
    }

    // Getters and Setters for all fields

    public String getCharacterLink() {
        return characterLink;
    }

    public void setCharacterLink(String characterLink) {
        this.characterLink = characterLink;
    }
    
    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public List <String> getHouseName() {
        return houseName;
    }

    public void setHouseName(List <String> houseName) {
        this.houseName = houseName;
    }

    public String getCharacterImageThumb() {
        return characterImageThumb;
    }

    public void setCharacterImageThumb(String characterImageThumb) {
        this.characterImageThumb = characterImageThumb;
    }

    public String getCharacterImageFull() {
        return characterImageFull;
    }

    public void setCharacterImageFull(String characterImageFull) {
        this.characterImageFull = characterImageFull;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorLink() {
        return actorLink;
    }

    public void setActorLink(String actorLink) {
        this.actorLink = actorLink;
    }

    public boolean isRoyal() {
        return royal;
    }

    public void setRoyal(boolean royal) {
        this.royal = royal;
    }

    public List<String> getParents() {
        return parents;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }

    public List<String> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<String> siblings) {
        this.siblings = siblings;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isKingsguard() {
        return kingsguard;
    }

    public void setKingsguard(boolean kingsguard) {
        this.kingsguard = kingsguard;
    }

    public List<String> getKilled() {
        return killed;
    }

    public void setKilled(List<String> killed) {
        this.killed = killed;
    }

    public List<String> getKilledBy() {
        return killedBy;
    }

    public void setKilledBy(List<String> killedBy) {
        this.killedBy = killedBy;
    }

    public List<String> getServedBy() {
        return servedBy;
    }

    public void setServedBy(List<String> servedBy) {
        this.servedBy = servedBy;
    }

    public List<String> getServes() {
        return serves;
    }

    public void setServes(List<String> serves) {
        this.serves = serves;
    }

    public List<String> getParentOf() {
        return parentOf;
    }

    public void setParentOf(List<String> parentOf) {
        this.parentOf = parentOf;
    }

    public List<String> getMarriedEngaged() {
        return marriedEngaged;
    }

    public void setMarriedEngaged(List<String> marriedEngaged) {
        this.marriedEngaged = marriedEngaged;
    }

    public List<String> getGuardedBy() {
        return guardedBy;
    }

    public void setGuardedBy(List<String> guardedBy) {
        this.guardedBy = guardedBy;
    }

    public List<Integer> getSeasonsActive() {
        return seasonsActive;
    }

    public void setSeasonsActive(List<Integer> seasonsActive) {
        this.seasonsActive = seasonsActive;
    }
    
    public Long getId() {
        return id;
    }


}
