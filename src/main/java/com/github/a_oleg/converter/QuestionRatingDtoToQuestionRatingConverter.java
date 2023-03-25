package com.github.a_oleg.converter;

import com.github.a_oleg.controller.questions.QuestionRatingDto;
import com.github.a_oleg.entity.question.QuestionRating;
import com.github.a_oleg.repository.SurveyRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionRatingDtoToQuestionRatingConverter implements Converter<QuestionRatingDto, QuestionRating> {
    private final SurveyRepository surveyRepository;

    public QuestionRatingDtoToQuestionRatingConverter(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public QuestionRating convert(QuestionRatingDto questionRatingDto) {
        QuestionRating targetQuestionRating = new QuestionRating();

        targetQuestionRating.setQuestionId(questionRatingDto.getQuestionId());
        targetQuestionRating.setParentId(questionRatingDto.getParentId());
        targetQuestionRating.setActivityStatus(questionRatingDto.isActivityStatus());
        targetQuestionRating.setSurvey(surveyRepository.findById(questionRatingDto.getSurveyId()).stream().findFirst().get());
        targetQuestionRating.setQuestionNumberInTheSurvey(questionRatingDto.getQuestionNumberInTheSurvey());
        targetQuestionRating.setTypeQuestion(questionRatingDto.getTypeQuestion());
        targetQuestionRating.setTextQuestion(questionRatingDto.getTextQuestion());
        targetQuestionRating.setDescriptionText(questionRatingDto.getDescriptionText());
        targetQuestionRating.setButtonText(questionRatingDto.getButtonText());
        targetQuestionRating.setCountOfScaleElements(questionRatingDto.getCountOfScaleElements());
        targetQuestionRating.setFigureType(questionRatingDto.getFigureType());
        targetQuestionRating.setGradientType(questionRatingDto.getGradientType());

        return targetQuestionRating;
    }
}
