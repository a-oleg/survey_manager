package com.github.a_oleg.entity.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.enums.FigureType;

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
    @Column(name = "figure_type")
    FigureType figureType;

    public QuestionSlider() {
        super();
    }

    public QuestionSlider(Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String typeSlider, int countOfScaleElements, int defaultScaleElementNumber, FigureType figureType) {
        super(survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.typeSlider = typeSlider;
        this.countOfScaleElements = countOfScaleElements;
        this.defaultScaleElementNumber = defaultScaleElementNumber;
        this.figureType = figureType;
    }

    public QuestionSlider(int questionId, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String typeSlider, int countOfScaleElements, int defaultScaleElementNumber, FigureType figureType) {
        super(questionId, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
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
