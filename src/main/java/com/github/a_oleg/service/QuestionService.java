package com.github.a_oleg.service;

import com.github.a_oleg.dto.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.questions.QuestionWithTextAnswer;
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
    public QuestionService(QuestionWithTextAnswerRepository questionWithTextAnswerRepository, ConversionService conversionService) {
        this.questionWithTextAnswerRepository = questionWithTextAnswerRepository;
        this.conversionService = conversionService;
    }

    /**Метод, создающий новый вопрос с текстовым ответом*/
    public QuestionWithTextAnswerDto createQuestionWithTextAnswer(QuestionWithTextAnswerDto questionWithTextAnswerDto) throws ServerException {
        if(questionWithTextAnswerDto == null) {
            throw new ServerException("Error: QuestionService.createQuestionWithTextAnswer - The questionWithTextAnswerDto cannot have a null value");
        }
        QuestionWithTextAnswer questionWithTextAnswer = conversionService.convert(questionWithTextAnswerDto, QuestionWithTextAnswer.class);
        return conversionService.convert(QuestionWithTextAnswerRepository.save(questionWithTextAnswer), QuestionWithTextAnswerDto.class);
    }
}
