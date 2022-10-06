package com.github.a_oleg.entity.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.subquestion.Subquestion;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_with_text_answer")
public class QuestionWithTextAnswer extends AbstractQuestion {
    @OneToMany(mappedBy = "questionWithTextAnswer",cascade = CascadeType.ALL)
    List<Subquestion> listSubquestion;
    @Column(name = "have_button_i_find_it_difficult_to_answer")
    boolean haveButtonIFindItDifficultToAnswer;

    public QuestionWithTextAnswer() {
        super();
    }

    public QuestionWithTextAnswer(Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<Subquestion> listSubquestion, boolean haveButtonIFindItDifficultToAnswer) {
        super(survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.listSubquestion = listSubquestion;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public QuestionWithTextAnswer(int questionId, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<Subquestion> listSubquestion, boolean haveButtonIFindItDifficultToAnswer) {
        super(questionId, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.listSubquestion = listSubquestion;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public List<Subquestion> getListChoiceSubquestion() {
        return listSubquestion;
    }

    public void setListChoiceSubquestion(List<Subquestion> listSubquestion) {
        this.listSubquestion = listSubquestion;
    }

    public boolean isHaveButtonIFindItDifficultToAnswer() {
        return haveButtonIFindItDifficultToAnswer;
    }

    public void setHaveButtonIFindItDifficultToAnswer(boolean haveButtonIFindItDifficultToAnswer) {
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }
}
