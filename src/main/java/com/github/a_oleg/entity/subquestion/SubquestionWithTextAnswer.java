package com.github.a_oleg.entity.subquestion;

import com.github.a_oleg.entity.question.QuestionWithTextAnswer;

import javax.persistence.*;

@Entity
@Table(name = "subquestion_with_text_answer")
public class SubquestionWithTextAnswer {
    //ID подвопроса
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subquestion_id")
    int subquestionId;
    //Текст подвопроса
    @Column(name = "subquestion_text")
    String subquestionText;
    //Префикс ответа (при наличии)
    @Column(name = "prefix_text")
    String prefixText;
    //Постфикс ответа (при наличии)
    @Column(name = "postfix_text")
    String postfixText;
    //ID основного вопроса (с текстовым ответом)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    QuestionWithTextAnswer questionWithTextAnswer;
}
