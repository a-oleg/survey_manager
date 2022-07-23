package com.github.a_oleg.controllers;

import com.github.a_oleg.service.SurveyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyController {
    private final SurveyManager surveyManager;
    @Autowired
    public SurveyController(SurveyManager surveyManager) {
        this.surveyManager = surveyManager;
    }

}
