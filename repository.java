package com.ejemplo.crud.repository;

import com.ejemplo.crud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
