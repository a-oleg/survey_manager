package com.github.a_oleg.entity.question;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.choiceoption.ChoiceTextAnswer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_with_multiple_answers")
public class QuestionWithMultipleAnswers extends AbstractQuestion {
    //Список текстов вариантов ответов, из которых выбирает пользователь
    @OneToMany(mappedBy = "choiceId",cascade = CascadeType.ALL)
    List<ChoiceTextAnswer> listChoiceTextAnswer;
    //Возможность выбрать несколько вариантов в качестве ответа на вопрос
    @Column(name = "multiple_choice_of_answers")
    boolean multipleChoiceOfAnswers;
    //Текст по умолчанию в поле для комментариев пользователя
    @Column(name = "text_in_comment_field")
    String textInCommentField;

    public QuestionWithMultipleAnswers() {
    }

    public QuestionWithMultipleAnswers(int parentId, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<ChoiceTextAnswer> listChoiceTextAnswer, boolean multipleChoiceOfAnswers, String textInCommentField) {
        super(parentId, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.listChoiceTextAnswer = listChoiceTextAnswer;
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
        this.textInCommentField = textInCommentField;
    }

    public QuestionWithMultipleAnswers(int questionId, int parentId, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<ChoiceTextAnswer> listChoiceTextAnswer, boolean multipleChoiceOfAnswers, String textInCommentField) {
        super(questionId, parentId, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.listChoiceTextAnswer = listChoiceTextAnswer;
        this.multipleChoiceOfAnswers = multipleChoiceOfAnswers;
        this.textInCommentField = textInCommentField;
    }

    public List<ChoiceTextAnswer> getListChoiceTextAnswer() {
        return listChoiceTextAnswer;
    }

    public void setListChoiceTextAnswer(List<ChoiceTextAnswer> listChoiceTextAnswer) {
        this.listChoiceTextAnswer = listChoiceTextAnswer;
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
