package com.github.a_oleg.controller.questions;

public abstract class AbstractQuestionDto {
    int questionId;
    int parentId;
    boolean activityStatus;
    int surveyId;
    int questionNumberInTheSurvey;
    String typeQuestion;
    String textQuestion;
    String descriptionText;
    String buttonText;

    public AbstractQuestionDto() {
    }

    public AbstractQuestionDto(int parentId, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText) {
        this.parentId = parentId;
        this.activityStatus = activityStatus;
        this.surveyId = surveyId;
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
        this.typeQuestion = typeQuestion;
        this.textQuestion = textQuestion;
        this.descriptionText = descriptionText;
        this.buttonText = buttonText;
    }

    public AbstractQuestionDto(int questionId, int parentId, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText) {
        this.questionId = questionId;
        this.parentId = parentId;
        this.activityStatus = activityStatus;
        this.surveyId = surveyId;
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
        this.typeQuestion = typeQuestion;
        this.textQuestion = textQuestion;
        this.descriptionText = descriptionText;
        this.buttonText = buttonText;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public boolean isActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getQuestionNumberInTheSurvey() {
        return questionNumberInTheSurvey;
    }

    public void setQuestionNumberInTheSurvey(int questionNumberInTheSurvey) {
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
    }

    public String getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(String typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
}
