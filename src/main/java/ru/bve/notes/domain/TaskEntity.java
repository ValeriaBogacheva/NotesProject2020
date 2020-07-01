package ru.bve.notes.domain;

import javax.persistence.*;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long parent_id;
    private String description;
    private Boolean done;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "categoryEntity_id", nullable = false)
    private CategoryEntity categoryEntity;

    public TaskEntity(){
    }

    public TaskEntity(Long id, Long parent_id, String description, Boolean done){
        this.id = id;
        this.parent_id = parent_id;
        this.description = description;
        this.done = done;
    }

    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

    public String getDescription(){ return description; }

    public void setDescription(String description) { this.description = description; }

    public Boolean getDone(){ return done; }

    public void setDone(Boolean done){ this.done = done; }

}
