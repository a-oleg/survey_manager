package com.github.a_oleg.service;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.repository.SurveyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SurveyServiceTest {
    @Mock
    SurveyRepository surveyRepository;
    @Mock
    SurveyDto surveyDto;
    @InjectMocks
    SurveyService surveyService;

//    @Test
//    whenCorrectSurveyDto_thenCreateSurveyMethodReturnSurveyDto() {
//        SurveyDto savedSurveyDto = new SurveyDto("TestCreator", "TestSurveyName", 1, true);
//        SurveyDto returnedSurveyDto = (SurveyDto)method.invoke(surveyDto, savedSurveyDto);
//        Assertions.assertTrue();
//    }
}
