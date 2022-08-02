package com.github.a_oleg.dto;

public class SurveyDto {
    int id;
    String creator;
    String surveyName;
    int folderId;
    boolean activityStatus;


    public SurveyDto() {

    }

    public SurveyDto(String creator, String surveyName, int folderId, boolean activityStatus) {
        this.creator = creator;
        this.surveyName = surveyName;
        this.folderId = folderId;
        this.activityStatus = activityStatus;
    }

    public SurveyDto(int id, String creator, String surveyName, int folderId, boolean activityStatus) {
        this.id = id;
        this.creator = creator;
        this.surveyName = surveyName;
        this.folderId = folderId;
        this.activityStatus = activityStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(boolean activityStatus) {
        this.activityStatus = activityStatus;
    }
}
