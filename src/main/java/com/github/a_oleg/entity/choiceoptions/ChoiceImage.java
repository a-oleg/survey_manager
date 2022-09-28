package com.github.a_oleg.entity.choiceoptions;

import com.github.a_oleg.entity.questions.AbstractQuestion;

import javax.persistence.*;

@Entity
@Table(name = "choice_image")
public class ChoiceImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    int choiceId;
    @Lob
    @Column(name = "image")
    byte[] image;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    AbstractQuestion question;
    @Column(name = "text")
    String text;
}
