package com.github.a_oleg.controller.questions;

import com.github.a_oleg.enums.FigureType;

public class QuestionSliderDto extends AbstractQuestionDto {
    String typeSlider;
    int countOfScaleElements;
    int defaultScaleElementNumber;
    FigureType figureType;

    public QuestionSliderDto() {
    }

    public QuestionSliderDto(int parentCode, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String typeSlider, int countOfScaleElements, int defaultScaleElementNumber, FigureType figureType) {
        super(parentCode, activityStatus, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.typeSlider = typeSlider;
        this.countOfScaleElements = countOfScaleElements;
        this.defaultScaleElementNumber = defaultScaleElementNumber;
        this.figureType = figureType;
    }

    public QuestionSliderDto(int questionId, int parentCode, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String typeSlider, int countOfScaleElements, int defaultScaleElementNumber, FigureType figureType) {
        super(questionId, parentCode, activityStatus, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.typeSlider = typeSlider;
        this.countOfScaleElements = countOfScaleElements;
        this.defaultScaleElementNumber = defaultScaleElementNumber;
        this.figureType = figureType;
    }

    public String getTypeSlider() {
        return typeSlider;
    }

    public void setTypeSlider(String typeSlider) {
        this.typeSlider = typeSlider;
    }

    public int getCountOfScaleElements() {
        return countOfScaleElements;
    }

    public void setCountOfScaleElements(int countOfScaleElements) {
        this.countOfScaleElements = countOfScaleElements;
    }

    public int getDefaultScaleElementNumber() {
        return defaultScaleElementNumber;
    }

    public void setDefaultScaleElementNumber(int defaultScaleElementNumber) {
        this.defaultScaleElementNumber = defaultScaleElementNumber;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }
}
