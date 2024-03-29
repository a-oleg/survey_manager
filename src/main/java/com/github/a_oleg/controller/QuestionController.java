package com.github.a_oleg.controller;

import com.github.a_oleg.controller.questions.QuestionNPSDto;
import com.github.a_oleg.controller.questions.QuestionRatingDto;
import com.github.a_oleg.controller.questions.QuestionScaleOfOpinionDto;
import com.github.a_oleg.controller.questions.QuestionSliderDto;
import com.github.a_oleg.controller.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.exception.ClientException;
import com.github.a_oleg.exception.ServerException;
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
    @CrossOrigin
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
            updatedQuestionWithTextAnswerDto = questionService.updateQuestionWithTextAnswer(questionWithTextAnswerDto);
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
    @CrossOrigin
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
    @CrossOrigin
    @PostMapping("new/slider")
    public ResponseEntity<QuestionSliderDto> createQuestionSlider(@RequestBody QuestionSliderDto questionSliderDto) {
        logger.info("Info: QuestionController.createQuestionSlider - A request to create a new question" +
                " has been accepted");
        if (questionSliderDto == null) {
            logger.warn("Warning: QuestionController.createQuestionSlider - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionSliderDto);
        }
        if(questionSliderDto.getCountOfScaleElements() < questionSliderDto.getDefaultScaleElementNumber()) {
            logger.warn("Warning: QuestionController.createQuestionSlider - DefaultScaleElementNumber (" +
                    questionSliderDto.getDefaultScaleElementNumber() + ") there can't be more CountOfScaleElements (" +
                    questionSliderDto.getCountOfScaleElements() + ")");
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
     * Метод, удаляющий вопрос-слайдер
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

    /**Метод, создающий вопрос-NPS*/
    @CrossOrigin
    @PostMapping("new/nps")
    public ResponseEntity<QuestionNPSDto> createQuestionNPS(@RequestBody QuestionNPSDto questionNpsDto) {
        logger.info("Info: QuestionController.createQuestionNPS - A request to create a new question" +
                " has been accepted");
        if (questionNpsDto == null) {
            logger.warn("Warning: QuestionController.createQuestionNPS - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionNpsDto);
        }
        QuestionNPSDto resultQuestionNPSDto;
        try {
            resultQuestionNPSDto = questionService.createQuestionNPS(questionNpsDto);
        } catch (ServerException e) {
            logger.error("Error: QuestionController.createQuestionNPS - " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(questionNpsDto);
        }
        logger.info("Info: QuestionController.createQuestionNPS - The question was successfully created");
        return ResponseEntity.status(HttpStatus.CREATED).body(resultQuestionNPSDto);
    }

    /**Метод, принимающий запрос на возврат вопроса-NPS*/
    @GetMapping("get/nps")
    public ResponseEntity<QuestionNPSDto> getQuestionNPS(@RequestParam(name = "questionId",
            required = true) Integer questionId) {
        logger.info("Info: QuestionController.getQuestionNPS - The request to return the question with text answer" +
                questionId + " from the database was accepted");
        if (questionId == null) {
            logger.warn("Warning: QuestionController.getQuestionNPS - The request is null for id" + questionId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionNPSDto questionNPSDto;
        try {
            questionNPSDto = questionService.getQuestionNPS(questionId);
            logger.info("Info: QuestionController.getQuestionNPS - The question id" + questionId +
                    " was successfully received");
            return ResponseEntity.status(HttpStatus.OK).body(questionNPSDto);
        } catch (ServerException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**Метод, обновляющий данные вопроса-NPS*/
    @PutMapping("update/nps")
    public ResponseEntity<QuestionNPSDto> updateQuestionNPS(@RequestBody QuestionNPSDto questionNPSDto) {
        logger.info("Info: QuestionController.updateQuestionNPS - The request to edit question with text" +
                " answer " + questionNPSDto.getQuestionId() + " the question was accepted");
        if (questionNPSDto == null) {
            logger.warn("Warning: QuestionController.updateQuestionNPS - The request body is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionNPSDto);
        }
        QuestionNPSDto updatedQuestionNPSDto;
        try {
            updatedQuestionNPSDto = questionService.updateQuestionNPS(questionNPSDto);
        } catch (ClientException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(questionNPSDto);
        }
        logger.info("Info: QuestionController.updateQuestionNPS - The question ID " +
                questionNPSDto.getQuestionId() + " has been updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(updatedQuestionNPSDto);
    }

    /**Метод, удаляющий вопрос-NPS*/
    @DeleteMapping("delete/nps")
    public ResponseEntity<QuestionNPSDto> deleteQuestionNPS(@RequestParam(name = "questionId",
            required = true) Integer questionId) {
        logger.info("Info: QuestionController.deleteQuestionNPS - The request to delete the question ID " +
                questionId + " was accepted");
        if (questionId == null) {
            logger.warn("Warning: QuestionController.deleteQuestionNPS - The question is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        QuestionNPSDto resultQuestionNPSDto;
        try {
            resultQuestionNPSDto = questionService.deleteQuestionNPS(questionId);
        } catch (ClientException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if (resultQuestionNPSDto != null) {
            logger.info("Info: QuestionController.deleteQuestionNPS - The question ID " + questionId +
                    " was successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(resultQuestionNPSDto);
        } else {
            logger.error("Error: QuestionController.deleteQuestionNPS - Question ID " +
                    resultQuestionNPSDto.getQuestionId() + " deletion failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultQuestionNPSDto);
        }
    }
}


