package com.github.a_oleg.entity.questions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question_rating")
public class QuestionRating extends AbstractQuestion {
    @Column(name = "count_of_scale_elements")
    int countOfScaleElements;
    @Column(name = "type_figure")
    String typeFigure;
    @Column(name = "gradient_type")
    String gradientType;

    public QuestionRating() {
        super();
    }

    public QuestionRating(int questionId, int surveyId, int questionNumberInTheSurvey, String typeQuestion,
                          String textQuestion, String descriptionText, String buttonText, int countOfScaleElements,
                          String typeFigure, String gradientType) {
        super(questionId, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.countOfScaleElements = countOfScaleElements;
        this.typeFigure = typeFigure;
        this.gradientType = gradientType;
    }

    public QuestionRating(int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion,
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
