package com.example.demo.infrastracture;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {}

