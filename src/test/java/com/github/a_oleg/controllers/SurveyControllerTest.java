package com.github.a_oleg.controllers;

import com.github.a_oleg.service.SurveyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SurveyControllerTest {
    @Mock
    SurveyService surveyService;
    @InjectMocks
    SurveyController surveyController;

//    @Test
//    whenCorrectPostRequest_thenReturnStatusCreated() {
//
//    }
}
