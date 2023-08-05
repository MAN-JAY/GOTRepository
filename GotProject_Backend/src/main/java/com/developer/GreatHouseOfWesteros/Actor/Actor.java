package com.developer.GreatHouseOfWesteros.Actor;

import java.util.List;

@jakarta.persistence.Embeddable
public class Actor {
    private String actorName;
    private String actorLink;
    private List<Integer> seasonsActive;

    // Constructors, getters, and setters

    // Constructors
    public Actor() {
    }

    public Actor(String actorName, String actorLink, List<Integer> seasonsActive) {
        this.actorName = actorName;
        this.actorLink = actorLink;
        this.seasonsActive = seasonsActive;
    }

    // Getters and Setters
    // Note: Include all the getters and setters for the properties defined above.

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

    public List<Integer> getSeasonsActive() {
        return seasonsActive;
    }

    public void setSeasonsActive(List<Integer> seasonsActive) {
        this.seasonsActive = seasonsActive;
    }
}
