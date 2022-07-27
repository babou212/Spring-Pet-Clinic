package com.example.springpetclinic.repsoitories;

import com.example.springpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepo extends CrudRepository<Speciality, Long> {
}
