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

    public SurveyDto getSurvey(Integer surveyId) throws ServerException {
        if(surveyId == null) {
            throw new ServerException("Error: SurveyService.getSurvey - SurveyID cannot be null");
        }
        if(surveyRepository.findById(surveyId).isPresent()) {
            Survey survey = surveyRepository.findById(surveyId).orElse(new Survey());
            return conversionService.convert(surveyRepository.save(survey), SurveyDto.class);
        } else {
            throw new ServerException("Error: SurveyService.getSurvey - Failed to return survey with ID " + surveyId);
        }
    }

    /**Метод, удаляющий опрос*/
    public boolean deleteSurvey(Integer surveyId) throws ServerException {
        //Вопрос: у нас два exception - один, что surveyId не может быть null и эту ошибку нужно вернуть пользователю. А второй exception, что опроса уже нет в базе данных и в этом случае нужно вернуть клиенту инфу, что всё ок, опрос уже удалён. Как возвращать разные коды от одного ServerException?
        if(surveyId == null) {
            throw new ServerException("Error: SurveyService.deleteSurvey - SurveyID cannot be null");
        }
        if(surveyRepository.findById(surveyId).isPresent()) {
            Survey survey = surveyRepository.findById(surveyId).orElse(new Survey());
            surveyRepository.delete(survey);
            return true;
        } else {
            throw new ServerException("Error: SurveyService.deleteSurvey - The survey ID " + surveyId + " is missing from the database");
        }
    }
}
