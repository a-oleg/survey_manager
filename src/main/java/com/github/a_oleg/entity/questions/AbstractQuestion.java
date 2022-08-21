package com.github.a_oleg.entity.questions;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    int questionId;
    @Column(name = "survey_id")
    int surveyId;
    @Column(name = "question_number_in_the_survey")
    int questionNumberInTheSurvey;
    @Column(name = "type_question")
    String typeQuestion;
    @Column(name = "text_question")
    String textQuestion;
    @Column(name = "description_text")
    String descriptionText;
    @Column(name = "button_text")
    String buttonText;

    public AbstractQuestion(int questionId, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText) {
        this.questionId = questionId;
        this.surveyId = surveyId;
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
        this.typeQuestion = typeQuestion;
        this.textQuestion = textQuestion;
        this.descriptionText = descriptionText;
        this.buttonText = buttonText;
    }
    public AbstractQuestion(int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText) {
        this.surveyId = surveyId;
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
        this.typeQuestion = typeQuestion;
        this.textQuestion = textQuestion;
        this.descriptionText = descriptionText;
        this.buttonText = buttonText;
    }

    public AbstractQuestion() {

    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getQuestionNumberInTheSurvey() {
        return questionNumberInTheSurvey;
    }

    public void setQuestionNumberInTheSurvey(int questionNumberInTheSurvey) {
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
    }

    public String getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(String typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
}
