package com.github.a_oleg.converters;

import com.github.a_oleg.dto.questions.QuestionRatingDto;
import com.github.a_oleg.entity.questions.QuestionRating;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionRatingToQuestionRatingDtoConverter implements Converter<QuestionRating, QuestionRatingDto> {
    @Override
    public QuestionRatingDto convert(QuestionRating questionRating) {
        QuestionRatingDto targetQuestionRatingDto = new QuestionRatingDto();
        targetQuestionRatingDto.setQuestionId(questionRating.getQuestionId());
        targetQuestionRatingDto.setSurveyId(questionRating.getSurveyId());
        targetQuestionRatingDto.setQuestionNumberInTheSurvey(questionRating.getQuestionNumberInTheSurvey());
        targetQuestionRatingDto.setTypeQuestion(questionRating.getTypeQuestion());
        targetQuestionRatingDto.setTextQuestion(questionRating.getTextQuestion());
        targetQuestionRatingDto.setDescriptionText(questionRating.getDescriptionText());
        targetQuestionRatingDto.setButtonText(questionRating.getButtonText());
        targetQuestionRatingDto.setCountOfScaleElements(questionRating.getCountOfScaleElements());
        targetQuestionRatingDto.setFigureType(questionRating.getFigureType());
        targetQuestionRatingDto.setGradientType(questionRating.getGradientType());

        return null;
    }
}
