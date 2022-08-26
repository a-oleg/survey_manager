package com.github.a_oleg.controllers;

import com.github.a_oleg.dto.questions.QuestionRatingDto;
import com.github.a_oleg.dto.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.exceptions.ClientException;
import com.github.a_oleg.exceptions.ServerException;
import com.github.a_oleg.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("questions")
public class QuestionController {
    private Logger logger = LoggerFactory.getLogger(QuestionController.class);
    private final QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /**Метод, принимающий запрос на саздание вопроса с текстовым ответом*/
    @PostMapping("new/withtextanswer")
    public ResponseEntity<QuestionWithTextAnswerDto> createQuestionWithTextAnswer(@RequestBody QuestionWithTextAnswerDto
                                                                                              questionWithTextAnswerDto) {
        logger.info("Info: QuestionController.createQuestionWithTextAnswer - A request to create a new question" +
                " has been accepted");
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

    /**Метод, принимающий запрос на возврат вопроса с текстовым ответом*/
    @GetMapping("get/withtextanswer")
    public ResponseEntity<QuestionWithTextAnswerDto> getQuestionWithTextAnswer(@RequestParam(name = "questionId",
            required = true)Integer questionId) {
        logger.info("Info: QuestionController.getQuestionWithTextAnswer - The request to return the question from the" +
                " database was accepted");
        if(questionId == null) {
            logger.warn("Warning: QuestionController.getQuestionWithTextAnswer - The request is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionWithTextAnswerDto questionWithTextAnswerDto;
        try {
            questionWithTextAnswerDto = questionService.getQuestionWithTextAnswerDto(questionId);
            logger.info("Info: QuestionController.getQuestionWithTextAnswer - The question was successfully received");
            return ResponseEntity.status(HttpStatus.OK).body(questionWithTextAnswerDto);
        } catch (ServerException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**Метод, обновляющий данные вопроса с текстовым ответом*/
    @PutMapping("update/withtextanswer")
    public ResponseEntity<QuestionWithTextAnswerDto> updateQuestionWithTextAnswer(@RequestBody QuestionWithTextAnswerDto questionWithTextAnswerDto) {
        logger.info("Info: QuestionController.updateQuestionWithTextAnswer - The request to edit question" +
                questionWithTextAnswerDto.getQuestionId() + " the question was accepted");
        if(questionWithTextAnswerDto == null) {
            logger.warn("Warning: QuestionController.updateQuestionWithTextAnswer - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionWithTextAnswerDto);
        }
        QuestionWithTextAnswerDto updatedQuestionWithTextAnswerDto;
        try {
            updatedQuestionWithTextAnswerDto = questionService.updateQuestionWithTextAnswerDto(questionWithTextAnswerDto);
        } catch (ClientException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(questionWithTextAnswerDto);
        }
        logger.info("Info: QuestionController.updateQuestionWithTextAnswer - The question ID " + questionWithTextAnswerDto.getQuestionId() + " has been updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(updatedQuestionWithTextAnswerDto);
    }

    @DeleteMapping("delete/withtextanswer")
    public ResponseEntity<QuestionWithTextAnswerDto> deleteQuestionWithTextAnswer(@RequestParam(name = "questionId",
            required = true) Integer questionId) {
        logger.info("Info: QuestionController.deleteQuestionWithTextAnswer - The request to delete the question was accepted");
        if(questionId == null) {
            logger.warn("Warning: QuestionController.deleteQuestionWithTextAnswer - The question is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionWithTextAnswerDto resultQuestionWithTextAnswerDto;
        try {
            resultQuestionWithTextAnswerDto = questionService.deleteQuestionWithTextAnswer(questionId);
        } catch (ClientException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if(resultQuestionWithTextAnswerDto != null) {
            logger.info("Info: QuestionController.deleteQuestionWithTextAnswer - The question ID " + questionId +
                    " was successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(resultQuestionWithTextAnswerDto);
        } else {
            logger.error("Error: QuestionController.deleteQuestionWithTextAnswer - Question ID " +
                    resultQuestionWithTextAnswerDto.getQuestionId() + " deletion failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultQuestionWithTextAnswerDto);
        }
    }

    /**Метод, принимающий запрос на саздание вопроса-рейтинга*/
    @PostMapping("new/rating")
    public ResponseEntity<QuestionRatingDto> createQuestionRating(@RequestBody QuestionRatingDto questionRatingDto) {
        logger.info("Info: QuestionController.createQuestionRating - A request to create a new question" +
                " has been accepted");
        if(questionRatingDto == null) {
            logger.warn("Warning: QuestionController.createQuestionRating - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionRatingDto);
        }
//        enum TypeFigure {
//            HEART,
//            SMILE,
//            STAR,
//            CIRCLE,
//            SQUARE
//        }
//
//        enum GradientType {
//            NO,
//            BLACKWHITE,
//            BLUEWHITE,
//            GRAYWHITE,
//            GREENWHITE,
//            ORANGEWHITE
//        }
//        if(questionRatingDto.getTypeFigure()) {
//
//        }
        QuestionRatingDto resultQuestionRatingDto;
        try {
            resultQuestionRatingDto = questionService.createQuestionRating(questionRatingDto);
        } catch (ServerException e) {
            logger.error("Error: QuestionController.createQuestionRating - " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(questionRatingDto);
        }
        logger.info("Info: QuestionController.createQuestionRating - The question was successfully created");
        return ResponseEntity.status(HttpStatus.CREATED).body(resultQuestionRatingDto);
    }
}
