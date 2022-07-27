package com.example.springpetclinic.repsoitories;

import com.example.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet, Long> {
}
