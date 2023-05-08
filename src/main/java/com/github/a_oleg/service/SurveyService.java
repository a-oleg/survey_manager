package com.github.a_oleg.service;

import com.github.a_oleg.controller.questions.QuestionNPSDto;
import com.github.a_oleg.controller.questions.QuestionScaleOfOpinionDto;
import com.github.a_oleg.controller.questions.QuestionSliderDto;
import com.github.a_oleg.dto.SurveyDto;
import com.github.a_oleg.controller.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.exception.ClientException;
import com.github.a_oleg.exception.ServerException;
import com.github.a_oleg.mapper.SurveyMapper;
import com.github.a_oleg.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SurveyService {
    private final SurveyRepository surveyRepository;
    private final QuestionService questionService;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository,
                         QuestionService questionService) {
        this.surveyRepository = surveyRepository;
        this.questionService = questionService;
    }

    /**Метод, создающий новый опрос*/
    public SurveyDto createSurvey(SurveyDto surveyDto) throws ServerException {
        if(surveyDto == null) {
            throw new ServerException("Error: SurveyService.createSurvey - The surveyDto cannot have a null value");
        }
        Survey survey = SurveyMapper.INSTANCE.toSurvey(surveyDto);
        return SurveyMapper.INSTANCE.toSurveyDto(surveyRepository.save(survey));
    }

    /**Метод, возвращающий опрос с вопросами*/
    public SurveyDto getSurvey(int surveyId) throws ServerException {
        if(surveyId == 0) {
            throw new ServerException("Error: SurveyService.getSurvey - surveyId cannot be 0");
        }
        if(surveyRepository.findById((Integer)surveyId).isPresent()) {
            Survey returnedSurvey = surveyRepository.findById((Integer)surveyId).orElse(new Survey());
            SurveyDto returnedSurveyDto = SurveyMapper.INSTANCE.toSurveyDto(returnedSurvey);

            Set<QuestionWithTextAnswerDto> questionsWithTextAnswer = new HashSet<>();
            questionsWithTextAnswer.addAll(questionService.getQuestionsWithTextAnswerBySurvey(returnedSurvey));
            returnedSurveyDto.setSetQuestionsWithTextAnswerDto(questionsWithTextAnswer);

            Set<QuestionNPSDto> questionsNPS = new HashSet<>();
            questionsNPS.addAll(questionService.getQuestionsNPSBySurvey(returnedSurvey));
            returnedSurveyDto.setSetQuestionsNPSDto(questionsNPS);

            Set<QuestionScaleOfOpinionDto> questionsScaleOfOpinion = new HashSet<>();
            questionsScaleOfOpinion.addAll(questionService.getQuestionsScaleOfOpinionBySurvey(returnedSurvey));
            returnedSurveyDto.setSetQuestionsScaleOfOpinionDto(questionsScaleOfOpinion);

            Set<QuestionSliderDto> questionsSlider = new HashSet<>();
            questionsSlider.addAll(questionService.getQuestionsSliderBySurvey(returnedSurvey));
            returnedSurveyDto.setSetQuestionsSliderDto(questionsSlider);

            return returnedSurveyDto;
        } else {
            throw new ServerException("Error: SurveyService.getSurvey - Failed to return survey with ID "
                    + surveyId);
        }
    }

    /**Метод, обновляющий данные опроса*/
    public SurveyDto updateSurvey(SurveyDto surveyDto) throws ClientException {
        if(surveyDto == null) {
            throw new ClientException("Error: SurveyService.updateSurvey - The surveyDto cannot have a null value");
        }
        Survey survey = SurveyMapper.INSTANCE.toSurvey(surveyDto);
        if(surveyRepository.findById(survey.getSurveyId()) != null) {
            return SurveyMapper.INSTANCE.toSurveyDto(surveyRepository.save(survey));
        } else {
            throw new ClientException("Error: SurveyService.updateSurvey - Couldn't find survey with ID "
                    + surveyDto.getSurveyId());
        }
    }

    /**Метод, удаляющий опрос*/
    public SurveyDto deleteSurvey(Integer surveyId) throws ClientException {
        if(surveyId == null) {
            throw new ClientException("Error: SurveyService.deleteSurvey - SurveyID " + surveyId + " cannot be null");
        }
        if(surveyRepository.findById(surveyId).isPresent()) {
            Survey survey = surveyRepository.findById(surveyId).orElse(new Survey());
            surveyRepository.delete(survey);
            return SurveyMapper.INSTANCE.toSurveyDto(survey);
        } else {
            throw new ClientException("Error: SurveyService.deleteSurvey - The survey ID " + surveyId +
                    " is missing from the database");
        }
    }
}
