package com.github.a_oleg.mapper;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.entity.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SurveyMapper {
    SurveyMapper INSTANCE = Mappers.getMapper(SurveyMapper.class);

    Survey toSurvey(SurveyDto surveyDto);
    SurveyDto toSurveyDto(Survey survey);
}
