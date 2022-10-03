package com.github.a_oleg.entity.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.choiceoption.ChoiceSubquestion;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_with_text_answer")
public class QuestionWithTextAnswer extends AbstractQuestion {
    @OneToMany(mappedBy = "questionWithTextAnswer",cascade = CascadeType.ALL)
    List<ChoiceSubquestion> listChoiceSubquestion;
    @Column(name = "have_button_i_find_it_difficult_to_answer")
    boolean haveButtonIFindItDifficultToAnswer;

    public QuestionWithTextAnswer() {
        super();
    }

    public QuestionWithTextAnswer(Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<ChoiceSubquestion> listChoiceSubquestion, boolean haveButtonIFindItDifficultToAnswer) {
        super(survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.listChoiceSubquestion = listChoiceSubquestion;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public QuestionWithTextAnswer(int questionId, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<ChoiceSubquestion> listChoiceSubquestion, boolean haveButtonIFindItDifficultToAnswer) {
        super(questionId, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.listChoiceSubquestion = listChoiceSubquestion;
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }

    public List<ChoiceSubquestion> getListChoiceSubquestion() {
        return listChoiceSubquestion;
    }

    public void setListChoiceSubquestion(List<ChoiceSubquestion> listChoiceSubquestion) {
        this.listChoiceSubquestion = listChoiceSubquestion;
    }

    public boolean isHaveButtonIFindItDifficultToAnswer() {
        return haveButtonIFindItDifficultToAnswer;
    }

    public void setHaveButtonIFindItDifficultToAnswer(boolean haveButtonIFindItDifficultToAnswer) {
        this.haveButtonIFindItDifficultToAnswer = haveButtonIFindItDifficultToAnswer;
    }
}
