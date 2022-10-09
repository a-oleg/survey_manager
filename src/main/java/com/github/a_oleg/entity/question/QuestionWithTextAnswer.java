package com.github.a_oleg.entity.question;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.subquestion.Subquestion;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_with_text_answer")
public class QuestionWithTextAnswer extends AbstractQuestion {
    @OneToMany(mappedBy = "questionWithTextAnswer",cascade = CascadeType.ALL)
    List<Subquestion> subquestionAndPrefixPostfixText;
    @Column(name = "have_button_i_find_it_difficult_to_answer")
    boolean haveButtonIFindItDifficultToAnswer;

    public QuestionWithTextAnswer() {

    }

    public QuestionWithTextAnswer(int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, int nextQuestionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<Subquestion> subquestionAndPrefixPostfixText, boolean haveButtonIFindItDifficultToAnswer) {
        super(parentCode, activityStatus, survey, questionNumberInTheSurvey, nextQuestionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.subquestionAndPrefixPostfixText = subquestionAndPrefixPostfixText;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public QuestionWithTextAnswer(int questionId, int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, int nextQuestionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<Subquestion> subquestionAndPrefixPostfixText, boolean haveButtonIFindItDifficultToAnswer) {
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
