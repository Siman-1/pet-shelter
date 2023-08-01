package org.wcci.Spring.entities;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {
    private String name;

    // name, hunger, thirst, training level, breed
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String hunger;

    public String getHunger() {
        return hunger;
    }

    public void setHunger(String hunger) {
        this.hunger = hunger;
    }

    private String thirstLevel;

    public String thirstLevel() {
        return thirstLevel;
    }

    public void setThirstLevel(String thirstLevel) {
        this.thirstLevel = thirstLevel;
    }

    private int trainingLevel;

    public int getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(int trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Id
    @GeneratedValue
    public Long messageID;
}
