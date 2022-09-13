package com.github.a_oleg.converters;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.entity.Survey;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SurveyToSurveyDtoConverter implements Converter<Survey, SurveyDto> {
    @Override
    public SurveyDto convert(Survey survey) {
        SurveyDto targetSurveyDto = new SurveyDto();
        targetSurveyDto.setSurveyId(survey.getSurveyId());
        targetSurveyDto.setCreator(survey.getCreator());
        targetSurveyDto.setSurveyName(survey.getSurveyName());
        targetSurveyDto.setFolderId(survey.getFolderId());
        targetSurveyDto.setActivityStatus(survey.getActivityStatus());

        return targetSurveyDto;
    }
}
