package com.example.demo.domain;

import com.example.demo.infrastracture.GroupRepository;
import com.example.demo.infrastracture.PersonaRepository;
import com.example.demo.infrastracture.TipoGrupoRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    
    @Autowired
    private TipoGrupoService tipoGrupoService;
    
    public Group saveGroup(Group group) {
        TipoGrupo tipoGrupo = group.getTipoGrupo();
        tipoGrupoService.saveTipoGrupo(tipoGrupo);

        group.setTipoGrupo(tipoGrupo);
        
        return groupRepository.save(group);
    }

    @Transactional
    public Optional<Group> findgroupById(Long id) {
        return groupRepository.findById(id);
    }

    public List<Group> findAllgroups() {
        return groupRepository.findAll();
    }

  
}
