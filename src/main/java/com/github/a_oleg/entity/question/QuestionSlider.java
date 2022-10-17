package com.github.a_oleg.entity.question;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.enums.FigureType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question_slider")
public class QuestionSlider extends AbstractQuestion {
    //Тип вопроса-слайдера. Принимает значения: числовой или процентный
    @Column(name = "type_slider")
    String typeSlider;
    //Количество элементов шкалы. В случае числового типа, появляются фигуры с подписью: 1, 2, 3 и.т.д.
    //В случае процентного типа, подпись элемента вычисляется как 100/количество элементов. Полученное значение округляется
    @Column(name = "count_of_scale_elements")
    int countOfScaleElements;
    //Элемент шкалы, на котором будет по умолчанию установлен выбор, после загрузки вопроса пользователю
    @Column(name = "default_scale_element_number")
    int defaultScaleElementNumber;
    //Тип фигуры для шкалы оценки
    @Column(name = "figure_type")
    FigureType figureType;

    public QuestionSlider() {
    }

    public QuestionSlider(int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String typeSlider, int countOfScaleElements, int defaultScaleElementNumber, FigureType figureType) {
        super(parentCode, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.typeSlider = typeSlider;
        this.countOfScaleElements = countOfScaleElements;
        this.defaultScaleElementNumber = defaultScaleElementNumber;
        this.figureType = figureType;
    }

    public QuestionSlider(int questionId, int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String typeSlider, int countOfScaleElements, int defaultScaleElementNumber, FigureType figureType) {
        super(questionId, parentCode, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
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
