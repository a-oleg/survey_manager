package com.github.a_oleg.entity.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.enums.FigureType;
import com.github.a_oleg.enums.GradientType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question_nps")
public class QuestionNPS extends AbstractQuestion {
    @Column(name = "have_button_i_find_it_difficult_to_answer")
    boolean haveButtonIFindItDifficultToAnswer;
    @Column(name = "rating_for_entering_comment")
    int ratingForEnteringComment;
    @Column(name = "text_in_comment_field")
    String textInCommentField;
    @Column(name = "figure_type")
    FigureType figureType;
    @Column(name = "gradient_type")
    GradientType gradientType;

    public QuestionNPS() {
        super();
    }

    public QuestionNPS(Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, boolean haveButtonIFindItDifficultToAnswer, int ratingForEnteringComment, String textInCommentField, FigureType figureType, GradientType gradientType) {
        super(survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
        this.ratingForEnteringComment = ratingForEnteringComment;
        this.textInCommentField = textInCommentField;
        this.figureType = figureType;
        this.gradientType = gradientType;
    }

    public QuestionNPS(int questionId, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, boolean haveButtonIFindItDifficultToAnswer, int ratingForEnteringComment, String textInCommentField, FigureType figureType, GradientType gradientType) {
        super(questionId, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
        this.ratingForEnteringComment = ratingForEnteringComment;
        this.textInCommentField = textInCommentField;
        this.figureType = figureType;
        this.gradientType = gradientType;
    }

    public boolean isHaveButtonIFindItDifficultToAnswer() {
        return haveButtonIFindItDifficultToAnswer;
    }

    public void setHaveButtonIFindItDifficultToAnswer(boolean haveButtonIFindItDifficultToAnswer) {
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public int getRatingForEnteringComment() {
        return ratingForEnteringComment;
    }

    public void setRatingForEnteringComment(int ratingForEnteringComment) {
        this.ratingForEnteringComment = ratingForEnteringComment;
    }

    public String getTextInCommentField() {
        return textInCommentField;
    }

    public void setTextInTheCommentField(String textInTheCommentField) {
        this.textInCommentField = textInCommentField;
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
