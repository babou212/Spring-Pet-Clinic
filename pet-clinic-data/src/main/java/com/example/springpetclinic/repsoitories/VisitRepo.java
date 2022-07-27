package com.example.springpetclinic.repsoitories;

import com.example.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit, Long> {
}
