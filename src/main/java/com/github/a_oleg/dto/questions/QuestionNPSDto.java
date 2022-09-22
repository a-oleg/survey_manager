package com.github.a_oleg.dto.questions;

import com.github.a_oleg.enums.FigureType;
import com.github.a_oleg.enums.GradientType;

public class QuestionNPSDto extends AbstractQuestionDto {
    boolean haveButtonIFindItDifficultToAnswer;
    String textInTheCommentField;
    FigureType figureType;
    GradientType gradientType;

    public QuestionNPSDto() {
    }

    public QuestionNPSDto(int questionId, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, boolean haveButtonIFindItDifficultToAnswer, String textInTheCommentField, FigureType figureType, GradientType gradientType) {
        super(questionId, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
        this.textInTheCommentField = textInTheCommentField;
        this.figureType = figureType;
        this.gradientType = gradientType;
    }

    public QuestionNPSDto(int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, boolean haveButtonIFindItDifficultToAnswer, String textInTheCommentField, FigureType figureType, GradientType gradientType) {
        super(surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
        this.textInTheCommentField = textInTheCommentField;
        this.figureType = figureType;
        this.gradientType = gradientType;
    }

    public boolean isHaveButtonIFindItDifficultToAnswer() {
        return haveButtonIFindItDifficultToAnswer;
    }

    public void setHaveButtonIFindItDifficultToAnswer(boolean haveButtonIFindItDifficultToAnswer) {
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public String getTextInTheCommentField() {
        return textInTheCommentField;
    }

    public void setTextInTheCommentField(String textInTheCommentField) {
        this.textInTheCommentField = textInTheCommentField;
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
