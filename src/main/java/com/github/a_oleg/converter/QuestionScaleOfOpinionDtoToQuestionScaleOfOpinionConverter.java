package com.github.a_oleg.converter;

import com.github.a_oleg.controller.questions.QuestionScaleOfOpinionDto;
import com.github.a_oleg.entity.question.QuestionScaleOfOpinion;
import com.github.a_oleg.repository.SurveyRepository;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionScaleOfOpinionDtoToQuestionScaleOfOpinionConverter implements Converter<QuestionScaleOfOpinionDto, QuestionScaleOfOpinion> {
    private final SurveyRepository surveyRepository;

    public QuestionScaleOfOpinionDtoToQuestionScaleOfOpinionConverter(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public QuestionScaleOfOpinion convert(QuestionScaleOfOpinionDto questionScaleOfOpinionDto) {
        QuestionScaleOfOpinion targetQuestionScaleOfOpinion = new QuestionScaleOfOpinion();

        targetQuestionScaleOfOpinion.setQuestionId(questionScaleOfOpinionDto.getQuestionId());
        targetQuestionScaleOfOpinion.setParentId(questionScaleOfOpinionDto.getParentId());
        targetQuestionScaleOfOpinion.setActivityStatus(questionScaleOfOpinionDto.isActivityStatus());
        targetQuestionScaleOfOpinion.setSurvey(surveyRepository.findById(questionScaleOfOpinionDto.getSurveyId()).stream().findFirst().get());
        targetQuestionScaleOfOpinion.setQuestionNumberInTheSurvey(questionScaleOfOpinionDto.getQuestionNumberInTheSurvey());
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
