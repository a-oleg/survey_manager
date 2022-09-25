package com.github.a_oleg.dto.questions;

import java.util.ArrayList;

public class QuestionWithMultipleAnswersDto extends AbstractQuestionDto {
    ArrayList<String> answerOptions = new ArrayList<>();
    boolean multipleChoiceOfAnswers;

    public QuestionWithMultipleAnswersDto(int questionId, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, ArrayList<String> answerOptions, boolean multipleChoiceOfAnswers) {
        super(questionId, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.answerOptions = answerOptions;
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
    }

    public QuestionWithMultipleAnswersDto(int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, ArrayList<String> answerOptions, boolean multipleChoiceOfAnswers) {
        super(surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.answerOptions = answerOptions;
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
    }

    public ArrayList<String> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(ArrayList<String> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public boolean isMultipleChoiceOfAnswers() {
        return multipleChoiceOfAnswers;
    }

    public void setMultipleChoiceOfAnswers(boolean multipleChoiceOfAnswers) {
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
    }

    public QuestionWithMultipleAnswersDto() {
    }
}