package org.wcci.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.wcci.entities.Pet;
import org.wcci.repositories.PetRepo;
import java.util.stream.StreamSupport;

@Service
public class PetService {
    private final PetRepo petRepo;

    public PetService(@Autowired PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    public Stream<Pet> petStream() {
        final Iterable<Pet> pets = this.petRepo.findAll();
        return StreamSupport.stream(pets.spliterator(), false);
    }

    public Pet findPet(Long petID) {
        return null;
    }

    public void deleteById(Long petID) {
        // Check if the message exists in the database
        if (petRepo.existsById(petID)) {
            petRepo.deleteById(petID);
        } else {
            // Throw an exception or handle the case when the message with the given ID is
            // not found
            throw new NoSuchElementException("Pet with ID " + petID + " not found");
        }
    }
}
