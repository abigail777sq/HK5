package com.example.demo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Group;
import com.example.demo.domain.GroupService;
import com.example.demo.domain.Persona;
import com.example.demo.domain.PersonaService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;



@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "*")
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private PersonaService personaService;
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
    // Guardar las personas primero
    Set<Persona> savedPersonas = new HashSet<>();
    for (Persona persona : group.getPersonas()) {
        savedPersonas.add(personaService.savepersona(persona));
    }
    group.setPersonas(savedPersonas);
    
    // Ahora guardar el grupo
    Group savedGroup = groupService.saveGroup(group);
    
    return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
}

    @GetMapping
    public ResponseEntity<List<Group>> groups() {
        List<Group> groups = groupService.findAllgroups();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> group(@PathVariable("id") Long id) {
        Optional<Group> group = groupService.findgroupById(id);
        return new ResponseEntity<>(group.get(), HttpStatus.OK);
    }
    //
    @GetMapping("/persons/{personaId}")
    public ResponseEntity<Set<Group>> getGroupsByPersonId(@PathVariable Long personaId) {
    Optional<Persona> personaOpt = personaService.findpersonaById(personaId);
    if (personaOpt.isPresent()) {
        return new ResponseEntity<>(personaOpt.get().getGroups(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


}