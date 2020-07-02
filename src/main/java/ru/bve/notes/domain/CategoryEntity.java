package ru.bve.notes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.*;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "ctg", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TaskEntity> tasks;

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

    public void setTasks(List<TaskEntity> tasks){ this.tasks = tasks; }

    public List<TaskEntity> getTasks(){ return tasks; }

}
