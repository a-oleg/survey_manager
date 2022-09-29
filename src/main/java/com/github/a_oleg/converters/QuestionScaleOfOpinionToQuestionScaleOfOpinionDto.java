package com.github.a_oleg.converters;

import com.github.a_oleg.dto.questions.QuestionScaleOfOpinionDto;
import com.github.a_oleg.entity.questions.QuestionScaleOfOpinion;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class QuestionScaleOfOpinionToQuestionScaleOfOpinionDto implements Converter<QuestionScaleOfOpinion, QuestionScaleOfOpinionDto> {
    @Override
    public QuestionScaleOfOpinionDto convert(QuestionScaleOfOpinion questionScaleOfOpinion) {
        QuestionScaleOfOpinionDto targetQuestionScaleOfOpinionDto = new QuestionScaleOfOpinionDto();

        targetQuestionScaleOfOpinionDto.setQuestionId(questionScaleOfOpinion.getQuestionId());
        targetQuestionScaleOfOpinionDto.setSurveyId(questionScaleOfOpinion.getSurveyId());
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
