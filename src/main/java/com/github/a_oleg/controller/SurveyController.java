package com.github.a_oleg.controller;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.exception.ClientException;
import com.github.a_oleg.exception.ServerException;
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
    private Logger logger = LoggerFactory.getLogger(SurveyController.class);
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
        SurveyDto resultSurveyDto;
        try {
            resultSurveyDto = surveyService.createSurvey(surveyDto);
        } catch (ServerException e) {
            logger.error("Error: SurveyController.createSurvey - " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(surveyDto);
        }
        if(resultSurveyDto == null) {
            logger.error("Error: SurveyController.createSurvey - Server error when creating a survey");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(surveyDto);
        }
        logger.info("Info: SurveyController.createSurvey - The survey was successfully created");
        return ResponseEntity.status(HttpStatus.CREATED).body(resultSurveyDto);
    }

    @GetMapping("get")
    public ResponseEntity<SurveyDto> getSurvey(@RequestParam(name = "surveyId", required = true)Integer surveyId) {
        logger.info("Info: SurveyController.getSurvey - The request to return the survey from the database was accepted");
        if(surveyId == null) {
            logger.warn("Warning: SurveyController.getSurvey - The request is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        SurveyDto returnedSurveyDto;
        try {
            returnedSurveyDto = surveyService.getSurvey(surveyId);
            logger.info("Info: SurveyController.getSurvey - The survey was successfully received");
            return ResponseEntity.status(HttpStatus.OK).body(returnedSurveyDto);
        } catch (ServerException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**Метод, обновляющий данные опроса*/
    @PutMapping("update")
    public ResponseEntity<SurveyDto> updateSurvey(@RequestBody SurveyDto surveyDto) {
        logger.info("Info: SurveyController.editSurvey - The request to editSurvey the survey was accepted");
        if(surveyDto == null) {
            logger.warn("Warning: SurveyController.editSurvey - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(surveyDto);
        }
        SurveyDto updatedSurveyDto;
        try {
            updatedSurveyDto = surveyService.updateSurvey(surveyDto);
        } catch (ClientException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(surveyDto);
        }
        logger.info("Info: SurveyController.editSurvey - The survey ID " + surveyDto.getSurveyId() + " has been updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(updatedSurveyDto);
    }

    /**Метод, удаляющий опрос*/
    @DeleteMapping("delete")
    public ResponseEntity<SurveyDto> deleteSurvey(@RequestParam(name = "surveyId", required = true) Integer surveyId) {
        logger.info("Info: SurveyController.deleteSurvey - The request to delete the survey was accepted");
        if(surveyId == null) {
            logger.warn("Warning: SurveyController.deleteSurvey - The request is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        SurveyDto resultDto;
        try {
            resultDto = surveyService.deleteSurvey(surveyId);
        } catch (ClientException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if(resultDto != null) {
            logger.info("Info: SurveyController.deleteSurvey - The survey ID " + surveyId + " was successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(resultDto);
        } else {
            logger.error("Error: SurveyController.deleteSurvey - Survey ID " + resultDto.getSurveyId() + " deletion failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultDto);
        }
    }
}