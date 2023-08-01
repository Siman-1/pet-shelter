package org.wcci.entities.PetClasses;

import java.util.HashMap;
import java.util.Map;

public class Shelter {
    // map for all pets in the shelter, key is name value is the Pet.
    private Map<String, Organic> animals;

    public Shelter() {

        animals = new HashMap<>();
    }

    public void adoptPet(String name, OrganicPet pet) {
        animals.put(name, pet);
    }

    public void adoptOutPet(String name) {
        animals.remove(name);
    }

    public Organic accessPet(String name) {
        return animals.get(name);
    }

    public void feedAll(int food) {
        for (Organic pet : animals.values()) {
            pet.feed(food);
        }
    }

}
