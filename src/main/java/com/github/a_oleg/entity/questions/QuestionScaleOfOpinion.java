package com.github.a_oleg.entity.questions;

import com.github.a_oleg.enums.FigureType;
import com.github.a_oleg.enums.GradientType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;

@Entity
@Table(name = "question_scale_of_opinion")
public class QuestionScaleOfOpinion extends AbstractQuestion {
    //Как в БД укладывать элементы HashMap
    HashMap<Integer, String> scoreAndDescriptionScore;
    @Column(name = "figure_type")
    FigureType figureType;
    @Column(name = "gradient_type")
    GradientType gradientType;

    public QuestionScaleOfOpinion() {
        super();
    }
}
