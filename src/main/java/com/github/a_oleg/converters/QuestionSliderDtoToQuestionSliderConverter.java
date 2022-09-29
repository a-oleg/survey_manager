package com.github.a_oleg.converters;

import com.github.a_oleg.dto.questions.QuestionSliderDto;
import com.github.a_oleg.entity.questions.QuestionSlider;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionSliderDtoToQuestionSliderConverter implements Converter<QuestionSliderDto, QuestionSlider> {
    @Override
    public QuestionSlider convert(QuestionSliderDto questionSliderDto) {
        QuestionSlider targetqQuestionSlider = new QuestionSlider();

        targetqQuestionSlider.setQuestionId(questionSliderDto.getQuestionId());
        targetqQuestionSlider.setSurveyId(questionSliderDto.getSurveyId());
        targetqQuestionSlider.setQuestionNumberInTheSurvey(questionSliderDto.getQuestionNumberInTheSurvey());
        targetqQuestionSlider.setTypeQuestion(questionSliderDto.getTypeQuestion());
        targetqQuestionSlider.setTextQuestion(questionSliderDto.getTextQuestion());
        targetqQuestionSlider.setDescriptionText(questionSliderDto.getDescriptionText());
        targetqQuestionSlider.setButtonText(questionSliderDto.getButtonText());
        targetqQuestionSlider.setTypeSlider(questionSliderDto.getTypeSlider());
        targetqQuestionSlider.setCountOfScaleElements(questionSliderDto.getCountOfScaleElements());
        targetqQuestionSlider.setDefaultScaleElementNumber(questionSliderDto.getDefaultScaleElementNumber());
        targetqQuestionSlider.setFigureType(questionSliderDto.getFigureType());

        return targetqQuestionSlider;
    }
}
