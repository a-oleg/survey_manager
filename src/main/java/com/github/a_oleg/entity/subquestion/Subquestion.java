package com.github.a_oleg.entity.subquestion;

import com.github.a_oleg.entity.questions.QuestionWithTextAnswer;

import javax.persistence.*;

@Entity
@Table(name = "subquestion")
public class Subquestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subquestion_id")
    int subquestionId;
    @Column(name = "subquestion_text")
    String subquestionText;
    @Column(name = "prefix_text")
    String prefixText;
    @Column(name = "postfix_text")
    String postfixText;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    QuestionWithTextAnswer questionWithTextAnswer;
}
