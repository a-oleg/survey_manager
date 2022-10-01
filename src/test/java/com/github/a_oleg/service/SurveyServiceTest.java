package com.github.a_oleg.service;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.exception.ServerException;
import com.github.a_oleg.repository.SurveyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SurveyServiceTest {
    @Mock
    SurveyRepository surveyRepository;
    @Mock
    ConversionService conversionService;
    @InjectMocks
    SurveyService surveyService;

    @Test
    void whenCorrectSurveyDto_thenCreateSurveyMethodReturnSurveyDto() throws ServerException {
        SurveyDto savedSurveyDto = new SurveyDto("TestCreator", "TestSurveyName", 1, true);
        surveyService.createSurvey(savedSurveyDto);
        verify(surveyRepository, times(1)).save(any());
    }

    @Test
    void whenSurveyDtoNull_thenReturnException() throws ServerException {
        SurveyDto savedSurveyDto = null;
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            surveyService.createSurvey(savedSurveyDto);
        });
        Assertions.assertTrue(thrown.getMessage().contains("The surveyDto cannot have a null value"));
    }

    @Test
    void whenCorrectSurveyId_thenReturnSurveyDto() {
        int surveyId = 123;
    }
}
