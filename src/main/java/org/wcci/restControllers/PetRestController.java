package org.wcci.restControllers;



import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.wcci.entities.Pet;
import org.wcci.repositories.PetRepo;
import org.wcci.services.PetService;

@RestController
public class PetRestController {
    public static final String LIST_ALL_NAMES = "listAllNames";
    public static final String LIST_ALL_HUNGERLEVELS = "listAllLevels";
    public static final String LIST_ALL_THIRSTLEVELS = "listAllThirstLevels";
    public static final String LIST_ALL_TRAININGLEVELS= "listAllTrainingLevels";
    public static final String LIST_ALL_BREEDS= "listAllBreeds";

    final private PetService petService;

    public PetRestController(@Autowired PetService service) {
        this.petService = service;
    }

    // Return all messages
    // curl -s http://localhost:8080/api/pets
    // This *reads* from the database and is the "R" in CRUD
    @GetMapping("/api/pets")
    public CollectionModel<EntityModel<Pet>> getPets() {
        List<EntityModel<Pet>> pets = this.petService.petStream()
                .map(pet -> EntityModel.of(pet))
                .collect(Collectors.toList());
        return CollectionModel.of(pets);
    }





    // Return all names of pets
    // curl -s http://localhost:8080/api/pets/names
    @GetMapping("/api/pets/names")
    public CollectionModel<String> getAllNames() {
        List<String> names = this.petService.petStream()
                .map(Pet::getName)
                .collect(Collectors.toList());
        return CollectionModel.of(names);
    }

    // Return all hunger of pets
    // curl -s http://localhost:8080/api/pets/hunger
    @GetMapping("/api/pets/hunger")
    public CollectionModel<String> getAllHunger() {
        List<String> hungerLevels = this.petService.petStream()
                .map(Pet::getHunger)
                .collect(Collectors.toList());
        return CollectionModel.of(hungerLevels);
    }

    // Return one pet
    // curl -s http://localhost:8080/api/pets/{petID}
    // This *reads* from the database and is the "R" in CRUD
    @GetMapping("/api/pets/{petID}")
    public EntityModel<Pet> getPet(@PathVariable final Long petID) {
        final Optional<Pet> pet = this.petService.findPet(petID);
        if (!pet.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return EntityModel.of(pet.get(),
                linkTo(methodOn(PetRestController.class).getPets()).withRel("LIST_ALL_PETS"),
                linkTo(methodOn(PetRestController.class).getPet(petID)).withSelfRel());
    }

    // Remove a student
    // curl -s -X DELETE http://localhost:8080/api/pets/{petID}
    // This *delete* a database record and is the "D" in CRUD
    @DeleteMapping("/api/pets/{petID}")
    public void deletePet(@PathVariable long petID) {
        this.petService.deleteById(petID);
    }

    // Save a new message
    // This method handles the HTTP POST request to save a new message
    // curl -s -X ADD http://localhost:8080/api/savepet
    @PostMapping("/api/savepet")
    public ResponseEntity<Pet> savePet(@RequestBody Pet pet) {
        // Call the writeToDatabase method to save the message to the database
        Pet savedPet = this.petService.writeToDatabase(pet);
        return ResponseEntity.ok(savedPet);
    }


}

