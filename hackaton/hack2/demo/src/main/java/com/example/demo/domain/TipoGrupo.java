package com.example.demo.domain;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipoGrupo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoGrupo")
    private List<Group> grupo;


    public TipoGrupo() {}
    
    public TipoGrupo(Long id, String name, List<Group> grupo) {
        this.id = id;
        this.name = name;
        this.grupo = grupo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

	public List<Group> getGrupo() {
		return grupo;
	}

	public void setGrupo(List<Group> grupo) {
		this.grupo = grupo;
	}
    
}
