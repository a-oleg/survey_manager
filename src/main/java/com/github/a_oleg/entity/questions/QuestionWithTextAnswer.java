package com.github.a_oleg.entity.questions;

import javax.persistence.Column;

public class QuestionWithTextAnswer extends AbstractQuestion {
    @Column(name = "prefix_text")
    String prefixText;
    @Column(name = "postfix_text")
    String postfixText;

    public QuestionWithTextAnswer(int questionId, int surveyId, int folderId, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String prefixText, String postfixText) {
        super(questionId, surveyId, folderId, typeQuestion, textQuestion, descriptionText, buttonText);
        this.prefixText = prefixText;
        this.postfixText = postfixText;
    }

    public QuestionWithTextAnswer(int surveyId, int folderId, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String prefixText, String postfixText) {
        super(surveyId, folderId, typeQuestion, textQuestion, descriptionText, buttonText);
        this.prefixText = prefixText;
        this.postfixText = postfixText;
    }

    public QuestionWithTextAnswer() {
        super();
    }

    public String getPrefixText() {
        return prefixText;
    }

    public void setPrefixText(String prefixText) {
        this.prefixText = prefixText;
    }

    public String getPostfixText() {
        return postfixText;
    }

    public void setPostfixText(String postfixText) {
        this.postfixText = postfixText;
    }
}
