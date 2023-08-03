package org.wcci.services;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.entities.Pet;
import org.wcci.repositories.PetRepo;



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

    public Optional<Pet> findPet(Long petID) {
        return petRepo.findById(petID);
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

    public Pet writeToDatabase(Pet pet) {
        return petRepo.save(pet);
    }
}
