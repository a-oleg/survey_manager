package com.github.a_oleg.entity.questions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question_slider")
public class QuestionSlider extends AbstractQuestion {
    @Column(name = "type_slider")
    String typeSlider;
    @Column(name = "count_of_scale_elements")
    int countOfScaleElements;
    @Column(name = "default_scale_element_number")
    int defaultScaleElementNumber;
    @Column(name = "type_figure")
    String typeFigure;

    public QuestionSlider() {
        super();
    }

    public QuestionSlider(int questionId, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String typeSlider, int countOfScaleElements, int defaultScaleElementNumber, String typeFigure) {
        super(questionId, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.typeSlider = typeSlider;
        this.countOfScaleElements = countOfScaleElements;
        this.defaultScaleElementNumber = defaultScaleElementNumber;
        this.typeFigure = typeFigure;
    }

    public QuestionSlider(int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String typeSlider, int countOfScaleElements, int defaultScaleElementNumber, String typeFigure) {
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
