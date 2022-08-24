package com.github.a_oleg.entity.questions;

import javax.persistence.Entity;
import javax.persistence.*;

@MappedSuperclass
public abstract class QuestionRatingSlider extends AbstractQuestion {
    private enum TypeFigure {
        SMILE,
        STAR,
        CIRCLE,
        SQUARE
    }

    private enum GradientType {
            NO,
            BLACKWHITE,
            BLUEWHITE,
            GRAYWHITE,
            GREENWHITE,
            ORANGEWHITE
    }


    @Entity
    @Table(name = "question_rating")
    class QuestionRating extends QuestionRatingSlider {

        @Column(name = "count_of_scale_elements")
        int countOfScaleElements;
        @Column(name = "type_figure")
        TypeFigure typeFigure;
        @Column(name = "gradient_type")
        GradientType gradientType;
    }

    @MappedSuperclass
    public abstract class QuestionSlider extends QuestionRatingSlider {
        @Entity
        @Table(name = "question_numeric_slider")
        class QuestionNumericSlider extends QuestionSlider {
            @Column(name = "count_of_scale_elements")
            int countOfScaleElements;
            @Column(name = "type_figure")
            TypeFigure typeFigure;
            @Column(name = "gradient_type")
            GradientType gradientType;
            @Column(name = "default_value_of_the_element")
            int defaultValueOfTheElement;
        }

        @Entity
        @Table(name = "question_percentage_slider")
        class QuestionPercentageSlider extends QuestionSlider {
            @Column(name = "step")
            int step;
            @Column(name = "default_percentage_value")
            int defaultPercentageValue;
            @Column(name = "type_figure")
            TypeFigure typeFigure;
        }
    }
}
