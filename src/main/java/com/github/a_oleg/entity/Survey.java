package com.github.a_oleg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @Column(name = "id")
    int id;

    @Column(name = "creator")
    String creator;

    //Какой Column ставить сюда?
    ArrayList<String> observers;

    @Column(name = "surveyName")
    String surveyName;

    @Column(name = "folder")
    String folder;

    //Какой Column ставить сюда?
    ArrayList<String> tags;


    public Survey() {
    }

    public Survey(int id, String creator, String observers, String surveyName, String folder, ArrayList<String> tags) {
        this.id = id;
        this.creator = creator;
        this.observers = observers;
        this.surveyName = surveyName;
        this.folder = folder;
        this.tags = tags;
    }
}
