package com.github.a_oleg.entity.questions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question_scale_of_opinion")
public class QuestionScaleOfOpinion extends AbstractQuestion {
    //Здесь нужен HashMap
    @Column(name = "type_figure")
    String typeFigure;
    @Column(name = "gradient_type")
    String gradientType;

    public QuestionScaleOfOpinion() {
        super();
    }
}
