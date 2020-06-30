package ru.bve.notes.domain;

import javax.persistence.*;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Boolean done;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "categoryEntity_id", nullable = false)
    private CategoryEntity categoryEntity;

    public TaskEntity(){
    }

    public TaskEntity(Long id, String description, Boolean done){
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

    public String getDescription(){ return description; }

    public void setDescription(String description) { this.description = description; }

}
