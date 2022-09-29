package com.github.a_oleg.entity.questions;

import com.github.a_oleg.entity.Survey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question_with_text_answer")
public class QuestionWithTextAnswer extends AbstractQuestion {
    @Column(name = "prefix_text")
    String prefixText;
    @Column(name = "postfix_text")
    String postfixText;

    public QuestionWithTextAnswer() {
        super();
    }

    public QuestionWithTextAnswer(Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String prefixText, String postfixText) {
        super(survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.prefixText = prefixText;
        this.postfixText = postfixText;
    }

    public QuestionWithTextAnswer(int questionId, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String prefixText, String postfixText) {
        super(questionId, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
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
