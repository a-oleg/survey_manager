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

    @Column(name = "survey_name")
    String surveyName;

    @Column(name = "folder_id")
    int folderId;

    @Column(name = "status")
    boolean status;

    //ArrayList<String> tags;


    public Survey() {
    }

    public Survey(String creator, String surveyName, int folderId, boolean status) {
        this.creator = creator;
        this.surveyName = surveyName;
        this.folderId = folderId;
        this.status = status;
    }

    public Survey(int id, String creator, String surveyName, int folderId, boolean status) {
        this.id = id;
        this.creator = creator;
        this.surveyName = surveyName;
        this.folderId = folderId;
        this.status = status;
    }
}
