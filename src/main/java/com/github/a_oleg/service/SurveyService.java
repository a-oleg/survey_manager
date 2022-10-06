package com.github.a_oleg.service;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.exception.ClientException;
import com.github.a_oleg.exception.ServerException;
import com.github.a_oleg.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
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
            throw new ServerException("Error: SurveyService.createSurvey - The surveyDto cannot have a null value");
        }
        Survey survey = conversionService.convert(surveyDto, Survey.class);
        return conversionService.convert(surveyRepository.save(survey), SurveyDto.class);
    }

    /**Метод, возвращающий опрос*/
    public SurveyDto getSurvey(Integer surveyId) throws ServerException {
        if(surveyId == null) {
            throw new ServerException("Error: SurveyService.getSurvey - SurveyID cannot be null");
        }
        if(surveyRepository.findById(surveyId).isPresent()) {
            Survey survey = surveyRepository.findById(surveyId).orElse(new Survey());
            return conversionService.convert(survey, SurveyDto.class);
        } else {
            throw new ServerException("Error: SurveyService.getSurvey - Failed to return survey with ID " + surveyId);
        }
    }

    /**Метод, обновляющий данные опроса*/
    public SurveyDto updateSurvey(SurveyDto surveyDto) throws ClientException {
        if(surveyDto == null) {
            throw new ClientException("Error: SurveyService.updateSurvey - The surveyDto cannot have a null value");
        }
        Survey survey = conversionService.convert(surveyDto, Survey.class);
        if(surveyRepository.findById((Integer)survey.getSurveyId()).isPresent()) {
            return conversionService.convert(surveyRepository.save(survey), SurveyDto.class);
        } else {
            throw new ClientException("Error: SurveyService.updateSurvey - Couldn't find survey with ID "
                    + surveyDto.getSurveyId());
        }
    }

    /**Метод, удаляющий опрос*/
    public SurveyDto deleteSurvey(Integer surveyId) throws ClientException {
        if(surveyId == null) {
            throw new ClientException("Error: SurveyService.deleteSurvey - SurveyID " + surveyId + " cannot be null");
        }

        if(surveyRepository.findById(surveyId).isPresent()) {
            Survey survey = surveyRepository.findById(surveyId).orElse(new Survey());
            surveyRepository.delete(survey);
            return conversionService.convert(survey, SurveyDto.class);
        } else {
            throw new ClientException("Error: SurveyService.deleteSurvey - The survey ID " + surveyId +
                    " is missing from the database");
        }
    }
}
