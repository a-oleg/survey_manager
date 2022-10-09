package com.github.a_oleg.dto.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.subquestion.Subquestion;

import java.util.List;

public class QuestionWithTextAnswerDto extends AbstractQuestionDto {
    List<Subquestion> subquestionAndPrefixPostfixText;
    boolean haveButtonIFindItDifficultToAnswer;

    public QuestionWithTextAnswerDto() {

    }

    public QuestionWithTextAnswerDto(int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, int nextQuestionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<Subquestion> subquestionAndPrefixPostfixText, boolean haveButtonIFindItDifficultToAnswer) {
        super(parentCode, activityStatus, survey, questionNumberInTheSurvey, nextQuestionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.subquestionAndPrefixPostfixText = subquestionAndPrefixPostfixText;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public QuestionWithTextAnswerDto(int questionId, int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, int nextQuestionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<Subquestion> subquestionAndPrefixPostfixText, boolean haveButtonIFindItDifficultToAnswer) {
        super(questionId, parentCode, activityStatus, survey, questionNumberInTheSurvey, nextQuestionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.subquestionAndPrefixPostfixText = subquestionAndPrefixPostfixText;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public List<Subquestion> getSubquestionAndPrefixPostfixText() {
        return subquestionAndPrefixPostfixText;
    }

    public void setSubquestionAndPrefixPostfixText(List<Subquestion> subquestionAndPrefixPostfixText) {
        this.subquestionAndPrefixPostfixText = subquestionAndPrefixPostfixText;
    }

    public boolean isHaveButtonIFindItDifficultToAnswer() {
        return haveButtonIFindItDifficultToAnswer;
    }

    public void setHaveButtonIFindItDifficultToAnswer(boolean haveButtonIFindItDifficultToAnswer) {
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }
}
