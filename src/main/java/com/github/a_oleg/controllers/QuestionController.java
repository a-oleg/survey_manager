package com.github.a_oleg.controllers;

import com.github.a_oleg.dto.questions.QuestionRatingDto;
import com.github.a_oleg.dto.questions.QuestionScaleOfOpinionDto;
import com.github.a_oleg.dto.questions.QuestionSliderDto;
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

    /**
     * Метод, принимающий запрос на саздание вопроса с текстовым ответом
     */
    @PostMapping("new/withtextanswer")
    public ResponseEntity<QuestionWithTextAnswerDto> createQuestionWithTextAnswer(@RequestBody QuestionWithTextAnswerDto
                                                                                              questionWithTextAnswerDto) {
        logger.info("Info: QuestionController.createQuestionWithTextAnswer - A request to create a new question" +
                " has been accepted");
        if (questionWithTextAnswerDto == null) {
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

    /**
     * Метод, принимающий запрос на возврат вопроса с текстовым ответом
     */
    @GetMapping("get/withtextanswer")
    public ResponseEntity<QuestionWithTextAnswerDto> getQuestionWithTextAnswer(@RequestParam(name = "questionId",
            required = true) Integer questionId) {
        logger.info("Info: QuestionController.getQuestionWithTextAnswer - The request to return the question with text answer" +
                questionId + " from the database was accepted");
        if (questionId == null) {
            logger.warn("Warning: QuestionController.getQuestionWithTextAnswer - The request is null for id" + questionId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionWithTextAnswerDto questionWithTextAnswerDto;
        try {
            questionWithTextAnswerDto = questionService.getQuestionWithTextAnswer(questionId);
            logger.info("Info: QuestionController.getQuestionWithTextAnswer - The question id" + questionId +
                    " was successfully received");
            return ResponseEntity.status(HttpStatus.OK).body(questionWithTextAnswerDto);
        } catch (ServerException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Метод, обновляющий данные вопроса с текстовым ответом
     */
    @PutMapping("update/withtextanswer")
    public ResponseEntity<QuestionWithTextAnswerDto> updateQuestionWithTextAnswer(@RequestBody QuestionWithTextAnswerDto
                                                                                              questionWithTextAnswerDto) {
        logger.info("Info: QuestionController.updateQuestionWithTextAnswer - The request to edit question with text" +
                " answer " + questionWithTextAnswerDto.getQuestionId() + " the question was accepted");
        if (questionWithTextAnswerDto == null) {
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
        logger.info("Info: QuestionController.updateQuestionWithTextAnswer - The question ID " +
                questionWithTextAnswerDto.getQuestionId() + " has been updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(updatedQuestionWithTextAnswerDto);
    }

    /**
     * Метод, удаляющий вопрос с текстовым ответом
     */
    @DeleteMapping("delete/withtextanswer")
    public ResponseEntity<QuestionWithTextAnswerDto> deleteQuestionWithTextAnswer(@RequestParam(name = "questionId",
            required = true) Integer questionId) {
        logger.info("Info: QuestionController.deleteQuestionWithTextAnswer - The request to delete the question ID " +
                questionId + " was accepted");
        if (questionId == null) {
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
        if (resultQuestionWithTextAnswerDto != null) {
            logger.info("Info: QuestionController.deleteQuestionWithTextAnswer - The question ID " + questionId +
                    " was successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(resultQuestionWithTextAnswerDto);
        } else {
            logger.error("Error: QuestionController.deleteQuestionWithTextAnswer - Question ID " +
                    resultQuestionWithTextAnswerDto.getQuestionId() + " deletion failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultQuestionWithTextAnswerDto);
        }
    }

    /**
     * Метод, принимающий запрос на саздание вопроса-рейтинга
     */
    @PostMapping("new/rating")
    public ResponseEntity<QuestionRatingDto> createQuestionRating(@RequestBody QuestionRatingDto questionRatingDto) {
        logger.info("Info: QuestionController.createQuestionRating - A request to create a new question" +
                " has been accepted");
        if (questionRatingDto == null) {
            logger.warn("Warning: QuestionController.createQuestionRating - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionRatingDto);
        }
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

    /**
     * Метод, принимающий запрос на возврат вопроса-рейтинга
     */
    @GetMapping("get/rating")
    public ResponseEntity<QuestionRatingDto> getQuestionRating(@RequestParam(name = "questionId", required = true)
                                                                   Integer questionId) {
        logger.info("Info: QuestionController.getQuestionRating - The request to return the question-rating" + questionId +
                " from the database was accepted");
        if (questionId == null) {
            logger.warn("Warning: QuestionController.getQuestionRating - The request is null for if" + questionId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionRatingDto questionRatingDto;
        try {
            questionRatingDto = questionService.getQuestionRating(questionId);
            logger.info("Info: QuestionController.getQuestionRating - The question id" + questionId +
                    " was successfully received");
            return ResponseEntity.status(HttpStatus.OK).body(questionRatingDto);
        } catch (ServerException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Метод, обновляющий данные вопроса-рейтинга
     */
    @PutMapping("update/rating")
    public ResponseEntity<QuestionRatingDto> updateQuestionRating(@RequestBody QuestionRatingDto questionRatingDto) {
        logger.info("Info: QuestionController.updateQuestionRating - The request to edit question with text" +
                " answer " + questionRatingDto.getQuestionId() + " the question was accepted");
        if (questionRatingDto == null) {
            logger.warn("Warning: QuestionController.updateQuestionRating - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionRatingDto);
        }
        QuestionRatingDto updatedQuestionRatingDto;
        try {
            updatedQuestionRatingDto = questionService.updateQuestionRating(questionRatingDto);
        } catch (ClientException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(questionRatingDto);
        }
        logger.info("Info: QuestionController.updateQuestionRating - The question ID " + questionRatingDto.getQuestionId() +
                " has been updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(updatedQuestionRatingDto);
    }

    /**
     * Метод, удаляющий вопрос-рейтинг
     */
    @DeleteMapping("delete/rating")
    public ResponseEntity<QuestionRatingDto> deleteQuestionRating(@RequestParam(name = "questionId",
            required = true) Integer questionId) {
        logger.info("Info: QuestionController.deleteQuestionRating - The request to delete the question ID "
                + questionId + " was accepted");
        if (questionId == null) {
            logger.warn("Warning: QuestionController.deleteQuestionRating - The question is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionRatingDto resultQuestionRatingDto;
        try {
            resultQuestionRatingDto = questionService.deleteQuestionRating(questionId);
        } catch (ClientException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if (resultQuestionRatingDto != null) {
            logger.info("Info: QuestionController.deleteQuestionRating - The question ID " + questionId +
                    " was successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(resultQuestionRatingDto);
        } else {
            logger.error("Error: QuestionController.deleteQuestionRating - Question ID " +
                    resultQuestionRatingDto.getQuestionId() + " deletion failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultQuestionRatingDto);
        }
    }

    /**Метод, принимающий запрос на саздание вопроса-слайдера*/
    @PostMapping("new/slider")
    public ResponseEntity<QuestionSliderDto> createQuestionSlider(@RequestBody QuestionSliderDto questionSliderDto) {
        logger.info("Info: QuestionController.createQuestionSlider - A request to create a new question" +
                " has been accepted");
        if (questionSliderDto == null) {
            logger.warn("Warning: QuestionController.createQuestionSlider - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionSliderDto);
        }
        QuestionSliderDto resultQuestionSliderDto;
        try {
            resultQuestionSliderDto = questionService.createQuestionSlider(questionSliderDto);
        } catch (ServerException e) {
            logger.error("Error: QuestionController.createQuestionSlider - " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(questionSliderDto);
        }
        logger.info("Info: QuestionController.createQuestionSlider - The question was successfully created");
        return ResponseEntity.status(HttpStatus.CREATED).body(resultQuestionSliderDto);
    }

    /**Метод, принимающий запрос на возврат вопроса-слайдера*/
    @GetMapping("get/slider")
    public ResponseEntity<QuestionSliderDto> getQuestionSlider(@RequestParam(name = "questionId",
            required = true) Integer questionId) {
        logger.info("Info: QuestionController.getQuestionSlider - The request to return the question with text answer" +
                questionId + " from the database was accepted");
        if (questionId == null) {
            logger.warn("Warning: QuestionController.getQuestionSlider - The request is null for id" + questionId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionSliderDto questionSliderDto;
        try {
            questionSliderDto = questionService.getQuestionSlider(questionId);
            logger.info("Info: QuestionController.getQuestionSlider - The question id" + questionId +
                    " was successfully received");
            return ResponseEntity.status(HttpStatus.OK).body(questionSliderDto);
        } catch (ServerException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**Метод, обновляющий данные вопроса-слайдера*/
    @PutMapping("update/slider")
    public ResponseEntity<QuestionSliderDto> updateQuestionSlider(@RequestBody QuestionSliderDto questionSliderDto) {
        logger.info("Info: QuestionController.updateQuestionSlider - The request to edit question with text" +
                " answer " + questionSliderDto.getQuestionId() + " the question was accepted");
        if (questionSliderDto == null) {
            logger.warn("Warning: QuestionController.updateQuestionSlider - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionSliderDto);
        }
        QuestionSliderDto updatedQuestionSliderDto;
        try {
            updatedQuestionSliderDto = questionService.updateQuestionSlider(questionSliderDto);
        } catch (ClientException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(questionSliderDto);
        }
        logger.info("Info: QuestionController.updateQuestionSlider - The question ID " +
                questionSliderDto.getQuestionId() + " has been updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(updatedQuestionSliderDto);
    }


    /**
     * Метод, удаляющий вопрос с текстовым ответом
     */
    @DeleteMapping("delete/slider")
    public ResponseEntity<QuestionSliderDto> deleteQuestionSlider(@RequestParam(name = "questionId",
            required = true) Integer questionId) {
        logger.info("Info: QuestionController.deleteQuestionSlider - The request to delete the question ID " +
                questionId + " was accepted");
        if (questionId == null) {
            logger.warn("Warning: QuestionController.deleteQuestionSlider - The question is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionSliderDto resultQuestionSliderDto;
        try {
            resultQuestionSliderDto = questionService.deleteQuestionSlider(questionId);
        } catch (ClientException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if (resultQuestionSliderDto != null) {
            logger.info("Info: QuestionController.deleteQuestionSlider - The question ID " + questionId +
                    " was successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(resultQuestionSliderDto);
        } else {
            logger.error("Error: QuestionController.deleteQuestionSlider - Question ID " +
                    resultQuestionSliderDto.getQuestionId() + " deletion failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultQuestionSliderDto);
        }
    }

    /**Метод, принимающий запрос на саздание вопроса-шкалы мнения*/
    @PostMapping("new/scaleofopinion")
    public ResponseEntity<QuestionScaleOfOpinionDto> createQuestionScaleOfOpinion(@RequestBody QuestionScaleOfOpinionDto
                                                                                              questionScaleOfOpinionDto) {
        logger.info("Info: QuestionController.createQuestionScaleOfOpinion - A request to create a new question" +
                " has been accepted");
        if (questionScaleOfOpinionDto == null) {
            logger.warn("Warning: QuestionController.createQuestionScaleOfOpinion - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionScaleOfOpinionDto);
        }
        QuestionScaleOfOpinionDto resultQuestionScaleOfOpinionDto;
        try {
            resultQuestionScaleOfOpinionDto = questionService.createQuestionScaleOfOpinion(questionScaleOfOpinionDto);
        } catch (ServerException e) {
            logger.error("Error: QuestionController.createQuestionScaleOfOpinion - " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(questionScaleOfOpinionDto);
        }
        logger.info("Info: QuestionController.createQuestionScaleOfOpinion - The question was successfully created");
        return ResponseEntity.status(HttpStatus.CREATED).body(resultQuestionScaleOfOpinionDto);
    }

    /**Метод, принимающий запрос на возврат вопроса-шкалы мнения*/
    @GetMapping("get/scaleofopinion")
    public ResponseEntity<QuestionScaleOfOpinionDto> getQuestionScaleOfOpinion(@RequestParam(name = "questionId",
            required = true) Integer questionId) {
        logger.info("Info: QuestionController.getQuestionScaleOfOpinion - The request to return the question with text answer" +
                questionId + " from the database was accepted");
        if (questionId == null) {
            logger.warn("Warning: QuestionController.getQuestionScaleOfOpinion - The request is null for id" + questionId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionScaleOfOpinionDto questionScaleOfOpinionDto;
        try {
            questionScaleOfOpinionDto = questionService.getQuestionScaleOfOpinion(questionId);
            logger.info("Info: QuestionController.getQuestionScaleOfOpinion - The question id" + questionId +
                    " was successfully received");
            return ResponseEntity.status(HttpStatus.OK).body(questionScaleOfOpinionDto);
        } catch (ServerException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**Метод, обновляющий данные вопроса-шкалы мнения*/
    @PutMapping("update/scaleofopinion")
    public ResponseEntity<QuestionScaleOfOpinionDto> updateQuestionScaleOfOpinion(@RequestBody QuestionScaleOfOpinionDto
                                                                                              questionScaleOfOpinionDto) {
        logger.info("Info: QuestionController.updateQuestionScaleOfOpinion - The request to edit question with text" +
                " answer " + questionScaleOfOpinionDto.getQuestionId() + " the question was accepted");
        if (questionScaleOfOpinionDto == null) {
            logger.warn("Warning: QuestionController.updateQuestionScaleOfOpinion - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionScaleOfOpinionDto);
        }
        QuestionScaleOfOpinionDto updatedQuestionScaleOfOpinionDto;
        try {
            updatedQuestionScaleOfOpinionDto = questionService.updateQuestionScaleOfOpinion(questionScaleOfOpinionDto);
        } catch (ClientException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(questionScaleOfOpinionDto);
        }
        logger.info("Info: QuestionController.updateQuestionScaleOfOpinion - The question ID " +
                questionScaleOfOpinionDto.getQuestionId() + " has been updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(updatedQuestionScaleOfOpinionDto);
    }

    /**Метод, удаляющий вопроса-шкалы мнения*/
    @DeleteMapping("delete/scaleofopinion")
    public ResponseEntity<QuestionScaleOfOpinionDto> deleteQuestionScaleOfOpinion(@RequestParam(name = "questionId",
            required = true) Integer questionId) {
        logger.info("Info: QuestionController.deleteQuestionScaleOfOpinion - The request to delete the question ID " +
                questionId + " was accepted");
        if (questionId == null) {
            logger.warn("Warning: QuestionController.deleteQuestionScaleOfOpinion - The question is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionScaleOfOpinionDto resultQuestionScaleOfOpinionDto;
        try {
            resultQuestionScaleOfOpinionDto = questionService.deleteQuestionScaleOfOpinion(questionId);
        } catch (ClientException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if (resultQuestionScaleOfOpinionDto != null) {
            logger.info("Info: QuestionController.deleteQuestionScaleOfOpinion - The question ID " + questionId +
                    " was successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(resultQuestionScaleOfOpinionDto);
        } else {
            logger.error("Error: QuestionController.deleteQuestionScaleOfOpinion - Question ID " +
                    resultQuestionScaleOfOpinionDto.getQuestionId() + " deletion failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultQuestionScaleOfOpinionDto);
        }
    }
}
