package com.example.springpetclinic.services.springdatajpa;

import com.example.springpetclinic.model.Speciality;
import com.example.springpetclinic.repsoitories.SpecialityRepo;
import com.example.springpetclinic.services.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialtyService {
    private final SpecialityRepo specialityRepo;

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();

        specialityRepo.findAll().forEach(specialities::add);

        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepo.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepo.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepo.deleteById(aLong);
    }
}
