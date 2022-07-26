package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.question.QuestionWithTextAnswer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionWithTextAnswerDtoToQuestionWithTextAnswerConverter implements Converter<QuestionWithTextAnswerDto, QuestionWithTextAnswer> {
    @Override
    public QuestionWithTextAnswer convert(QuestionWithTextAnswerDto questionWithTextAnswerDto) {
        QuestionWithTextAnswer targetQuestionWithTextAnswer = new QuestionWithTextAnswer();

        targetQuestionWithTextAnswer.setQuestionId(questionWithTextAnswerDto.getQuestionId());
        targetQuestionWithTextAnswer.setParentId(questionWithTextAnswerDto.getParentId());
        targetQuestionWithTextAnswer.setActivityStatus(questionWithTextAnswerDto.isActivityStatus());
        targetQuestionWithTextAnswer.setSurvey(questionWithTextAnswerDto.getSurvey());
        targetQuestionWithTextAnswer.setQuestionNumberInTheSurvey(questionWithTextAnswerDto.getQuestionNumberInTheSurvey());
        targetQuestionWithTextAnswer.setTypeQuestion(questionWithTextAnswerDto.getTypeQuestion());
        targetQuestionWithTextAnswer.setTextQuestion(questionWithTextAnswerDto.getTextQuestion());
        targetQuestionWithTextAnswer.setDescriptionText(questionWithTextAnswerDto.getDescriptionText());
        targetQuestionWithTextAnswer.setButtonText(questionWithTextAnswerDto.getButtonText());
        targetQuestionWithTextAnswer.setSubquestionAndPrefixPostfixText(questionWithTextAnswerDto.getSubquestionAndPrefixPostfixText());

        return targetQuestionWithTextAnswer;
    }
}
