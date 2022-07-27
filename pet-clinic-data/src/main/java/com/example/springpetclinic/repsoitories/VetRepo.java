package com.example.springpetclinic.repsoitories;

import com.example.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepo extends CrudRepository<Vet, Long> {
}
