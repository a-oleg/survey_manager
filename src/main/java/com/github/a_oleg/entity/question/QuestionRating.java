package com.github.a_oleg.entity.question;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.enums.FigureType;
import com.github.a_oleg.enums.GradientType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question_rating")
public class QuestionRating extends AbstractQuestion {
    //Количество элементов шкалы
    @Column(name = "count_of_scale_elements")
    int countOfScaleElements;
    //Тип фигуры для шкалы оценки
    @Column(name = "figure_type")
    FigureType figureType;
    //Тип градиента шкалы оценки
    @Column(name = "gradient_type")
    GradientType gradientType;

    public QuestionRating() {
    }

    public QuestionRating(int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, int countOfScaleElements, FigureType figureType, GradientType gradientType) {
        super(parentCode, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.countOfScaleElements = countOfScaleElements;
        this.figureType = figureType;
        this.gradientType = gradientType;
    }

    public QuestionRating(int questionId, int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, int countOfScaleElements, FigureType figureType, GradientType gradientType) {
        super(questionId, parentCode, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
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
