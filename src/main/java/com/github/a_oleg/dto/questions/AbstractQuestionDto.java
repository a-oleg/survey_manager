package com.github.a_oleg.dto.questions;

import com.github.a_oleg.entity.Survey;

public abstract class AbstractQuestionDto {
    int questionId;
    int parentCode;
    boolean activityStatus;
    Survey survey;
    int questionNumberInTheSurvey;
    int nextQuestionNumberInTheSurvey;
    String typeQuestion;
    String textQuestion;
    String descriptionText;
    String buttonText;

    public AbstractQuestionDto() {
    }

    public AbstractQuestionDto(int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, int nextQuestionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText) {
        this.parentCode = parentCode;
        this.activityStatus = activityStatus;
        this.survey = survey;
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
        this.nextQuestionNumberInTheSurvey = nextQuestionNumberInTheSurvey;
        this.typeQuestion = typeQuestion;
        this.textQuestion = textQuestion;
        this.descriptionText = descriptionText;
        this.buttonText = buttonText;
    }

    public AbstractQuestionDto(int questionId, int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, int nextQuestionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText) {
        this.questionId = questionId;
        this.parentCode = parentCode;
        this.activityStatus = activityStatus;
        this.survey = survey;
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
        this.nextQuestionNumberInTheSurvey = nextQuestionNumberInTheSurvey;
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

    public int getParentCode() {
        return parentCode;
    }

    public void setParentCode(int parentCode) {
        this.parentCode = parentCode;
    }

    public boolean isActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public int getQuestionNumberInTheSurvey() {
        return questionNumberInTheSurvey;
    }

    public void setQuestionNumberInTheSurvey(int questionNumberInTheSurvey) {
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
    }

    public int getNextQuestionNumberInTheSurvey() {
        return nextQuestionNumberInTheSurvey;
    }

    public void setNextQuestionNumberInTheSurvey(int nextQuestionNumberInTheSurvey) {
        this.nextQuestionNumberInTheSurvey = nextQuestionNumberInTheSurvey;
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
