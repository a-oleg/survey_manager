package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.questions.QuestionWithTextAnswer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionWithTextAnswerToQuestionWithTextAnswerDtoConverter implements Converter<QuestionWithTextAnswer, QuestionWithTextAnswerDto> {
    public QuestionWithTextAnswerDto convert(QuestionWithTextAnswer questionWithTextAnswer) {
        QuestionWithTextAnswerDto targetQuestionWithTextAnswerDto = new QuestionWithTextAnswerDto();
        targetQuestionWithTextAnswerDto.setQuestionId(questionWithTextAnswer.getQuestionId());
        targetQuestionWithTextAnswerDto.setQuestionNumberInTheSurvey(questionWithTextAnswer.getQuestionNumberInTheSurvey());
        targetQuestionWithTextAnswerDto.setTypeQuestion(questionWithTextAnswer.getTypeQuestion());
        targetQuestionWithTextAnswerDto.setTextQuestion(questionWithTextAnswer.getTextQuestion());
        targetQuestionWithTextAnswerDto.setDescriptionText(questionWithTextAnswer.getDescriptionText());
        targetQuestionWithTextAnswerDto.setButtonText(questionWithTextAnswer.getButtonText());
        targetQuestionWithTextAnswerDto.setPrefixText(questionWithTextAnswer.getPrefixText());
        targetQuestionWithTextAnswerDto.setPostfixText(questionWithTextAnswer.getPostfixText());

        return targetQuestionWithTextAnswerDto;
    }
}
