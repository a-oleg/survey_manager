package com.github.a_oleg.entity;

import javax.persistence.*;

@Entity
@Table(name = "surveys")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    int surveyId;

    @Column(name = "creator")
    String creator;

    //@ManyToMany
    //ArrayList<Integer> observers;

    @Column(name = "survey_name")
    String surveyName;

    @Column(name = "folder_id")
    int folderId;

    @Column(name = "activity_status")
    boolean activityStatus;

    //ArrayList<String> tags;


    public Survey() {
    }

    public Survey(String creator, String surveyName, int folderId, boolean status) {
        this.creator = creator;
        this.surveyName = surveyName;
        this.folderId = folderId;
        this.activityStatus = status;
    }

    public Survey(int surveyId, String creator, String surveyName, int folderId, boolean status) {
        this.surveyId = surveyId;
        this.creator = creator;
        this.surveyName = surveyName;
        this.folderId = folderId;
        this.activityStatus = status;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public boolean getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(boolean status) {
        this.activityStatus = status;
    }
}
