package com.example.springpetclinic.controllers;

import com.example.springpetclinic.model.Vet;
import com.example.springpetclinic.services.VetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Controller
public class VetController {
    private final VetService vetService;

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}
