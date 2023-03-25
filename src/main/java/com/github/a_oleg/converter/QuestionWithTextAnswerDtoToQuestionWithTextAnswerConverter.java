package com.github.a_oleg.converter;

import com.github.a_oleg.controller.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.question.QuestionWithTextAnswer;
import com.github.a_oleg.repository.SurveyRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionWithTextAnswerDtoToQuestionWithTextAnswerConverter implements Converter<QuestionWithTextAnswerDto, QuestionWithTextAnswer> {
    private final SurveyRepository surveyRepository;

    public QuestionWithTextAnswerDtoToQuestionWithTextAnswerConverter(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public QuestionWithTextAnswer convert(QuestionWithTextAnswerDto questionWithTextAnswerDto) {
        QuestionWithTextAnswer targetQuestionWithTextAnswer = new QuestionWithTextAnswer();

        targetQuestionWithTextAnswer.setQuestionId(questionWithTextAnswerDto.getQuestionId());
        targetQuestionWithTextAnswer.setParentId(questionWithTextAnswerDto.getParentId());
        targetQuestionWithTextAnswer.setActivityStatus(questionWithTextAnswerDto.isActivityStatus());
        targetQuestionWithTextAnswer.setSurvey(surveyRepository.findById(questionWithTextAnswerDto.getSurveyId()).stream().findFirst().get());
        targetQuestionWithTextAnswer.setQuestionNumberInTheSurvey(questionWithTextAnswerDto.getQuestionNumberInTheSurvey());
        targetQuestionWithTextAnswer.setTypeQuestion(questionWithTextAnswerDto.getTypeQuestion());
        targetQuestionWithTextAnswer.setTextQuestion(questionWithTextAnswerDto.getTextQuestion());
        targetQuestionWithTextAnswer.setDescriptionText(questionWithTextAnswerDto.getDescriptionText());
        targetQuestionWithTextAnswer.setButtonText(questionWithTextAnswerDto.getButtonText());
        targetQuestionWithTextAnswer.setSubquestionAndPrefixPostfixText(questionWithTextAnswerDto.getSubquestionAndPrefixPostfixText());

        return targetQuestionWithTextAnswer;
    }
}
