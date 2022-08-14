package com.github.a_oleg.entity.questions;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class AbstractQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    int questionId;
    @Column(name = "survey_id")
    int surveyId;
    @Column(name = "folder_id")
    int folderId;
    @Column(name = "type_question")
    String typeQuestion;
    @Column(name = "text_question")
    String textQuestion;
    @Column(name = "description_text")
    String descriptionText;
    @Column(name = "button_text")
    String buttonText;

    public AbstractQuestion(int questionId, int surveyId, int folderId, String typeQuestion, String textQuestion, String descriptionText, String buttonText) {
        this.questionId = questionId;
        this.surveyId = surveyId;
        this.folderId = folderId;
        this.typeQuestion = typeQuestion;
        this.textQuestion = textQuestion;
        this.descriptionText = descriptionText;
        this.buttonText = buttonText;
    }

    public AbstractQuestion(int surveyId, int folderId, String typeQuestion, String textQuestion, String descriptionText, String buttonText) {
        this.surveyId = surveyId;
        this.folderId = folderId;
        this.typeQuestion = typeQuestion;
        this.textQuestion = textQuestion;
        this.descriptionText = descriptionText;
        this.buttonText = buttonText;
    }
}
