package com.github.a_oleg.service;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.entity.Survey;
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
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.core.convert.ConversionService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

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
    @MockitoSettings(strictness = Strictness.LENIENT) //используется из-за двух when
    void updateSurvey_whenCorrectSurveyDto_thenReturnSurveyDto() throws ClientException {
        SurveyDto savedSurveyDto = new SurveyDto(1,"TestCreator", "TestSurveyName", 1, true);
        Set<Survey> survey = new HashSet<>();
        Survey updateSurvey = new Survey(1,"TestCreator", "TestSurveyName", 1, true);
        survey.add(updateSurvey);
        when(surveyRepository.findById(anyInt())).thenReturn(survey);
        when(conversionService.convert(savedSurveyDto, Survey.class)).thenReturn(updateSurvey);
        surveyService.updateSurvey(savedSurveyDto);
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
    void createSurvey_whenSurveyIdIsZero_thenReturnException() {
        int surveyId = 0;
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            surveyService.getSurvey(surveyId);
        });
        Assertions.assertTrue(thrown.getMessage().contains("surveyId cannot be 0"));
    }

//    @Test
//    void updateSurvey_whenEmptySurvey_thenReturnEmptySurvey() throws ClientException {
//        Set<Survey> survey = new HashSet<>();
//        when(surveyRepository.findById(1)).thenReturn(survey);
//        SurveyDto updateSurveyDto = new SurveyDto(1,"TestCreator", "TestSurveyName", 1, true);
//        surveyService.updateSurvey(updateSurveyDto);
//        Mockito.verify(surveyRepository, Mockito.times(1)).save(Mockito.any());
//    }

//    @Test
//    @MockitoSettings(strictness = Strictness.LENIENT) //используется из-за двух when
//    void updateSurvey_whenCorrectSurveyDto_thenUpdateSurvey() throws ClientException {
//        Set<Survey> survey = new HashSet<>();
//        Survey updateSurvey = new Survey("TestCreator", "TestSurveyName", 1, true);
//        survey.add(updateSurvey);
//        when(surveyRepository.findById(anyInt())).thenReturn(survey);
//        when(conversionService.convert(any(), any())).thenReturn(updateSurvey);
//        SurveyDto updateSurveyDto = new SurveyDto(1,"TestCreator", "TestSurveyName", 1, true);
//        surveyService.updateSurvey(updateSurveyDto);
//        Mockito.verify(surveyRepository, Mockito.times(1)).save(Mockito.any());
//    }

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
//        SurveyDto updateSurveyDto = new SurveyDto("TestCreator", "TestSurveyName", 1, true);
//        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
//            surveyRepository.findById((Integer)updateSurveyDto.getSurveyId()).isPresent();
//        });
//        Assertions.assertTrue(thrown.getMessage().contains("Couldn't find survey with ID"));
    }

    @Test
    void deleteSurvey_whenCorrectSurveyID_thenReturnSurveyDto() throws ClientException {
        Survey testSurvey = new Survey(1, "1", "1", 1, true);
        when(surveyRepository.findById(any())).thenReturn(Optional.of(testSurvey));
        doNothing().when(surveyRepository).delete(testSurvey);
        Integer surveyID = 256;
        surveyService.deleteSurvey(surveyID);
        Mockito.verify(surveyRepository, Mockito.times(2)).findById(Mockito.any());
        Mockito.verify(surveyRepository, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void deleteSurvey_surveyActivityStatusIsFalse_thenReturnException() {
        //Сейчас метод выполняется по ID, возможно стоит переписать его на Dto
    }
}
