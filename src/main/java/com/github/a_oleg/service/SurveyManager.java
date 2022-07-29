package com.github.a_oleg.service;

import com.github.a_oleg.exceptions.ServerException;
import org.springframework.stereotype.Service;

@Service
public class SurveyManager {
    /**Метод, создающий новый опрос*/
    public boolean creatingNewSurvey(String [] surveyData) throws ServerException {
        if(surveyData == null) {
            throw new ServerException("The surveyData array cannot have a null value");
        }
    }


}
