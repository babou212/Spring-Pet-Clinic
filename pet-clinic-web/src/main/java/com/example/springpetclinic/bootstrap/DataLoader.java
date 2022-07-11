package com.example.springpetclinic.bootstrap;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.model.Vet;
import com.example.springpetclinic.services.OwnerService;
import com.example.springpetclinic.services.VetService;
import com.example.springpetclinic.services.map.OwnerMapService;
import com.example.springpetclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerMapService();
        vetService = new VetMapService();
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("tim");
        owner1.setLastName("Allen");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Bob");
        owner2.setLastName("Ross");

        ownerService.save(owner2);

        System.out.println("loaded owners.......");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Martin");
        vet1.setLastName("DoLittle");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("David");
        vet2.setLastName("Attenborough");

        vetService.save(vet2);

        System.out.println("loaded vets.......");
    }
}
