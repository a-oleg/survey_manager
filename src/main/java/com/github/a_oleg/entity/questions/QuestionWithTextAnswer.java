package com.github.a_oleg.entity.questions;

import javax.persistence.*;

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

    public QuestionWithTextAnswer(int questionId, int surveyId, int questionNumberInTheSurvey, String typeQuestion,
                                  String textQuestion, String descriptionText, String buttonText, String prefixText,
                                  String postfixText) {
        super(questionId, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.prefixText = prefixText;
        this.postfixText = postfixText;
    }

    public QuestionWithTextAnswer(int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion,
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
