package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionRatingDto;
import com.github.a_oleg.entity.questions.QuestionRating;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionRatingDtoToQuestionRatingConverter implements Converter<QuestionRatingDto, QuestionRating> {
    @Override
    public QuestionRating convert(QuestionRatingDto questionRatingDto) {
        QuestionRating targetQuestionRating = new QuestionRating();

        targetQuestionRating.setQuestionId(questionRatingDto.getQuestionId());
        targetQuestionRating.setSurvey(questionRatingDto.getSurvey());
        targetQuestionRating.setQuestionNumberInTheSurvey(questionRatingDto.getQuestionNumberInTheSurvey());
        targetQuestionRating.setTypeQuestion(questionRatingDto.getTypeQuestion());
        targetQuestionRating.setTextQuestion(questionRatingDto.getTextQuestion());
        targetQuestionRating.setDescriptionText(questionRatingDto.getDescriptionText());
        targetQuestionRating.setButtonText(questionRatingDto.getButtonText());
        targetQuestionRating.setCountOfScaleElements(questionRatingDto.getCountOfScaleElements());
        targetQuestionRating.setFigureType(questionRatingDto.getFigureType());
        targetQuestionRating.setGradientType(questionRatingDto.getGradientType());

        return null;
    }
}
