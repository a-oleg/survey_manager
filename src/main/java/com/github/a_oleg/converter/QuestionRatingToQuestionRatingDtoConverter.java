package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionRatingDto;
import com.github.a_oleg.entity.question.QuestionRating;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionRatingToQuestionRatingDtoConverter implements Converter<QuestionRating, QuestionRatingDto> {
    @Override
    public QuestionRatingDto convert(QuestionRating questionRating) {
        QuestionRatingDto targetQuestionRatingDto = new QuestionRatingDto();

        targetQuestionRatingDto.setQuestionId(questionRating.getQuestionId());
        targetQuestionRatingDto.setParentCode(questionRating.getParentCode());
        targetQuestionRatingDto.setActivityStatus(questionRating.isActivityStatus());
        targetQuestionRatingDto.setSurvey(questionRating.getSurvey());
        targetQuestionRatingDto.setQuestionNumberInTheSurvey(questionRating.getQuestionNumberInTheSurvey());
        targetQuestionRatingDto.setNextQuestionNumberInTheSurvey(questionRating.getNextQuestionNumberInTheSurvey());
        targetQuestionRatingDto.setTypeQuestion(questionRating.getTypeQuestion());
        targetQuestionRatingDto.setTextQuestion(questionRating.getTextQuestion());
        targetQuestionRatingDto.setDescriptionText(questionRating.getDescriptionText());
        targetQuestionRatingDto.setButtonText(questionRating.getButtonText());
        targetQuestionRatingDto.setCountOfScaleElements(questionRating.getCountOfScaleElements());
        targetQuestionRatingDto.setFigureType(questionRating.getFigureType());
        targetQuestionRatingDto.setGradientType(questionRating.getGradientType());

        return targetQuestionRatingDto;
    }
}
