package com.github.a_oleg.service;

import com.github.a_oleg.dto.questions.QuestionRatingDto;
import com.github.a_oleg.dto.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.questions.QuestionRating;
import com.github.a_oleg.entity.questions.QuestionWithTextAnswer;
import com.github.a_oleg.exceptions.ClientException;
import com.github.a_oleg.exceptions.ServerException;
import com.github.a_oleg.repository.questions.QuestionRatingRepository;
import com.github.a_oleg.repository.questions.QuestionWithTextAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionWithTextAnswerRepository questionWithTextAnswerRepository;
    private final QuestionRatingRepository questionRatingRepository;
    private final ConversionService conversionService;

    @Autowired
    public QuestionService(QuestionWithTextAnswerRepository questionWithTextAnswerRepository, QuestionRatingRepository questionRatingRepository,
                           ConversionService conversionService) {
        this.questionWithTextAnswerRepository = questionWithTextAnswerRepository;
        this.questionRatingRepository = questionRatingRepository;
        this.conversionService = conversionService;
    }

    /**Метод, создающий новый вопрос с текстовым ответом*/
    public QuestionWithTextAnswerDto createQuestionWithTextAnswer(QuestionWithTextAnswerDto questionWithTextAnswerDto)
            throws ServerException {
        if(questionWithTextAnswerDto == null) {
            throw new ServerException("Error: QuestionService.createQuestionWithTextAnswer -" +
                    " The questionWithTextAnswerDto cannot have a null value");
        }
        QuestionWithTextAnswer questionWithTextAnswer = conversionService.convert(questionWithTextAnswerDto,
                QuestionWithTextAnswer.class);
        return conversionService.convert(questionWithTextAnswerRepository.save(questionWithTextAnswer),
                QuestionWithTextAnswerDto.class);
    }

    /**Метод, возвращающий вопрос с текстовым ответом*/
    public QuestionWithTextAnswerDto getQuestionWithTextAnswerDto(Integer questionId) throws ServerException {
        if(questionId == null) {
            throw new ServerException("Error: QuestionService.getQuestionWithTextAnswerDto - QuestionId cannot be null");
        }
        if(questionWithTextAnswerRepository.findById(questionId).isPresent()) {
            QuestionWithTextAnswer questionWithTextAnswer = questionWithTextAnswerRepository.
                    findById(questionId).orElse(new QuestionWithTextAnswer());
            return conversionService.convert(questionWithTextAnswer, QuestionWithTextAnswerDto.class);
        } else {
            throw new ServerException("Error: QuestionService.getQuestionWithTextAnswerDto -" +
                    " Failed to return question with ID " + questionId);
        }
    }

    /**Метод, обновляющий данные вопроса с текстовым ответом*/
    public QuestionWithTextAnswerDto updateQuestionWithTextAnswerDto(QuestionWithTextAnswerDto questionWithTextAnswerDto)
            throws ClientException {
        if(questionWithTextAnswerDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionWithTextAnswerDto -" +
                    " QuestionWithTextAnswerDto cannot be null");
        }
        QuestionWithTextAnswer questionWithTextAnswer = conversionService.convert(questionWithTextAnswerDto,
                QuestionWithTextAnswer.class);
        if(questionWithTextAnswerRepository.findById((Integer)questionWithTextAnswer.getQuestionId()).isPresent()) {
            return conversionService.convert(questionWithTextAnswerRepository.save(questionWithTextAnswer),
                    QuestionWithTextAnswerDto.class);
        } else {
            throw new ClientException("Error: QuestionService.updateQuestionWithTextAnswerDto - Couldn't find question" +
                    " with ID " + questionWithTextAnswerDto.getQuestionId());
        }
    }

    /**Метод, удаляющий вопрос с текстовым ответом*/
    public QuestionWithTextAnswerDto deleteQuestionWithTextAnswer(Integer questionId) throws ClientException {
        if(questionId == null) {
            throw new ClientException("Error: QuestionService.deleteQuestionWithTextAnswer - The questionID "
                    + questionId + " cannot be null");
        }
        if(questionWithTextAnswerRepository.findById(questionId).isPresent()) {
            QuestionWithTextAnswer questionWithTextAnswer = questionWithTextAnswerRepository.findById(questionId).orElse(new QuestionWithTextAnswer());
            questionWithTextAnswerRepository.delete(questionWithTextAnswer);
            return conversionService.convert(questionWithTextAnswer, QuestionWithTextAnswerDto.class);
        } else {
            throw new ClientException("Error: QuestionService.deleteQuestionWithTextAnswer - The question ID "
                    + questionId + " is missing from the database");
        }
    }

    /**Метод, создающий новый вопрос-рейтинг*/
    public QuestionRatingDto createQuestionRating(QuestionRatingDto questionRatingDto) throws ServerException {
        if(questionRatingDto == null) {
            throw new ServerException("Error: QuestionService.createQuestionRating - The questionRating cannot have a null value");
        }
        QuestionRating questionRating = conversionService.convert(questionRatingDto,
                QuestionRating.class);
        return conversionService.convert(questionRatingRepository.save(questionRating),
                QuestionRatingDto.class);
    }

    /**Метод, возвращающий вопрос-рейтинг*/
    public QuestionRatingDto getQuestionRating(Integer questionId) throws ServerException {
        if(questionId == null) {
            throw new ServerException("Error: QuestionService.getQuestionRating - QuestionId cannot be null");
        }
        if(questionRatingRepository.findById(questionId).isPresent()) {
            QuestionRating questionRating = questionRatingRepository.findById(questionId).orElse(new QuestionRating());
            return conversionService.convert(questionRating, QuestionRatingDto.class);
        } else {
            throw new ServerException("Error: QuestionService.getQuestionRating -" +
                    " Failed to return question with ID " + questionId);
        }
    }

    /**Метод, обновляющий данные вопроса-рейтинга*/
    public QuestionRatingDto updateQuestionRatingDto(QuestionRatingDto questionRatingDto)
            throws ClientException {
        if(questionRatingDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionRatingDto -" +
                    " QuestionWithTextAnswerDto cannot be null");
        }
        QuestionRating questionRating = conversionService.convert(questionRatingDto,
                QuestionRating.class);
        if(questionRatingRepository.findById((Integer)questionRating.getQuestionId()).isPresent()) {
            return conversionService.convert(questionRatingRepository.save(questionRating),
                    QuestionRatingDto.class);
        } else {
            throw new ClientException("Error: QuestionService.updateQuestionRatingDto - Couldn't find question" +
                    " with ID " + questionRatingDto.getQuestionId());
        }
    }

    /**Метод, удаляющий вопрос-рейтинг*/
    public QuestionRatingDto deleteQuestionRating(Integer questionId) throws ClientException {
        if(questionId == null) {
            throw new ClientException("Error: QuestionService.deleteQuestionRating - The questionID " + questionId +
                    " cannot be null");
        }
        if(questionRatingRepository.findById(questionId).isPresent()) {
            QuestionRating questionRating = questionRatingRepository.findById(questionId).orElse(new QuestionRating());
            questionRatingRepository.delete(questionRating);
            return conversionService.convert(questionRating, QuestionRatingDto.class);
        } else {
            throw new ClientException("Error: QuestionService.deleteQuestionRating - The question ID "
                    + questionId + " is missing from the database");
        }
    }
}
