package com.example.springpetclinic.services.springdatajpa;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.repsoitories.OwnerRepo;
import com.example.springpetclinic.services.OwnerService;
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
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepo ownerRepo;

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();

        ownerRepo.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepo.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepo.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepo.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepo.findByLastName(lastName);
    }
}