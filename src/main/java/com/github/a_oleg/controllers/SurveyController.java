package com.github.a_oleg.controllers;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.exceptions.ClientException;
import com.github.a_oleg.exceptions.ServerException;
import com.github.a_oleg.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("surveys")
public class SurveyController {
    private final SurveyService surveyService;
    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("new")
    public ResponseEntity<SurveyDto> creatingSurvey(@RequestBody SurveyDto surveyDto) throws ClientException, ServerException {
        //логирование info
        if(surveyDto == null) {
            //логирование worning
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(surveyDto);
        }
        System.out.println(surveyDto.getSurveyName());
        SurveyDto result;
        try {
            result = surveyService.createSurvey(surveyDto);
        } catch (ServerException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(surveyDto);
        }
        if(result == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(surveyDto);
        }
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
