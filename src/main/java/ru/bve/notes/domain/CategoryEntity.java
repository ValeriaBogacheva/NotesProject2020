package ru.bve.notes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.*;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue//(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TaskEntity> tasks = new HashSet<>();

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
