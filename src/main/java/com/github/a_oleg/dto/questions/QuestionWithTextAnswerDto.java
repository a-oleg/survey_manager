package com.github.a_oleg.dto.questions;

public class QuestionWithTextAnswerDto extends AbstractQuestionDto {
    String prefixText;
    String postfixText;

    public QuestionWithTextAnswerDto() {
    }

    public QuestionWithTextAnswerDto(int questionId, int surveyId, int questionNumberInTheSurvey, String typeQuestion,
                                     String textQuestion, String descriptionText, String buttonText, String prefixText,
                                     String postfixText) {
        super(questionId, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.prefixText = prefixText;
        this.postfixText = postfixText;
    }

    public QuestionWithTextAnswerDto(int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion,
                                     String descriptionText, String buttonText, String prefixText, String postfixText) {
        super(surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
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
