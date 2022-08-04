package com.github.a_oleg.controllers;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.exceptions.ClientException;
import com.github.a_oleg.exceptions.ServerException;
import com.github.a_oleg.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("surveys")
public class SurveyController {
    Logger logger = LoggerFactory.getLogger(SurveyController.class);
    private final SurveyService surveyService;
    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("new")
    public ResponseEntity<SurveyDto> createSurvey(@RequestBody SurveyDto surveyDto) throws ClientException, ServerException {
        logger.info("Info: SurveyController.createSurvey - A request to create a new survey has been accepted");
        if(surveyDto == null) {
            logger.warn("Warning: SurveyController.createSurvey - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(surveyDto);
        }
        SurveyDto result;
        try {
            result = surveyService.createSurvey(surveyDto);
        } catch (ServerException e) {
            logger.error("Error: SurveyController.createSurvey - " + e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(surveyDto);
        }
        if(result == null) {
            logger.error("Error: SurveyController.createSurvey - Server error when creating a survey");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(surveyDto);
        }
        logger.info("Info: SurveyController.createSurvey - The survey was created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(surveyDto);
    }

//    @GetMapping("get")
//    public ResponseEntity<SurveyDto> getSurvey(String id) {
//        Нужно взять surveyDto из БД
//        return  ResponseEntity.status(HttpStatus.OK).body(surveyDto);
//    }

    //Веротно, нужно спрограммировать синхронизацию для всех методов
    @PutMapping("update")
    public void editSurvey(SurveyDto surveyDto) {
        //Используя новую копию, заменим старую в БД
        //tru-catch return (код 500)  return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(surveyDto);
    }

    @DeleteMapping("delete")
    public void deleteSurvey(String id) {

    }
}
