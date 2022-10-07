package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.questions.QuestionWithTextAnswer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionWithTextAnswerToQuestionWithTextAnswerDtoConverter implements Converter<QuestionWithTextAnswer, QuestionWithTextAnswerDto> {
    @Override
    public QuestionWithTextAnswerDto convert(QuestionWithTextAnswer questionWithTextAnswer) {
        QuestionWithTextAnswerDto targetQuestionWithTextAnswerDto = new QuestionWithTextAnswerDto();

        targetQuestionWithTextAnswerDto.setQuestionId(questionWithTextAnswer.getQuestionId());
        targetQuestionWithTextAnswerDto.setParentCode(questionWithTextAnswer.getParentCode());
        targetQuestionWithTextAnswerDto.setSurvey(questionWithTextAnswer.getSurvey());
        targetQuestionWithTextAnswerDto.setQuestionNumberInTheSurvey(questionWithTextAnswer.getQuestionNumberInTheSurvey());
        targetQuestionWithTextAnswerDto.setTypeQuestion(questionWithTextAnswer.getTypeQuestion());
        targetQuestionWithTextAnswerDto.setTextQuestion(questionWithTextAnswer.getTextQuestion());
        targetQuestionWithTextAnswerDto.setDescriptionText(questionWithTextAnswer.getDescriptionText());
        targetQuestionWithTextAnswerDto.setButtonText(questionWithTextAnswer.getButtonText());

        targetQuestionWithTextAnswerDto.setHaveButtonIFindItDifficultToAnswer(questionWithTextAnswer.isHaveButtonIFindItDifficultToAnswer());

        return targetQuestionWithTextAnswerDto;
    }
}
