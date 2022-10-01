package com.github.a_oleg.dto.questions;

import com.github.a_oleg.entity.Survey;

public class QuestionWithTextAnswerDto extends AbstractQuestionDto {
    String prefixText;
    String postfixText;

    public QuestionWithTextAnswerDto() {
    }

    public QuestionWithTextAnswerDto(int questionId, Survey survey, int questionNumberInTheSurvey, String typeQuestion,
                                     String textQuestion, String descriptionText, String buttonText, String prefixText,
                                     String postfixText) {
        super(questionId, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.prefixText = prefixText;
        this.postfixText = postfixText;
    }

    public QuestionWithTextAnswerDto(Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion,
                                     String descriptionText, String buttonText, String prefixText, String postfixText) {
        super(survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
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
