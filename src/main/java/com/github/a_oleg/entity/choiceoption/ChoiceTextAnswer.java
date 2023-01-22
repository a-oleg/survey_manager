package com.github.a_oleg.entity.choiceoption;

import com.github.a_oleg.entity.question.QuestionWithMultipleAnswers;

import javax.persistence.*;

@Entity
@Table(name = "choice_text_answer")
public class ChoiceTextAnswer {
    //ID выбора текстового варианта ответа
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    int choiceId;
    //Текст варианта ответа
    @Column(name = "text_answer")
    String textAnswer;
    //ID вопроса с текстовым вариантом ответа
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    QuestionWithMultipleAnswers questionWithMultipleAnswers;
}
