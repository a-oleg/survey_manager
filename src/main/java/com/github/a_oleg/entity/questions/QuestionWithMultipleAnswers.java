package com.github.a_oleg.entity.questions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question_with_multiple_answers")
public class QuestionWithMultipleAnswers extends AbstractQuestion {
    @Column(name = "answer_options")
    String answerOptions;
    @Column(name = "multiple_choice_of_answers")
    boolean multipleChoiceOfAnswers;

    public QuestionWithMultipleAnswers() {
    }

    public QuestionWithMultipleAnswers(int questionId, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String answerOptions, boolean multipleChoiceOfAnswers) {
        super(questionId, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.answerOptions = answerOptions;
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
    }

    public QuestionWithMultipleAnswers(int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, String answerOptions, boolean multipleChoiceOfAnswers) {
        super(surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.answerOptions = answerOptions;
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
    }

    public String getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(String answerOptions) {
        this.answerOptions = answerOptions;
    }

    public boolean isMultipleChoiceOfAnswers() {
        return multipleChoiceOfAnswers;
    }

    public void setMultipleChoiceOfAnswers(boolean multipleChoiceOfAnswers) {
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
    }
}
