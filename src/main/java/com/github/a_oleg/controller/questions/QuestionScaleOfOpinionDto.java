package com.github.a_oleg.controller.questions;

import com.github.a_oleg.enums.FigureType;
import com.github.a_oleg.enums.GradientType;

import java.util.ArrayList;

public class QuestionScaleOfOpinionDto extends AbstractQuestionDto {
    ArrayList<String> descriptionOfAssessment;
    boolean haveButtonIFindItDifficultToAnswer;
    int ratingForEnteringComment;
    String textInTheCommentField;
    FigureType figureType;
    GradientType gradientType;

    public QuestionScaleOfOpinionDto() {
    }

    public QuestionScaleOfOpinionDto(int parentCode, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, ArrayList<String> descriptionOfAssessment, boolean haveButtonIFindItDifficultToAnswer, int ratingForEnteringComment, String textInTheCommentField, FigureType figureType, GradientType gradientType) {
        super(parentCode, activityStatus, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.descriptionOfAssessment = descriptionOfAssessment;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
        this.ratingForEnteringComment = ratingForEnteringComment;
        this.textInTheCommentField = textInTheCommentField;
        this.figureType = figureType;
        this.gradientType = gradientType;
    }

    public QuestionScaleOfOpinionDto(int questionId, int parentCode, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, ArrayList<String> descriptionOfAssessment, boolean haveButtonIFindItDifficultToAnswer, int ratingForEnteringComment, String textInTheCommentField, FigureType figureType, GradientType gradientType) {
        super(questionId, parentCode, activityStatus, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.descriptionOfAssessment = descriptionOfAssessment;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
        this.ratingForEnteringComment = ratingForEnteringComment;
        this.textInTheCommentField = textInTheCommentField;
        this.figureType = figureType;
        this.gradientType = gradientType;
    }

    public ArrayList<String> getDescriptionOfAssessment() {
        return descriptionOfAssessment;
    }

    public void setDescriptionOfAssessment(ArrayList<String> descriptionOfAssessment) {
        this.descriptionOfAssessment = descriptionOfAssessment;
    }

    public boolean isHaveButtonIFindItDifficultToAnswer() {
        return haveButtonIFindItDifficultToAnswer;
    }

    public void setHaveButtonIFindItDifficultToAnswer(boolean haveButtonIFindItDifficultToAnswer) {
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public int getRatingForEnteringComment() {
        return ratingForEnteringComment;
    }

    public void setRatingForEnteringComment(int ratingForEnteringComment) {
        this.ratingForEnteringComment = ratingForEnteringComment;
    }

    public String getTextInTheCommentField() {
        return textInTheCommentField;
    }

    public void setTextInTheCommentField(String textInTheCommentField) {
        this.textInTheCommentField = textInTheCommentField;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    public GradientType getGradientType() {
        return gradientType;
    }

    public void setGradientType(GradientType gradientType) {
        this.gradientType = gradientType;
    }
}
