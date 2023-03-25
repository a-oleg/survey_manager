package com.github.a_oleg.converter;

import com.github.a_oleg.controller.questions.QuestionSliderDto;
import com.github.a_oleg.entity.question.QuestionSlider;
import com.github.a_oleg.repository.SurveyRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionSliderDtoToQuestionSliderConverter implements Converter<QuestionSliderDto, QuestionSlider> {
    private final SurveyRepository surveyRepository;

    public QuestionSliderDtoToQuestionSliderConverter(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public QuestionSlider convert(QuestionSliderDto questionSliderDto) {
        QuestionSlider targetqQuestionSlider = new QuestionSlider();

        targetqQuestionSlider.setQuestionId(questionSliderDto.getQuestionId());
        targetqQuestionSlider.setParentId(questionSliderDto.getParentId());
        targetqQuestionSlider.setActivityStatus(questionSliderDto.isActivityStatus());
        targetqQuestionSlider.setSurvey(surveyRepository.findById(questionSliderDto.getSurveyId()).stream().findFirst().get());
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
