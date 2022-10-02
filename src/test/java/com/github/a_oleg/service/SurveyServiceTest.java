package com.github.a_oleg.service;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.exception.ClientException;
import com.github.a_oleg.exception.ServerException;
import com.github.a_oleg.repository.SurveyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

@ExtendWith(MockitoExtension.class)
public class SurveyServiceTest {
    @Mock
    SurveyRepository surveyRepository;
    @Mock
    ConversionService conversionService;
    @InjectMocks
    SurveyService surveyService;

    @Test
    void createSurvey_whenCorrectSurveyDto_thenReturnSurveyDto() throws ServerException {
        SurveyDto savedSurveyDto = new SurveyDto("TestCreator", "TestSurveyName", 1, true);
        surveyService.createSurvey(savedSurveyDto);
        Mockito.verify(surveyRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void createSurvey_whenSurveyDtoNull_thenReturnException() {
        SurveyDto savedSurveyDto = null;
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            surveyService.createSurvey(savedSurveyDto);
        });
        Assertions.assertTrue(thrown.getMessage().contains("The surveyDto cannot have a null value"));
    }

    @Test
    void createSurvey_whenCorrectSurveyId_thenReturnSurveyDto() throws ServerException {
        surveyService.getSurvey(256);
        Mockito.verify(surveyRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void createSurvey_whenSurveyIdIsNull_thenReturnException() {
        Integer surveyId = null;
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            surveyService.getSurvey(surveyId);
        });
        Assertions.assertTrue(thrown.getMessage().contains("SurveyID cannot be null"));
    }

    @Test
    void createSurvey_whenSurveyRepositoryReturnFalse_thenReturnException() {
        Integer surveyId = 256;
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            surveyRepository.findById(surveyId).isPresent();
        });
        Assertions.assertTrue(thrown.getMessage().contains("Failed to return survey with ID"));
    }

    @Test
    void updateSurvey_whenCorrectSurveyDto_thenUpdateSurvey() throws ClientException {
        SurveyDto updateSurveyDto = new SurveyDto("TestCreator", "TestSurveyName", 1, true);
        surveyService.updateSurvey(updateSurveyDto);
        Mockito.verify(surveyRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void updateSurvey_whenSurveyDtoNull_thenReturnException() {
        SurveyDto updateSurveyDto = null;
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            surveyService.updateSurvey(updateSurveyDto);
        });
        Assertions.assertTrue(thrown.getMessage().contains("The surveyDto cannot have a null value"));
    }

    @Test
    void updateSurvey_whenSurveyRepositoryReturnFalse_thenReturnException() {
        SurveyDto updateSurveyDto = new SurveyDto("TestCreator", "TestSurveyName", 1, true);
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            surveyRepository.findById((Integer)updateSurveyDto.getSurveyId()).isPresent();
        });
        Assertions.assertTrue(thrown.getMessage().contains("Couldn't find survey with ID"));
    }

    @Test
    void deleteSurvey_whenCorrectSurveyID_thenReturnSurveyDto() throws ClientException {
        Integer surveyID = 256;
        surveyService.deleteSurvey(surveyID);
        Mockito.verify(surveyRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void deleteSurvey_surveyActivityStatusIsFalse_thenReturnException() {
        //Сейчас метод выполняется по ID, возможно стоит переписать его на Dto
    }
}
