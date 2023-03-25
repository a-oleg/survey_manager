package com.github.a_oleg.converter;

import com.github.a_oleg.controller.questions.QuestionWithMultipleAnswersDto;
import com.github.a_oleg.entity.question.QuestionWithMultipleAnswer;
import com.github.a_oleg.repository.SurveyRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionWithMultipleAnswersDtoToQuestionWithMultipleAnswersConverter implements Converter<QuestionWithMultipleAnswersDto, QuestionWithMultipleAnswer> {
    private final SurveyRepository surveyRepository;

    public QuestionWithMultipleAnswersDtoToQuestionWithMultipleAnswersConverter(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public QuestionWithMultipleAnswer convert(QuestionWithMultipleAnswersDto questionWithMultipleAnswersDto) {
        QuestionWithMultipleAnswer targetQuestionWithMultipleAnswer = new QuestionWithMultipleAnswer();

        targetQuestionWithMultipleAnswer.setQuestionId(questionWithMultipleAnswersDto.getQuestionId());
        targetQuestionWithMultipleAnswer.setParentId(questionWithMultipleAnswersDto.getParentId());
        targetQuestionWithMultipleAnswer.setActivityStatus(questionWithMultipleAnswersDto.isActivityStatus());
        targetQuestionWithMultipleAnswer.setSurvey(surveyRepository.findById(questionWithMultipleAnswersDto.getSurveyId()).stream().findFirst().get());
        targetQuestionWithMultipleAnswer.setQuestionNumberInTheSurvey(questionWithMultipleAnswersDto.getQuestionNumberInTheSurvey());
        targetQuestionWithMultipleAnswer.setTypeQuestion(questionWithMultipleAnswersDto.getTypeQuestion());
        targetQuestionWithMultipleAnswer.setTextQuestion(questionWithMultipleAnswersDto.getTextQuestion());
        targetQuestionWithMultipleAnswer.setDescriptionText(questionWithMultipleAnswersDto.getDescriptionText());
        targetQuestionWithMultipleAnswer.setButtonText(questionWithMultipleAnswersDto.getButtonText());
        //targetQuestionWithMultipleAnswers.setAnswerOptions(StringUtils.join(questionWithMultipleAnswersDto.getAnswerOptions(), '~'));
        targetQuestionWithMultipleAnswer.setMultipleChoiceOfAnswers(questionWithMultipleAnswersDto.isMultipleChoiceOfAnswers());

        return targetQuestionWithMultipleAnswer;
    }
}
