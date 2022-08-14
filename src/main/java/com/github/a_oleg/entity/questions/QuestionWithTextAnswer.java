package com.github.a_oleg.entity.questions;

import javax.persistence.Column;

public class QuestionWithTextAnswer extends AbstractQuestion {
    @Column(name = "response_prefix_text")
    String responsePrefixText;
    @Column(name = "response_postfix_text")
    String responsePostfixText;

    public QuestionWithTextAnswer(int questionId, int surveyId, int folderId, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String responsePrefixText, String responsePostfixText) {
        super(questionId, surveyId, folderId, typeQuestion, textQuestion, descriptionText, buttonText);
        this.responsePrefixText = responsePrefixText;
        this.responsePostfixText = responsePostfixText;
    }

    public QuestionWithTextAnswer(int surveyId, int folderId, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String responsePrefixText, String responsePostfixText) {
        super(surveyId, folderId, typeQuestion, textQuestion, descriptionText, buttonText);
        this.responsePrefixText = responsePrefixText;
        this.responsePostfixText = responsePostfixText;
    }
}
