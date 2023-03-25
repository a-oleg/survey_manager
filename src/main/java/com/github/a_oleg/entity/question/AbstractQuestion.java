package com.github.a_oleg.entity.question;

import com.github.a_oleg.entity.Survey;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractQuestion {
    //ID вопроса
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    int questionId;
    //ID вопроса, который был создан первоначально, до редактирования. Первоначальной версии вопроса присваивается значение -1
    @Column(name = "parent_id")
    int parentId;
    //Статус активности
    @Column(name = "activity_status")
    boolean activityStatus;
    //ID опроса
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "survey_id")
    Survey survey;
    //Номер вопроса в опросе
    @Column(name = "question_number_in_the_survey")
    int questionNumberInTheSurvey;
    //Тип вопроса: NPS, CSI, с вариантами ответов и пр.
    @Column(name = "type_question")
    String typeQuestion;
    //Текст вопроса
    @Column(name = "text_question")
    String textQuestion;
    //Текст описания вопроса
    @Column(name = "description_text")
    String descriptionText;
    //Текст кнопки перехода к следующему вопросу
    @Column(name = "button_text")
    String buttonText;

    public AbstractQuestion() {
    }

    public AbstractQuestion(int parentId, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText) {
        this.parentId = parentId;
        this.activityStatus = activityStatus;
        this.survey = survey;
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
        this.typeQuestion = typeQuestion;
        this.textQuestion = textQuestion;
        this.descriptionText = descriptionText;
        this.buttonText = buttonText;
    }

    public AbstractQuestion(int questionId, int parentId, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText) {
        this.questionId = questionId;
        this.parentId = parentId;
        this.activityStatus = activityStatus;
        this.survey = survey;
        this.questionNumberInTheSurvey = questionNumberInTheSurvey;
        this.typeQuestion = typeQuestion;
        this.textQuestion = textQuestion;
        this.descriptionText = descriptionText;
        this.buttonText = buttonText;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public boolean isActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
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
