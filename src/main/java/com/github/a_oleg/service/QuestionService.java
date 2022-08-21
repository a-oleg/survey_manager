package com.github.a_oleg.service;

import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.dto.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.questions.AbstractQuestion;
import com.github.a_oleg.entity.questions.QuestionWithTextAnswer;
import com.github.a_oleg.exceptions.ClientException;
import com.github.a_oleg.exceptions.ServerException;
import com.github.a_oleg.repository.questions.QuestionWithTextAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionWithTextAnswerRepository questionWithTextAnswerRepository;
    private final ConversionService conversionService;

    @Autowired
    public QuestionService(QuestionWithTextAnswerRepository questionWithTextAnswerRepository,
                           ConversionService conversionService) {
        this.questionWithTextAnswerRepository = questionWithTextAnswerRepository;
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

    //Переписать метод, нужно принимать QuestionDto
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
            throw new ClientException("Error: QuestionService.updateQuestionWithTextAnswerDto - Couldn't find question with ID " +
                    questionWithTextAnswerDto.getQuestionId());
        }
    }

    /**Метод, удаляющий вопрос*/
    public AbstractQuestion deleteQuestion(int questionId, String typeQuestion) throws ClientException {
        return null;
    }
}
