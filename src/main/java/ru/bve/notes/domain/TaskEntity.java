package ru.bve.notes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long parent;
    private String title;
    private String description;
    private Boolean done;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryEntity category;

    public TaskEntity(){
    }

    public TaskEntity(Long parent, String title){
        this(null, parent, title, null, false, null, null, null);

        /*LocalDateTime currentDataTime = LocalDateTime.now();
        this.createDate = Date.from(currentDataTime.atZone(ZoneId.systemDefault()).toInstant());
        this.updateDate = createDate;*/
    }

    public TaskEntity(Long id, Long parent, String title, String description, Boolean done,
                      Date createDate, Date updateDate, Date date){
        this.id = id;
        this.parent = parent;
        this.title = title;
        this.description = description;
        this.done = done;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.date = date;
    }

    public void setId(Long id){ this.id = id; }

    public Long getId(){ return id; }

    public void setParent(Long parent){ this.parent = parent; }

    public Long getParent(){ return parent; }

    public void setTitle(String title){ this.title = title; }

    public String getTitle(){ return title; }

    public void setDescription(String description) { this.description = description; }

    public String getDescription(){ return description; }

    public void setDone(Boolean done){ this.done = done; }

    public Boolean getDone(){ return done; }

    public void setDate(Date date){ this.date = date; }

    public Date getDate(){ return date; }

    @JsonIgnore
    public void setCategory(CategoryEntity category){
        this.category = category;
    }

    public Long getCategoryId(){
        return category.getId();
    }

    public String getCategoryName(){
        return category.getName();
    }

}



