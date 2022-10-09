package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.question.QuestionWithTextAnswer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionWithTextAnswerToQuestionWithTextAnswerDtoConverter implements Converter<QuestionWithTextAnswer, QuestionWithTextAnswerDto> {
    @Override
    public QuestionWithTextAnswerDto convert(QuestionWithTextAnswer questionWithTextAnswer) {
        QuestionWithTextAnswerDto targetQuestionWithTextAnswerDto = new QuestionWithTextAnswerDto();

        targetQuestionWithTextAnswerDto.setQuestionId(questionWithTextAnswer.getQuestionId());
        targetQuestionWithTextAnswerDto.setParentCode(questionWithTextAnswer.getParentCode());
        targetQuestionWithTextAnswerDto.setActivityStatus(questionWithTextAnswer.isActivityStatus());
        targetQuestionWithTextAnswerDto.setSurvey(questionWithTextAnswer.getSurvey());
        targetQuestionWithTextAnswerDto.setQuestionNumberInTheSurvey(questionWithTextAnswer.getQuestionNumberInTheSurvey());
        targetQuestionWithTextAnswerDto.setNextQuestionNumberInTheSurvey(questionWithTextAnswer.getNextQuestionNumberInTheSurvey());
        targetQuestionWithTextAnswerDto.setTypeQuestion(questionWithTextAnswer.getTypeQuestion());
        targetQuestionWithTextAnswerDto.setTextQuestion(questionWithTextAnswer.getTextQuestion());
        targetQuestionWithTextAnswerDto.setDescriptionText(questionWithTextAnswer.getDescriptionText());
        targetQuestionWithTextAnswerDto.setButtonText(questionWithTextAnswer.getButtonText());
        targetQuestionWithTextAnswerDto.setSubquestionAndPrefixPostfixText(questionWithTextAnswer.getSubquestionAndPrefixPostfixText());

        targetQuestionWithTextAnswerDto.setHaveButtonIFindItDifficultToAnswer(questionWithTextAnswer.isHaveButtonIFindItDifficultToAnswer());

        return targetQuestionWithTextAnswerDto;
    }
}
