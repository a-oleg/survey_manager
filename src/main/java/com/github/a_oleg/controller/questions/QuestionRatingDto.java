package com.github.a_oleg.controller.questions;

import com.github.a_oleg.enums.FigureType;
import com.github.a_oleg.enums.GradientType;

public class QuestionRatingDto extends AbstractQuestionDto {
    int countOfScaleElements;
    FigureType figureType;
    GradientType gradientType;

    public QuestionRatingDto() {
    }

    public QuestionRatingDto(int parentCode, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, int countOfScaleElements, FigureType figureType, GradientType gradientType) {
        super(parentCode, activityStatus, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.countOfScaleElements = countOfScaleElements;
        this.figureType = figureType;
        this.gradientType = gradientType;
    }

    public QuestionRatingDto(int questionId, int parentCode, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, int countOfScaleElements, FigureType figureType, GradientType gradientType) {
        super(questionId, parentCode, activityStatus, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.countOfScaleElements = countOfScaleElements;
        this.figureType = figureType;
        this.gradientType = gradientType;
    }

    public int getCountOfScaleElements() {
        return countOfScaleElements;
    }

    public void setCountOfScaleElements(int countOfScaleElements) {
        this.countOfScaleElements = countOfScaleElements;
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
