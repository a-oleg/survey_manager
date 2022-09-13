package com.github.a_oleg.converters;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.entity.Survey;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SurveyDtoToSurveyConverter implements Converter<SurveyDto, Survey> {
    @Override
    public Survey convert(SurveyDto surveyDto) {
        Survey targetSurvey = new Survey();
        targetSurvey.setSurveyId(surveyDto.getSurveyId());
        targetSurvey.setCreator(surveyDto.getCreator());
        targetSurvey.setSurveyName(surveyDto.getSurveyName());
        targetSurvey.setFolderId(surveyDto.getFolderId());
        targetSurvey.setActivityStatus(surveyDto.getActivityStatus());

        return targetSurvey;
    }
}
