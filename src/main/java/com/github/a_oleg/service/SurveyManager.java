package com.github.a_oleg.service;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.exceptions.ServerException;
import org.springframework.stereotype.Service;

@Service
public class SurveyManager {
    /**Метод, создающий новый опрос*/
    public boolean creatingNewSurvey(SurveyDto surveyDto) throws ServerException {
        if(surveyDto == null) {
            throw new ServerException("The surveyData array cannot have a null value");
        }
        return false;
    }


}
