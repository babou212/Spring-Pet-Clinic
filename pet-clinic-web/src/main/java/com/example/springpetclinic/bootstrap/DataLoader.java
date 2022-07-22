package com.example.springpetclinic.bootstrap;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.model.Pet;
import com.example.springpetclinic.model.PetType;
import com.example.springpetclinic.model.Vet;
import com.example.springpetclinic.services.OwnerService;
import com.example.springpetclinic.services.PetTypeService;
import com.example.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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
        owner2.setAddress("420 hemp alley");
        owner2.setCity("surrey");
        owner2.setCity("07344534669");

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

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("David");
        vet2.setLastName("Attenborough");

        vetService.save(vet2);

        System.out.println("loaded vets.......");
    }
}
