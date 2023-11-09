package com.example.demo.application;
import com.example.demo.domain.Group;
import com.example.demo.domain.GroupService;
import com.example.demo.domain.Persona;
import com.example.demo.domain.PersonaService;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/persons")
@CrossOrigin(origins = "*")
public class PersonaController {
 @Autowired
    private PersonaService personaService;
 @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<Persona> createpersona(@RequestBody Persona persona) {
        return new ResponseEntity<>(personaService.savepersona(persona), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> persona(@PathVariable Long id) {
        Optional<Persona> persona = personaService.findpersonaById(id);
        return new ResponseEntity<>(persona.get(), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Persona>> getAllpersonas() {
        return new ResponseEntity<>(personaService.findAllpersonas(), HttpStatus.OK);
    }

    //mod
    @GetMapping("/groups/{groupId}")
    public ResponseEntity<Set<Persona>> getPersonsByGroupId(@PathVariable Long groupId) {
    Optional<Group> groupOpt = groupService.findgroupById(groupId);
    if (groupOpt.isPresent()) {
        return new ResponseEntity<>(groupOpt.get().getPersonas(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

     
}