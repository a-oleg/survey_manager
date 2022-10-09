package com.github.a_oleg.converter;

import com.github.a_oleg.dto.questions.QuestionScaleOfOpinionDto;
import com.github.a_oleg.entity.question.QuestionScaleOfOpinion;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionScaleOfOpinionDtoToQuestionScaleOfOpinionConverter implements Converter<QuestionScaleOfOpinionDto, QuestionScaleOfOpinion> {
    @Override
    public QuestionScaleOfOpinion convert(QuestionScaleOfOpinionDto questionScaleOfOpinionDto) {
        QuestionScaleOfOpinion targetQuestionScaleOfOpinion = new QuestionScaleOfOpinion();

        targetQuestionScaleOfOpinion.setQuestionId(questionScaleOfOpinionDto.getQuestionId());
        targetQuestionScaleOfOpinion.setParentCode(questionScaleOfOpinionDto.getParentCode());
        targetQuestionScaleOfOpinion.setActivityStatus(questionScaleOfOpinionDto.isActivityStatus());
        targetQuestionScaleOfOpinion.setSurvey(questionScaleOfOpinionDto.getSurvey());
        targetQuestionScaleOfOpinion.setQuestionNumberInTheSurvey(questionScaleOfOpinionDto.getQuestionNumberInTheSurvey());
        targetQuestionScaleOfOpinion.setNextQuestionNumberInTheSurvey(questionScaleOfOpinionDto.getNextQuestionNumberInTheSurvey());
        targetQuestionScaleOfOpinion.setTypeQuestion(questionScaleOfOpinionDto.getTypeQuestion());
        targetQuestionScaleOfOpinion.setTextQuestion(questionScaleOfOpinionDto.getTextQuestion());
        targetQuestionScaleOfOpinion.setDescriptionText(questionScaleOfOpinionDto.getDescriptionText());
        targetQuestionScaleOfOpinion.setButtonText(questionScaleOfOpinionDto.getButtonText());
        targetQuestionScaleOfOpinion.setDescriptionOfAssessment(StringUtils.join(questionScaleOfOpinionDto.getDescriptionOfAssessment(), '~'));
        targetQuestionScaleOfOpinion.setHaveButtonIFindItDifficultToAnswer(questionScaleOfOpinionDto.isHaveButtonIFindItDifficultToAnswer());
        targetQuestionScaleOfOpinion.setRatingForEnteringComment(questionScaleOfOpinionDto.getRatingForEnteringComment());
        targetQuestionScaleOfOpinion.setTextInCommentField(questionScaleOfOpinionDto.getTextInTheCommentField());
        targetQuestionScaleOfOpinion.setFigureType(questionScaleOfOpinionDto.getFigureType());
        targetQuestionScaleOfOpinion.setGradientType(questionScaleOfOpinionDto.getGradientType());

        return targetQuestionScaleOfOpinion;
    }
}
