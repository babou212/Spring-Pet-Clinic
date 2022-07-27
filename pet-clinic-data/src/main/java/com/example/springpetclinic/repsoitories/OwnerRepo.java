package com.example.springpetclinic.repsoitories;

import com.example.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastname);
}
