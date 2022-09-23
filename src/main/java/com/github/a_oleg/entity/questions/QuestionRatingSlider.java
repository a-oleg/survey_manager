package com.github.a_oleg.entity.questions;

import com.github.a_oleg.enums.FigureType;
import com.github.a_oleg.enums.GradientType;

import javax.persistence.Entity;
import javax.persistence.*;

@MappedSuperclass
public abstract class QuestionRatingSlider extends AbstractQuestion {
    @Entity
    @Table(name = "question_rating")
    class QuestionRating extends QuestionRatingSlider {

        @Column(name = "count_of_scale_elements")
        int countOfScaleElements;
        @Column(name = "figure_type")
        FigureType figureType;
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
            @Column(name = "figure_type")
            FigureType figureType;
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
            @Column(name = "figure_type")
            FigureType figureType;
        }
    }
}
