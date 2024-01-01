package com.Budget.Application.Budget.Application.models.entries;

import com.Budget.Application.Budget.Application.models.EntryType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private EntryType entryType;

    @Column(name = "time_of_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timeOfCreation;

    @Column
    private String description;

    @Column(name = "number_of_edits")
    private int numberOfEdits;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timeOfLastEdit;

    public Entry(EntryType entryType, LocalDateTime timeOfCreation){
        this.entryType = entryType;
        this.timeOfCreation = timeOfCreation;
        this.description = null;
        this.numberOfEdits = 0;
        this.timeOfLastEdit = null;
    }

    public Entry() {
    }

    public EntryType getEntryType() {
        return this.entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeOfCreation() {
        return this.timeOfCreation;
    }

    public void setTimeOfCreation(LocalDateTime timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfEdits() {
        return this.numberOfEdits;
    }

    public void setNumberOfEdits(int numberOfEdits) {
        this.numberOfEdits = numberOfEdits;
    }

    public LocalDateTime getTimeOfLastEdit() {
        return this.timeOfLastEdit;
    }

    public void setTimeOfLastEdit(LocalDateTime timeOfLastEdit) {
        this.timeOfLastEdit = timeOfLastEdit;
    }
}
