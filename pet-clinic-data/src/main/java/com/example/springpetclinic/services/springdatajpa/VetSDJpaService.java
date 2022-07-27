package com.example.springpetclinic.services.springdatajpa;

import com.example.springpetclinic.model.Vet;
import com.example.springpetclinic.repsoitories.VetRepo;
import com.example.springpetclinic.services.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Profile("springdatajpa")
@Primary
public class VetSDJpaService implements VetService {
    private final VetRepo vetRepo;

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();

        vetRepo.findAll().forEach(vets::add);

        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepo.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepo.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepo.deleteById(aLong);
    }
}
