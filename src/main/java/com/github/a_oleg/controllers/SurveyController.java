package com.github.a_oleg.controllers;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.exceptions.ClientException;
import com.github.a_oleg.exceptions.ServerException;
import com.github.a_oleg.service.SurveyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("survey")
public class SurveyController {
    private final SurveyManager surveyManager;
    @Autowired
    public SurveyController(SurveyManager surveyManager) {
        this.surveyManager = surveyManager;
    }

    @PostMapping("creating")
    public ResponseEntity<SurveyDto> creatingSurvey(SurveyDto surveyDto) throws ClientException, ServerException {

        return  ResponseEntity.status(HttpStatus.CREATED).body(surveyDto);
    }

    @GetMapping("get")
    public ResponseEntity<SurveyDto> getSurvey(String id) {
        //Нужно взять surveyDto из БД
        return  ResponseEntity.status(HttpStatus.OK).body(surveyDto);
    }

    //Веротно, нужно спрограммировать синхронизацию для всех методов
    @PutMapping("edit")
    public void editSurvey(SurveyDto surveyDto) {
        //Используя новую копию, заменим старую в БД
        //tru-catch return (код 500)  return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(surveyDto);
    }

    @DeleteMapping("delete")
    public void deleteSurvey(String id) {

    }
}
