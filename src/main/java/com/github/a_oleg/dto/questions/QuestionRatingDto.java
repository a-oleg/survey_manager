package com.github.a_oleg.dto.questions;

public class QuestionRatingDto extends AbstractQuestionDto {
    int countOfScaleElements;
    String typeFigure;
    String gradientType;

    public QuestionRatingDto() {
    }

    public QuestionRatingDto(int questionId, int surveyId, int questionNumberInTheSurvey, String typeQuestion,
                             String textQuestion, String descriptionText, String buttonText, int countOfScaleElements,
                             String typeFigure, String gradientType) {
        super(questionId, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.countOfScaleElements = countOfScaleElements;
        this.typeFigure = typeFigure;
        this.gradientType = gradientType;
    }

    public QuestionRatingDto(int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion,
                             String descriptionText, String buttonText, int countOfScaleElements, String typeFigure,
                             String gradientType) {
        super(surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.countOfScaleElements = countOfScaleElements;
        this.typeFigure = typeFigure;
        this.gradientType = gradientType;
    }

    public int getCountOfScaleElements() {
        return countOfScaleElements;
    }

    public void setCountOfScaleElements(int countOfScaleElements) {
        this.countOfScaleElements = countOfScaleElements;
    }

    public String getTypeFigure() {
        return typeFigure;
    }

    public void setTypeFigure(String typeFigure) {
        this.typeFigure = typeFigure;
    }

    public String getGradientType() {
        return gradientType;
    }

    public void setGradientType(String gradientType) {
        this.gradientType = gradientType;
    }
}
