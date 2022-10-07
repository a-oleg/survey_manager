package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionScaleOfOpinionDto;
import com.github.a_oleg.entity.questions.QuestionScaleOfOpinion;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class QuestionScaleOfOpinionToQuestionScaleOfOpinionDtoConverter implements Converter<QuestionScaleOfOpinion, QuestionScaleOfOpinionDto> {
    @Override
    public QuestionScaleOfOpinionDto convert(QuestionScaleOfOpinion questionScaleOfOpinion) {
        QuestionScaleOfOpinionDto targetQuestionScaleOfOpinionDto = new QuestionScaleOfOpinionDto();

        targetQuestionScaleOfOpinionDto.setQuestionId(questionScaleOfOpinion.getQuestionId());
        targetQuestionScaleOfOpinionDto.setParentCode(questionScaleOfOpinion.getParentCode());
        targetQuestionScaleOfOpinionDto.setSurvey(questionScaleOfOpinion.getSurvey());
        targetQuestionScaleOfOpinionDto.setQuestionNumberInTheSurvey(questionScaleOfOpinion.getQuestionNumberInTheSurvey());
        targetQuestionScaleOfOpinionDto.setTypeQuestion(questionScaleOfOpinion.getTypeQuestion());
        targetQuestionScaleOfOpinionDto.setTextQuestion(questionScaleOfOpinion.getTextQuestion());
        targetQuestionScaleOfOpinionDto.setDescriptionText(questionScaleOfOpinion.getDescriptionText());
        targetQuestionScaleOfOpinionDto.setButtonText(questionScaleOfOpinion.getButtonText());
        targetQuestionScaleOfOpinionDto.setDescriptionOfAssessment(new ArrayList<String>(Arrays.asList(questionScaleOfOpinion.getDescriptionOfAssessment().split("~"))));
        targetQuestionScaleOfOpinionDto.setHaveButtonIFindItDifficultToAnswer(questionScaleOfOpinion.isHaveButtonIFindItDifficultToAnswer());
        targetQuestionScaleOfOpinionDto.setRatingForEnteringComment(questionScaleOfOpinion.getRatingForEnteringComment());
        targetQuestionScaleOfOpinionDto.setTextInTheCommentField(questionScaleOfOpinion.getTextInCommentField());
        targetQuestionScaleOfOpinionDto.setFigureType(questionScaleOfOpinion.getFigureType());
        targetQuestionScaleOfOpinionDto.setGradientType(questionScaleOfOpinion.getGradientType());

        return targetQuestionScaleOfOpinionDto;
    }
}
