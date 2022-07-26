package com.github.a_oleg.service;

import com.github.a_oleg.exceptions.ServerException;
import org.springframework.stereotype.Service;

@Service
public class SurveyManager {
    public boolean creatingNewSurvey(String [] surveyData) throws ServerException {
        if(surveyData == null) {
            throw new ServerException("The surveyData array cannot have a null value");
        }
        if(checkingPresenceOfSurveyInTheDatabase(surveyData) == true) {
            throw new ServerException("It is not possible to create a survey. A survey named \"" + surveyData[0] + "\" already exists in the database");
        }

    }

    private boolean checkingTheExistenceOfTheDatabase() {

    }

    //Вероятно, метод создания БД пригодится в большом количестве мест приложения. Может, его лучше куда-то вынести?
    private boolean creatindDatabase() {

    }

    private boolean checkingPresenceOfSurveyInTheDatabase(String [] surveyData) {

    }

}
