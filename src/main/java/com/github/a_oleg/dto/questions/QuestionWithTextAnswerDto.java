package com.github.a_oleg.dto.questions;

public class QuestionWithTextAnswerDto extends AbstractQuestionDto {
    String prefixText;
    String postfixText;

    public QuestionWithTextAnswerDto() {
    }
    public QuestionWithTextAnswerDto(int surveyId, int folderId, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String prefixText, String postfixText) {
        super(surveyId, folderId, typeQuestion, textQuestion, descriptionText, buttonText);
        this.prefixText = prefixText;
        this.postfixText = postfixText;
    }
    public QuestionWithTextAnswerDto(int folderId, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String prefixText, String postfixText) {
        super(folderId, typeQuestion, textQuestion, descriptionText, buttonText);
        this.prefixText = prefixText;
        this.postfixText = postfixText;
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
