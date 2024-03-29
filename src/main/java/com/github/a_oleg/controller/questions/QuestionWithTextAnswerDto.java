package com.github.a_oleg.controller.questions;

import com.github.a_oleg.entity.subquestion.SubquestionWithTextAnswer;

import java.util.List;

public class QuestionWithTextAnswerDto extends AbstractQuestionDto {
    List<SubquestionWithTextAnswer> subquestionWithTextAnswerAndPrefixPostfixText;
    boolean haveButtonIFindItDifficultToAnswer;

    public QuestionWithTextAnswerDto() {
    }

    public QuestionWithTextAnswerDto(int parentCode, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<SubquestionWithTextAnswer> subquestionWithTextAnswerAndPrefixPostfixText, boolean haveButtonIFindItDifficultToAnswer) {
        super(parentCode, activityStatus, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.subquestionWithTextAnswerAndPrefixPostfixText = subquestionWithTextAnswerAndPrefixPostfixText;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public QuestionWithTextAnswerDto(int questionId, int parentCode, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<SubquestionWithTextAnswer> subquestionWithTextAnswerAndPrefixPostfixText, boolean haveButtonIFindItDifficultToAnswer) {
        super(questionId, parentCode, activityStatus, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.subquestionWithTextAnswerAndPrefixPostfixText = subquestionWithTextAnswerAndPrefixPostfixText;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public List<SubquestionWithTextAnswer> getSubquestionAndPrefixPostfixText() {
        return subquestionWithTextAnswerAndPrefixPostfixText;
    }

    public void setSubquestionAndPrefixPostfixText(List<SubquestionWithTextAnswer> subquestionWithTextAnswerAndPrefixPostfixText) {
        this.subquestionWithTextAnswerAndPrefixPostfixText = subquestionWithTextAnswerAndPrefixPostfixText;
    }

    public boolean isHaveButtonIFindItDifficultToAnswer() {
        return haveButtonIFindItDifficultToAnswer;
    }

    public void setHaveButtonIFindItDifficultToAnswer(boolean haveButtonIFindItDifficultToAnswer) {
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }
}
