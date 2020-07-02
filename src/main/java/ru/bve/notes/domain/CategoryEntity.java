package ru.bve.notes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public CategoryEntity(){}

    public CategoryEntity(String name){ this(null, name); }

    public CategoryEntity(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(Long id){ this.id = id; }

    public Long getId(){ return id; }

    public void setName(String name){ this.name = name; }

    public String getName(){ return name; }

}
