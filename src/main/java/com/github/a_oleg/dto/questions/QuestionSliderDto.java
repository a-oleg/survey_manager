package com.github.a_oleg.dto.questions;

public class QuestionSliderDto extends AbstractQuestionDto {
    String typeSlider;
    int countOfScaleElements;
    int defaultScaleElementNumber;
    String typeFigure;

    public QuestionSliderDto() {
    }

    public QuestionSliderDto(int questionId, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String typeSlider, int countOfScaleElements, int defaultScaleElementNumber, String typeFigure) {
        super(questionId, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.typeSlider = typeSlider;
        this.countOfScaleElements = countOfScaleElements;
        this.defaultScaleElementNumber = defaultScaleElementNumber;
        this.typeFigure = typeFigure;
    }

    public QuestionSliderDto(int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String typeSlider, int countOfScaleElements, int defaultScaleElementNumber, String typeFigure) {
        super(surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.typeSlider = typeSlider;
        this.countOfScaleElements = countOfScaleElements;
        this.defaultScaleElementNumber = defaultScaleElementNumber;
        this.typeFigure = typeFigure;
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

    public String getTypeFigure() {
        return typeFigure;
    }

    public void setTypeFigure(String typeFigure) {
        this.typeFigure = typeFigure;
    }
}
