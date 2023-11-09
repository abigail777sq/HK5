package com.example.demo.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infrastracture.GroupRepository;
import com.example.demo.infrastracture.PersonaRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository  personaRepository;
    @Autowired
    private GroupRepository  groupRepository;

    public Persona savepersona(Persona Persona) {
        return personaRepository.save(Persona);
    }

    @Transactional
    public Optional<Persona> findpersonaById(Long id) {
        return personaRepository.findById(id);
    }

    public List<Persona> findAllpersonas() {
        return personaRepository.findAll();
    }

    public PersonaRepository getPersonaRepository() {
        return personaRepository;
    }

    public void setPersonaRepository(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public GroupRepository getGroupRepository() {
        return groupRepository;
    }

    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    
}
