package com.github.a_oleg.dto.questions;

import com.github.a_oleg.entity.Survey;

import java.util.HashMap;

public class QuestionWithTextAnswerDto extends AbstractQuestionDto {
    HashMap<String, String> subquestionAndPrefixPostfixText;
    boolean haveButtonIFindItDifficultToAnswer;

    public QuestionWithTextAnswerDto() {
    }

    public QuestionWithTextAnswerDto(int questionId, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, HashMap<String, String> questionAndPrefixPostfixText, boolean haveButtonIFindItDifficultToAnswer) {
        super(questionId, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.subquestionAndPrefixPostfixText = questionAndPrefixPostfixText;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public QuestionWithTextAnswerDto(Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, HashMap<String, String> questionAndPrefixPostfixText, boolean haveButtonIFindItDifficultToAnswer) {
        super(survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.subquestionAndPrefixPostfixText = questionAndPrefixPostfixText;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public HashMap<String, String> getQuestionAndPrefixPostfixText() {
        return subquestionAndPrefixPostfixText;
    }

    public void setQuestionAndPrefixPostfixText(HashMap<String, String> questionAndPrefixPostfixText) {
        this.subquestionAndPrefixPostfixText = questionAndPrefixPostfixText;
    }

    public boolean isHaveButtonIFindItDifficultToAnswer() {
        return haveButtonIFindItDifficultToAnswer;
    }

    public void setHaveButtonIFindItDifficultToAnswer(boolean haveButtonIFindItDifficultToAnswer) {
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }
}
