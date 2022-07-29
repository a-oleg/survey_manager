package com.github.a_oleg.entity;

import javax.persistence.*;

@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @Column(name = "id")
    int id;

    @Column(name = "creator")
    String creator;

    //@ManyToMany
    //ArrayList<Integer> observers;

    @Column(name = "surveyName")
    String surveyName;

    @Column(name = "folder_id")
    int folderId;

    //ArrayList<String> tags;


    public Survey() {
    }

    public Survey(int id, String creator, String surveyName, int folderId) {
        this.id = id;
        this.creator = creator;
        this.surveyName = surveyName;
        this.folderId = folderId;
    }
}
