package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionWithMultipleAnswersDto;
import com.github.a_oleg.entity.questions.QuestionWithMultipleAnswers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class QuestionWithMultipleAnswersToQuestionWithMultipleAnswersDto implements Converter<QuestionWithMultipleAnswers, QuestionWithMultipleAnswersDto> {
    @Override
    public QuestionWithMultipleAnswersDto convert(QuestionWithMultipleAnswers questionWithMultipleAnswers) {
        QuestionWithMultipleAnswersDto targetQuestionWithMultipleAnswersDto = new QuestionWithMultipleAnswersDto();

        targetQuestionWithMultipleAnswersDto.setQuestionId(questionWithMultipleAnswers.getQuestionId());
        targetQuestionWithMultipleAnswersDto.setSurvey(questionWithMultipleAnswers.getSurvey());
        targetQuestionWithMultipleAnswersDto.setQuestionNumberInTheSurvey(questionWithMultipleAnswers.getQuestionNumberInTheSurvey());
        targetQuestionWithMultipleAnswersDto.setTypeQuestion(questionWithMultipleAnswers.getTypeQuestion());
        targetQuestionWithMultipleAnswersDto.setTextQuestion(questionWithMultipleAnswers.getTextQuestion());
        targetQuestionWithMultipleAnswersDto.setDescriptionText(questionWithMultipleAnswers.getDescriptionText());
        targetQuestionWithMultipleAnswersDto.setButtonText(questionWithMultipleAnswers.getButtonText());
        targetQuestionWithMultipleAnswersDto.setAnswerOptions(new ArrayList<String>(Arrays.asList(questionWithMultipleAnswers.getAnswerOptions().split("~"))));
        targetQuestionWithMultipleAnswersDto.setMultipleChoiceOfAnswers(questionWithMultipleAnswers.isMultipleChoiceOfAnswers());

        return targetQuestionWithMultipleAnswersDto;
    }
}
