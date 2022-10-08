package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionNPSDto;
import com.github.a_oleg.entity.questions.QuestionNPS;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionNPSToQuestionNPSDtoConverter implements Converter<QuestionNPS, QuestionNPSDto> {
    @Override
    public QuestionNPSDto convert(QuestionNPS questionNPS) {
        QuestionNPSDto targetQuestionNPSDto = new QuestionNPSDto();

        targetQuestionNPSDto.setQuestionId(questionNPS.getQuestionId());
        targetQuestionNPSDto.setParentCode(questionNPS.getParentCode());
        targetQuestionNPSDto.setActivityStatus(questionNPS.isActivityStatus());
        targetQuestionNPSDto.setSurvey(questionNPS.getSurvey());
        targetQuestionNPSDto.setQuestionNumberInTheSurvey(questionNPS.getQuestionNumberInTheSurvey());
        targetQuestionNPSDto.setTypeQuestion(questionNPS.getTypeQuestion());
        targetQuestionNPSDto.setTextQuestion(questionNPS.getTextQuestion());
        targetQuestionNPSDto.setDescriptionText(questionNPS.getDescriptionText());
        targetQuestionNPSDto.setButtonText(questionNPS.getButtonText());
        targetQuestionNPSDto.setHaveButtonIFindItDifficultToAnswer(questionNPS.isHaveButtonIFindItDifficultToAnswer());
        targetQuestionNPSDto.setRatingForEnteringComment(questionNPS.getRatingForEnteringComment());
        targetQuestionNPSDto.setTextInTheCommentField(questionNPS.getTextInCommentField());
        targetQuestionNPSDto.setFigureType(questionNPS.getFigureType());
        targetQuestionNPSDto.setGradientType(questionNPS.getGradientType());

        return targetQuestionNPSDto;
    }
}
