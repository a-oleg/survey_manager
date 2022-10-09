package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionSliderDto;
import com.github.a_oleg.entity.question.QuestionSlider;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionSliderDtoToQuestionSliderConverter implements Converter<QuestionSliderDto, QuestionSlider> {
    @Override
    public QuestionSlider convert(QuestionSliderDto questionSliderDto) {
        QuestionSlider targetqQuestionSlider = new QuestionSlider();

        targetqQuestionSlider.setQuestionId(questionSliderDto.getQuestionId());
        targetqQuestionSlider.setParentCode(questionSliderDto.getParentCode());
        targetqQuestionSlider.setActivityStatus(questionSliderDto.isActivityStatus());
        targetqQuestionSlider.setSurvey(questionSliderDto.getSurvey());
        targetqQuestionSlider.setQuestionNumberInTheSurvey(questionSliderDto.getQuestionNumberInTheSurvey());
        targetqQuestionSlider.setNextQuestionNumberInTheSurvey(questionSliderDto.getNextQuestionNumberInTheSurvey());
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
