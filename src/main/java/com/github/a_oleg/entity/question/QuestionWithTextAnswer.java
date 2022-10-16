package com.github.a_oleg.entity.question;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.subquestion.SubquestionWithTextAnswer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_with_text_answer")
public class QuestionWithTextAnswer extends AbstractQuestion {
    @OneToMany(mappedBy = "questionWithTextAnswer",cascade = CascadeType.ALL)
    List<SubquestionWithTextAnswer> subquestionWithTextAnswerAndPrefixPostfixText;
    @Column(name = "have_button_i_find_it_difficult_to_answer")
    boolean haveButtonIFindItDifficultToAnswer;

    public QuestionWithTextAnswer() {
    }

    public QuestionWithTextAnswer(int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<SubquestionWithTextAnswer> subquestionWithTextAnswerAndPrefixPostfixText, boolean haveButtonIFindItDifficultToAnswer) {
        super(parentCode, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.subquestionWithTextAnswerAndPrefixPostfixText = subquestionWithTextAnswerAndPrefixPostfixText;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public QuestionWithTextAnswer(int questionId, int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<SubquestionWithTextAnswer> subquestionWithTextAnswerAndPrefixPostfixText, boolean haveButtonIFindItDifficultToAnswer) {
        super(questionId, parentCode, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
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
