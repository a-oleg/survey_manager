package com.github.a_oleg.entity.choiceoption;

import com.github.a_oleg.entity.question.QuestionTheChoiceOfMedia;

import javax.persistence.*;

@Entity
@Table(name = "choice_image")
public class ChoiceImage {
    //ID выбора изображения
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    int choiceId;
    //Картинка
    @Lob
    @Column(name = "image")
    byte[] image;
    //ID вопроса-выбора медиа
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    QuestionTheChoiceOfMedia questionTheChoiceOfMedia;
    //Текст-описание картинки
    @Column(name = "text")
    String text;
}
