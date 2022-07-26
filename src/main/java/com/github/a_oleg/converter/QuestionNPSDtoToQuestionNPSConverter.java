package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionNPSDto;
import com.github.a_oleg.entity.question.QuestionNPS;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionNPSDtoToQuestionNPSConverter implements Converter<QuestionNPSDto, QuestionNPS> {
    @Override
    public QuestionNPS convert(QuestionNPSDto questionNPSDto) {
        QuestionNPS targetQuestionNPS = new QuestionNPS();

        targetQuestionNPS.setQuestionId(questionNPSDto.getQuestionId());
        targetQuestionNPS.setParentId(questionNPSDto.getParentId());
        targetQuestionNPS.setActivityStatus(questionNPSDto.isActivityStatus());
        targetQuestionNPS.setSurvey(questionNPSDto.getSurvey());
        targetQuestionNPS.setQuestionNumberInTheSurvey(questionNPSDto.getQuestionNumberInTheSurvey());
        targetQuestionNPS.setTypeQuestion(questionNPSDto.getTypeQuestion());
        targetQuestionNPS.setTextQuestion(questionNPSDto.getTextQuestion());
        targetQuestionNPS.setDescriptionText(questionNPSDto.getDescriptionText());
        targetQuestionNPS.setButtonText(questionNPSDto.getButtonText());
        targetQuestionNPS.setHaveButtonIFindItDifficultToAnswer(questionNPSDto.isHaveButtonIFindItDifficultToAnswer());
        targetQuestionNPS.setTextInCommentField(questionNPSDto.getTextInCommentField());
        targetQuestionNPS.setFigureType(questionNPSDto.getFigureType());
        targetQuestionNPS.setGradientType(questionNPSDto.getGradientType());

        return targetQuestionNPS;
    }
}
