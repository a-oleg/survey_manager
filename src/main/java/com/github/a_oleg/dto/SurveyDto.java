package com.github.a_oleg.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.a_oleg.controller.questions.AbstractQuestionDto;
import com.github.a_oleg.controller.questions.QuestionNPSDto;
import com.github.a_oleg.controller.questions.QuestionScaleOfOpinionDto;
import com.github.a_oleg.controller.questions.QuestionSliderDto;
import com.github.a_oleg.controller.questions.QuestionWithTextAnswerDto;

import java.util.Set;

public class SurveyDto {
    int surveyId;
    String creator;
    String surveyName;
    int folderId;
    boolean activityStatus;
    Set<QuestionNPSDto> setQuestionsNPSDto;
    Set<QuestionScaleOfOpinionDto> setQuestionsScaleOfOpinionDto;
    Set<QuestionSliderDto> setQuestionsSliderDto;
    Set<QuestionWithTextAnswerDto> setQuestionsWithTextAnswerDto;

    //Удалять listOfQuestions
    Set<? extends AbstractQuestionDto> listOfQuestions;

    public SurveyDto() {

    }

    public SurveyDto(String creator, String surveyName, int folderId, boolean activityStatus) {
        this.creator = creator;
        this.surveyName = surveyName;
        this.folderId = folderId;
        this.activityStatus = activityStatus;
    }

    public SurveyDto(int surveyId, String creator, String surveyName, int folderId, boolean activityStatus) {
        this.surveyId = surveyId;
        this.creator = creator;
        this.surveyName = surveyName;
        this.folderId = folderId;
        this.activityStatus = activityStatus;
    }

    public SurveyDto(int surveyId, String creator, String surveyName, int folderId, boolean activityStatus,
                         Set<? extends AbstractQuestionDto> listOfQuestionsDto) {
        this.surveyId = surveyId;
        this.creator = creator;
        this.surveyName = surveyName;
        this.folderId = folderId;
        this.activityStatus = activityStatus;
        this.listOfQuestions = listOfQuestionsDto;
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

    public void setActivityStatus(boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Set<QuestionWithTextAnswerDto> getSetQuestionsWithTextAnswerDto() {
        return setQuestionsWithTextAnswerDto;
    }

    public void setSetQuestionsWithTextAnswerDto(Set<QuestionWithTextAnswerDto> setQuestionsWithTextAnswerDto) {
        this.setQuestionsWithTextAnswerDto = setQuestionsWithTextAnswerDto;
    }

    public Set<QuestionNPSDto> getSetQuestionsNPSDto() {
        return setQuestionsNPSDto;
    }

    public void setSetQuestionsNPSDto(Set<QuestionNPSDto> setQuestionsNPSDto) {
        this.setQuestionsNPSDto = setQuestionsNPSDto;
    }

    public Set<QuestionScaleOfOpinionDto> getSetQuestionsScaleOfOpinionDto() {
        return setQuestionsScaleOfOpinionDto;
    }

    public void setSetQuestionsScaleOfOpinionDto(Set<QuestionScaleOfOpinionDto> setQuestionsScaleOfOpinionDto) {
        this.setQuestionsScaleOfOpinionDto = setQuestionsScaleOfOpinionDto;
    }

    public Set<QuestionSliderDto> getSetQuestionsSliderDto() {
        return setQuestionsSliderDto;
    }

    public void setSetQuestionsSliderDto(Set<QuestionSliderDto> setQuestionsSliderDto) {
        this.setQuestionsSliderDto = setQuestionsSliderDto;
    }
}
