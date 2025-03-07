package com.ejemplo.crud.controller;

import com.ejemplo.crud.model.Persona;
import com.ejemplo.crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    private Random random = new Random();

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @PostMapping
    public Persona createPersona() {
        String nombre = "Persona" + random.nextInt(100);
        int edad = random.nextInt(100);
        Persona nuevaPersona = new Persona(nombre, edad);
        return personaRepository.save(nuevaPersona);
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        Persona persona = personaRepository.findById(id).orElse(null);
        if (persona != null) {
            persona.setNombre(personaDetails.getNombre());
            persona.setEdad(personaDetails.getEdad());
            return personaRepository.save(persona);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaRepository.deleteById(id);
    }
}
