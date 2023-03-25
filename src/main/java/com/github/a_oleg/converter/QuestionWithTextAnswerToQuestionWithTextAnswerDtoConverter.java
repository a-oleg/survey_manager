package com.github.a_oleg.converter;

import com.github.a_oleg.controller.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.question.QuestionWithTextAnswer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionWithTextAnswerToQuestionWithTextAnswerDtoConverter implements Converter<QuestionWithTextAnswer, QuestionWithTextAnswerDto> {
    @Override
    public QuestionWithTextAnswerDto convert(QuestionWithTextAnswer questionWithTextAnswer) {
        QuestionWithTextAnswerDto targetQuestionWithTextAnswerDto = new QuestionWithTextAnswerDto();

        targetQuestionWithTextAnswerDto.setQuestionId(questionWithTextAnswer.getQuestionId());
        targetQuestionWithTextAnswerDto.setParentId(questionWithTextAnswer.getParentId());
        targetQuestionWithTextAnswerDto.setActivityStatus(questionWithTextAnswer.isActivityStatus());
        targetQuestionWithTextAnswerDto.setSurveyId(questionWithTextAnswer.getSurvey().getSurveyId());
        targetQuestionWithTextAnswerDto.setQuestionNumberInTheSurvey(questionWithTextAnswer.getQuestionNumberInTheSurvey());
        targetQuestionWithTextAnswerDto.setTypeQuestion(questionWithTextAnswer.getTypeQuestion());
        targetQuestionWithTextAnswerDto.setTextQuestion(questionWithTextAnswer.getTextQuestion());
        targetQuestionWithTextAnswerDto.setDescriptionText(questionWithTextAnswer.getDescriptionText());
        targetQuestionWithTextAnswerDto.setButtonText(questionWithTextAnswer.getButtonText());
        targetQuestionWithTextAnswerDto.setSubquestionAndPrefixPostfixText(questionWithTextAnswer.getSubquestionAndPrefixPostfixText());

        targetQuestionWithTextAnswerDto.setHaveButtonIFindItDifficultToAnswer(questionWithTextAnswer.isHaveButtonIFindItDifficultToAnswer());

        return targetQuestionWithTextAnswerDto;
    }
}
