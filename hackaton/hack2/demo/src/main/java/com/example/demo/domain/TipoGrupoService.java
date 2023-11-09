package com.example.demo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infrastracture.TipoGrupoRepository;

@Service
public class TipoGrupoService{
@Autowired
private TipoGrupoRepository tipoGrupoRepository;


    public TipoGrupo saveTipoGrupo(TipoGrupo TipoGrupo) {
        return tipoGrupoRepository.save(TipoGrupo);
    }

    public Optional<TipoGrupo> findTipoGrupoById(Long id) {
        return tipoGrupoRepository.findById(id);
    }

    public List<TipoGrupo> findAllTipoGrupos() {
        return tipoGrupoRepository.findAll();
    }
}