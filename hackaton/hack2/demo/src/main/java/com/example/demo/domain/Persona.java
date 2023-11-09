package com.example.demo.domain;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity

public class Persona {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
Long id;
String name;

@ManyToMany(mappedBy = "personas")
@JsonBackReference
Set<Group> groups;

public Persona(){}
public Persona( String name, Set<Group> groups) {
    this.groups = groups;
    this.name = name;
}   
public void setId(Long id){
    this.id = id;
}
public Long getId(){
    return this.id;
}

public void setName(String name){this.name = name;}
public String getName(){return this.name;}
public void setGroups(Set<Group> groups){this.groups = groups;}
public Set<Group> getGroups(){return this.groups;}


}
