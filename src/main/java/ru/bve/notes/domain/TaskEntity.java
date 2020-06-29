package ru.bve.notes.domain;

import javax.persistence.*;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryEntity_id")
    private CategoryEntity categoryEntity;

    public TaskEntity(){
    }

    public TaskEntity(Long id, String description){
        this.id = id;
        this.description = description;
    }

    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

    public String getDescription(){ return description; }

    public void setDescription(String description) { this.description = description; }
}
