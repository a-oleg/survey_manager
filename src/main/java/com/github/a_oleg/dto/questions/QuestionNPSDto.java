package com.github.a_oleg.dto.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.enums.FigureType;
import com.github.a_oleg.enums.GradientType;

public class QuestionNPSDto extends AbstractQuestionDto {
    boolean haveButtonIFindItDifficultToAnswer;
    int ratingForEnteringComment;
    String textInCommentField;
    FigureType figureType;
    GradientType gradientType;

    public QuestionNPSDto() {
    }

    public QuestionNPSDto(int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, int nextQuestionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, boolean haveButtonIFindItDifficultToAnswer, int ratingForEnteringComment, String textInCommentField, FigureType figureType, GradientType gradientType) {
        super(parentCode, activityStatus, survey, questionNumberInTheSurvey, nextQuestionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
        this.ratingForEnteringComment = ratingForEnteringComment;
        this.textInCommentField = textInCommentField;
        this.figureType = figureType;
        this.gradientType = gradientType;
    }

    public QuestionNPSDto(int questionId, int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, int nextQuestionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, boolean haveButtonIFindItDifficultToAnswer, int ratingForEnteringComment, String textInCommentField, FigureType figureType, GradientType gradientType) {
        super(questionId, parentCode, activityStatus, survey, questionNumberInTheSurvey, nextQuestionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
        this.ratingForEnteringComment = ratingForEnteringComment;
        this.textInCommentField = textInCommentField;
        this.figureType = figureType;
        this.gradientType = gradientType;
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

    public String getTextInCommentField() {
        return textInCommentField;
    }

    public void setTextInCommentField(String textInCommentField) {
        this.textInCommentField = textInCommentField;
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
