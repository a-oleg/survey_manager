package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionWithMultipleAnswersDto;
import com.github.a_oleg.entity.question.QuestionWithMultipleAnswers;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionWithMultipleAnswersDtoToQuestionWithMultipleAnswersConverter implements Converter<QuestionWithMultipleAnswersDto, QuestionWithMultipleAnswers> {
    @Override
    public QuestionWithMultipleAnswers convert(QuestionWithMultipleAnswersDto questionWithMultipleAnswersDto) {
        QuestionWithMultipleAnswers targetQuestionWithMultipleAnswers = new QuestionWithMultipleAnswers();

        targetQuestionWithMultipleAnswers.setQuestionId(questionWithMultipleAnswersDto.getQuestionId());
        targetQuestionWithMultipleAnswers.setParentId(questionWithMultipleAnswersDto.getParentId());
        targetQuestionWithMultipleAnswers.setActivityStatus(questionWithMultipleAnswersDto.isActivityStatus());
        targetQuestionWithMultipleAnswers.setSurvey(questionWithMultipleAnswersDto.getSurvey());
        targetQuestionWithMultipleAnswers.setQuestionNumberInTheSurvey(questionWithMultipleAnswersDto.getQuestionNumberInTheSurvey());
        targetQuestionWithMultipleAnswers.setTypeQuestion(questionWithMultipleAnswersDto.getTypeQuestion());
        targetQuestionWithMultipleAnswers.setTextQuestion(questionWithMultipleAnswersDto.getTextQuestion());
        targetQuestionWithMultipleAnswers.setDescriptionText(questionWithMultipleAnswersDto.getDescriptionText());
        targetQuestionWithMultipleAnswers.setButtonText(questionWithMultipleAnswersDto.getButtonText());
        //targetQuestionWithMultipleAnswers.setAnswerOptions(StringUtils.join(questionWithMultipleAnswersDto.getAnswerOptions(), '~'));
        targetQuestionWithMultipleAnswers.setMultipleChoiceOfAnswers(questionWithMultipleAnswersDto.isMultipleChoiceOfAnswers());

        return targetQuestionWithMultipleAnswers;
    }
}
