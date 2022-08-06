package com.github.a_oleg.service;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.exceptions.ServerException;
import com.github.a_oleg.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    private final SurveyRepository surveyRepository;
    private final ConversionService conversionService;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository, ConversionService conversionService) {
        this.surveyRepository = surveyRepository;
        this.conversionService = conversionService;
    }

    /**Метод, создающий новый опрос*/
    public SurveyDto createSurvey(SurveyDto surveyDto) throws ServerException {
        if(surveyDto == null) {
            throw new ServerException("Error: SurveyService.createSurvey - The surveyData array cannot have a null value");
        }
        Survey survey = conversionService.convert(surveyDto, Survey.class);
        return conversionService.convert(surveyRepository.save(survey), SurveyDto.class);
    }

    /**Метод, удаляющий опрос*/
    public boolean deleteSurvey(Integer surveyId) throws ServerException {
        if(surveyId == null) {
            throw new ServerException("Error: SurveyService.deleteSurvey - SurveyID cannot be null");
        }
        Survey survey = SurveyRepository.findById(surveyId);
        SurveyRepository.delete(survey);
    }
}
