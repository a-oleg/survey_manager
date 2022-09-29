package com.github.a_oleg.converters;

import com.github.a_oleg.dto.questions.QuestionSliderDto;
import com.github.a_oleg.entity.questions.QuestionSlider;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionSliderToQuestionSliderDtoConverter implements Converter<QuestionSlider, QuestionSliderDto> {
    @Override
    public QuestionSliderDto convert(QuestionSlider questionSlider) {
        QuestionSliderDto targetQuestionSliderDto = new QuestionSliderDto();

        targetQuestionSliderDto.setQuestionId(questionSlider.getQuestionId());
        targetQuestionSliderDto.setSurveyId(questionSlider.getSurveyId());
        targetQuestionSliderDto.setQuestionNumberInTheSurvey(questionSlider.getQuestionNumberInTheSurvey());
        targetQuestionSliderDto.setTypeQuestion(questionSlider.getTypeQuestion());
        targetQuestionSliderDto.setTextQuestion(questionSlider.getTextQuestion());
        targetQuestionSliderDto.setDescriptionText(questionSlider.getDescriptionText());
        targetQuestionSliderDto.setButtonText(questionSlider.getButtonText());
        targetQuestionSliderDto.setTypeSlider(questionSlider.getTypeSlider());
        targetQuestionSliderDto.setCountOfScaleElements(questionSlider.getCountOfScaleElements());
        targetQuestionSliderDto.setDefaultScaleElementNumber(questionSlider.getDefaultScaleElementNumber());
        targetQuestionSliderDto.setFigureType(questionSlider.getFigureType());

        return targetQuestionSliderDto;
    }
}
