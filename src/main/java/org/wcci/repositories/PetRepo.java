package org.wcci.repositories;

import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;
import org.wcci.entities.Pet;

// Unfortunately, the first type is the "value" and the second type is the "key" (opposite Map)
// Keys are typically either Long or String (They are usually "Long" if you let the database make them automatically, and String if you're using some predefined key, like SSN)
/** I know how to read and write Student objects to a database */
public interface PetRepo extends CrudRepository<Pet, Long> {
    //list of all the pets
    //allows us to use CREATE READ UPDATE DELETE
}
