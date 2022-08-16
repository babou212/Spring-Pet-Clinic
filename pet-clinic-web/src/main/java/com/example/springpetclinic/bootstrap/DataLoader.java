package com.example.springpetclinic.bootstrap;

import com.example.springpetclinic.model.*;
import com.example.springpetclinic.services.OwnerService;
import com.example.springpetclinic.services.PetTypeService;
import com.example.springpetclinic.services.SpecialtyService;
import com.example.springpetclinic.services.VetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    @Override
    public void run(String... args) {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("tim");
        owner1.setLastName("Allen");
        owner1.setAddress("69 zoo lane");
        owner1.setCity("London");
        owner1.setTelephone("0784564434");

        Pet timsPet = new Pet();
        timsPet.setPetType(savedDogPetType);
        timsPet.setOwner(owner1);
        timsPet.setBirthDate(LocalDate.now());
        timsPet.setName("rex");
        owner1.getPets().add(timsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Ross");
        owner2.setAddress("410 kemp alley");
        owner2.setCity("surrey");
        owner2.setTelephone("07344534669");

        Pet bobsPet = new Pet();
        bobsPet.setPetType(savedCatPetType);
        bobsPet.setOwner(owner2);
        bobsPet.setBirthDate(LocalDate.now());
        bobsPet.setName("whiskers");
        owner2.getPets().add(bobsPet);

        ownerService.save(owner2);

        System.out.println("loaded owners.......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Martin");
        vet1.setLastName("DoLittle");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("David");
        vet2.setLastName("Attenborough");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("loaded vets.......");

    }
}
