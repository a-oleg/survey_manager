package com.github.a_oleg.converter;

import com.github.a_oleg.controller.questions.QuestionWithMultipleAnswersDto;
import com.github.a_oleg.entity.question.QuestionWithMultipleAnswer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionWithMultipleAnswersToQuestionWithMultipleAnswersDtoConverter implements Converter<QuestionWithMultipleAnswer, QuestionWithMultipleAnswersDto> {
    @Override
    public QuestionWithMultipleAnswersDto convert(QuestionWithMultipleAnswer questionWithMultipleAnswer) {
        QuestionWithMultipleAnswersDto targetQuestionWithMultipleAnswersDto = new QuestionWithMultipleAnswersDto();

        targetQuestionWithMultipleAnswersDto.setQuestionId(questionWithMultipleAnswer.getQuestionId());
        targetQuestionWithMultipleAnswersDto.setParentId(questionWithMultipleAnswer.getParentId());
        targetQuestionWithMultipleAnswersDto.setActivityStatus(questionWithMultipleAnswer.isActivityStatus());
        targetQuestionWithMultipleAnswersDto.setSurveyId(questionWithMultipleAnswer.getSurvey().getSurveyId());
        targetQuestionWithMultipleAnswersDto.setQuestionNumberInTheSurvey(questionWithMultipleAnswer.getQuestionNumberInTheSurvey());
        targetQuestionWithMultipleAnswersDto.setTypeQuestion(questionWithMultipleAnswer.getTypeQuestion());
        targetQuestionWithMultipleAnswersDto.setTextQuestion(questionWithMultipleAnswer.getTextQuestion());
        targetQuestionWithMultipleAnswersDto.setDescriptionText(questionWithMultipleAnswer.getDescriptionText());
        targetQuestionWithMultipleAnswersDto.setButtonText(questionWithMultipleAnswer.getButtonText());
        //targetQuestionWithMultipleAnswersDto.setAnswerOptions(new ArrayList<String>(Arrays.asList(questionWithMultipleAnswers.getAnswerOptions().split("~"))));
        targetQuestionWithMultipleAnswersDto.setMultipleChoiceOfAnswers(questionWithMultipleAnswer.isMultipleChoiceOfAnswers());

        return targetQuestionWithMultipleAnswersDto;
    }
}
