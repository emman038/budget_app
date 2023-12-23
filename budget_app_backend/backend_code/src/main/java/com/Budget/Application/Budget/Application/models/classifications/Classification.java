package com.Budget.Application.Budget.Application.models.classifications;

import com.Budget.Application.Budget.Application.models.ClassificationType;
import jakarta.persistence.*;

@MappedSuperclass
public class Classification {

    @Column
    private ClassificationType classificationType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    public Classification(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Classification(){}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
