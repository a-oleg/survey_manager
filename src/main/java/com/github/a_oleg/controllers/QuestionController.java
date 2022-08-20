package com.github.a_oleg.controllers;

import com.github.a_oleg.dto.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.exceptions.ServerException;
import com.github.a_oleg.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("questions")
public class QuestionController {
    private Logger logger = LoggerFactory.getLogger(SurveyController.class);
    private final QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping("new/withtextanswer")
    public ResponseEntity<QuestionWithTextAnswerDto> createQuestionWithTextAnswer(@RequestBody QuestionWithTextAnswerDto questionWithTextAnswerDto) {
        logger.info("Info: QuestionController.createQuestionWithTextAnswer - A request to create a new question has been accepted");
        if(questionWithTextAnswerDto == null) {
            logger.warn("Warning: QuestionController.createQuestionWithTextAnswer - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionWithTextAnswerDto);
        }
        QuestionWithTextAnswerDto resultQuestionWithTextAnswerDto;
        try {
            resultQuestionWithTextAnswerDto = questionService.createQuestionWithTextAnswer(questionWithTextAnswerDto);
        } catch (ServerException e) {
            logger.error("Error: QuestionController.createQuestionWithTextAnswer - " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(questionWithTextAnswerDto);
        }
        logger.info("Info: QuestionController.createQuestionWithTextAnswer - The question was successfully created");
        return ResponseEntity.status(HttpStatus.CREATED).body(resultQuestionWithTextAnswerDto);
    }
}
