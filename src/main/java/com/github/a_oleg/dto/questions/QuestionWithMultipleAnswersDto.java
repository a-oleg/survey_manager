package com.github.a_oleg.dto.questions;

import com.github.a_oleg.entity.Survey;

import java.util.ArrayList;

public class QuestionWithMultipleAnswersDto extends AbstractQuestionDto {
    ArrayList<String> answerOptions = new ArrayList<>();
    boolean multipleChoiceOfAnswers;
    String textInCommentField;


    public QuestionWithMultipleAnswersDto() {
    }

    public QuestionWithMultipleAnswersDto(ArrayList<String> answerOptions, boolean multipleChoiceOfAnswers, String textInCommentField) {
        this.answerOptions = answerOptions;
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
        this.textInCommentField = textInCommentField;
    }

    public QuestionWithMultipleAnswersDto(int parentId, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, ArrayList<String> answerOptions, boolean multipleChoiceOfAnswers, String textInCommentField) {
        super(parentId, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.answerOptions = answerOptions;
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
        this.textInCommentField = textInCommentField;
    }

    public QuestionWithMultipleAnswersDto(int questionId, int parentId, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, ArrayList<String> answerOptions, boolean multipleChoiceOfAnswers, String textInCommentField) {
        super(questionId, parentId, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.answerOptions = answerOptions;
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
        this.textInCommentField = textInCommentField;
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

    public String getTextInCommentField() {
        return textInCommentField;
    }

    public void setTextInCommentField(String textInCommentField) {
        this.textInCommentField = textInCommentField;
    }
}
