package com.github.a_oleg.entity.choiceoption;

import com.github.a_oleg.entity.question.QuestionTheChoiceOfMedia;

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
    QuestionTheChoiceOfMedia questionTheChoiceOfMedia;
    @Column(name = "text")
    String text;
}
