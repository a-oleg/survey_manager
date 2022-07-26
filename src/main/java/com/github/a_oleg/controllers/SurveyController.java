package com.github.a_oleg.controllers;

import com.github.a_oleg.exceptions.ClientException;
import com.github.a_oleg.exceptions.ServerException;
import com.github.a_oleg.service.SurveyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("survey")
public class SurveyController {
    private final SurveyManager surveyManager;
    @Autowired
    public SurveyController(SurveyManager surveyManager) {
        this.surveyManager = surveyManager;
    }

    @PostMapping("creating")
    public void creatingSurvey(String dataForNewSurvey) throws ClientException, ServerException {
        if(dataForNewSurvey == null) {
            throw new ClientException("The data for creating a survey cannot be null");
        }
        //Предварительный формат dataForNewSurvey: user-создатель, название опроса, папка для опроса, теги
        //Вопрос: символ ";" очень употребимый и его могут задать в имени опроса, тогда программа сломается. Как этого избежать?
        String [] surveyData = dataForNewSurvey.split(";");
        surveyManager.creatingNewSurvey(surveyData);
    }

    //Веротно, нужно спрограммировать синхронизацию для всех методов
    @PostMapping("edit")
    public void editSurvey() {

    }

    @PostMapping("delete")
    public void deleteSurvey() {

    }
}
