package com.github.a_oleg.service;

import com.github.a_oleg.controller.questions.QuestionNPSDto;
import com.github.a_oleg.controller.questions.QuestionRatingDto;
import com.github.a_oleg.controller.questions.QuestionSliderDto;
import com.github.a_oleg.controller.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.question.*;
import com.github.a_oleg.exception.ClientException;
import com.github.a_oleg.exception.ServerException;
import com.github.a_oleg.mapper.QuestionMapper;
import com.github.a_oleg.repository.questions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class QuestionService {
    private final QuestionWithTextAnswerRepository questionWithTextAnswerRepository;
    private final QuestionRatingRepository questionRatingRepository;
    private final QuestionSliderRepository questionSliderRepository;
    private final QuestionScaleOfOpinionRepository questionScaleOfOpinionRepository;
    private final QuestionNPSRepository questionNPSRepository;

    @Autowired
    public QuestionService(QuestionWithTextAnswerRepository questionWithTextAnswerRepository,
                           QuestionRatingRepository questionRatingRepository,
                           QuestionSliderRepository questionSliderRepository,
                           QuestionScaleOfOpinionRepository questionScaleOfOpinionRepository,
                           QuestionNPSRepository questionNPSRepository) {
        this.questionWithTextAnswerRepository = questionWithTextAnswerRepository;
        this.questionRatingRepository = questionRatingRepository;
        this.questionSliderRepository = questionSliderRepository;
        this.questionScaleOfOpinionRepository = questionScaleOfOpinionRepository;
        this.questionNPSRepository = questionNPSRepository;
    }

    /**Метод, создающий новый вопрос с текстовым ответом*/
    public QuestionWithTextAnswerDto createQuestionWithTextAnswer(QuestionWithTextAnswerDto questionWithTextAnswerDto)
            throws ServerException {
        if(questionWithTextAnswerDto == null) {
            throw new ServerException("Error: QuestionService.createQuestionWithTextAnswer -" +
                    " The questionDto cannot have a null value");
        }
        QuestionWithTextAnswer questionWithTextAnswer =
                QuestionMapper.INSTANCE.toQuestionWithTextAnswer(questionWithTextAnswerDto);
        return QuestionMapper.INSTANCE.toQuestionWithTextAnswerDto(
                questionWithTextAnswerRepository.save(questionWithTextAnswer));
    }

    /**Метод, возвращающий вопрос с текстовым ответом по ID*/
    public QuestionWithTextAnswerDto getQuestionWithTextAnswer(Integer questionId) throws ServerException {
        if(questionId == null) {
            throw new ServerException("Error: QuestionService.getQuestionWithTextAnswer - QuestionId cannot be null");
        }

        if(questionWithTextAnswerRepository.findById(questionId).isPresent()) {
            QuestionWithTextAnswer questionWithTextAnswer = questionWithTextAnswerRepository.
                    findById(questionId).orElse(new QuestionWithTextAnswer());
            return QuestionMapper.INSTANCE.toQuestionWithTextAnswerDto(questionWithTextAnswer);
        } else {
            throw new ServerException("Error: QuestionService.getQuestionWithTextAnswer -" +
                    " Failed to return question with ID " + questionId);
        }
    }

    /**Метод, возвращающий все вопросы с текстовым ответом по объекту-опросу*/
    public Set<QuestionWithTextAnswerDto> getQuestionsWithTextAnswerBySurvey(Survey survey) throws ServerException {
        if(survey == null) {
            throw new ServerException("Error: QuestionService.getQuestionWithTextAnswerByIDSurvey - Survey cannot be null");
        }

        if(!questionWithTextAnswerRepository.findBySurvey(survey).isEmpty()) {
            Set<QuestionWithTextAnswer> questionsWithTextAnswers = questionWithTextAnswerRepository.findBySurvey(survey);
            Set<QuestionWithTextAnswerDto> questionWithTextAnswerDtos = new HashSet<>();
            for(QuestionWithTextAnswer questionWithTextAnswer : questionsWithTextAnswers) {
                questionWithTextAnswerDtos.add(QuestionMapper.INSTANCE.toQuestionWithTextAnswerDto(questionWithTextAnswer));
            }
            return questionWithTextAnswerDtos;
        } else {
            throw new ServerException("Error: QuestionService.getQuestionWithTextAnswerByIDSurvey -" +
                    " Failed to return question with ID " + survey.getSurveyId());
        }
    }

    /**Метод, обновляющий данные вопроса с текстовым ответом по ID*/
    public QuestionWithTextAnswerDto updateQuestionWithTextAnswer(QuestionWithTextAnswerDto questionWithTextAnswerDto)
            throws ClientException {
        if(questionWithTextAnswerDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionWithTextAnswer - Question cannot be null");
        }

        QuestionWithTextAnswer questionWithTextAnswer =
                QuestionMapper.INSTANCE.toQuestionWithTextAnswer(questionWithTextAnswerDto);
        if(questionWithTextAnswerRepository.findById((Integer)questionWithTextAnswer.getQuestionId()).isPresent()) {
            return QuestionMapper.INSTANCE.toQuestionWithTextAnswerDto(
                    questionWithTextAnswerRepository.save(questionWithTextAnswer));
        } else {
            throw new ClientException("Error: QuestionService.updateQuestionWithTextAnswer - Couldn't find question" +
                    " with ID " + questionWithTextAnswerDto.getQuestionId());
        }
    }

    /**Метод, удаляющий вопрос с текстовым ответом по ID*/
    public QuestionWithTextAnswerDto deleteQuestionWithTextAnswer(Integer questionId) throws ClientException {
        if(questionId == null) {
            throw new ClientException("Error: QuestionService.deleteQuestionWithTextAnswer - The questionID "
                    + questionId + " cannot be null");
        }

        if(questionWithTextAnswerRepository.findById(questionId).isPresent()) {
            QuestionWithTextAnswer questionWithTextAnswer = questionWithTextAnswerRepository.findById(questionId)
                    .orElse(new QuestionWithTextAnswer());
            questionWithTextAnswerRepository.delete(questionWithTextAnswer);
            return QuestionMapper.INSTANCE.toQuestionWithTextAnswerDto(
                    questionWithTextAnswerRepository.save(questionWithTextAnswer));
        } else {
            throw new ClientException("Error: QuestionService.deleteQuestionWithTextAnswer - The question ID "
                    + questionId + " is missing from the database");
        }
    }

    /**Метод, создающий новый вопрос-рейтинг*/
    public QuestionRatingDto createQuestionRating(QuestionRatingDto questionRatingDto) throws ServerException {
        if(questionRatingDto == null) {
            throw new ServerException("Error: QuestionService.createQuestionRating -" +
                    "The questionRating cannot have a null value");
        }

        QuestionRating questionRating = QuestionMapper.INSTANCE.toQuestionRating(questionRatingDto);
        return QuestionMapper.INSTANCE.toQuestionRatingDto(questionRatingRepository.save(questionRating));
    }

    /**Метод, возвращающий вопрос-рейтинг по ID*/
    public QuestionRatingDto getQuestionRating(Integer questionId) throws ServerException {
        if(questionId == null) {
            throw new ServerException("Error: QuestionService.getQuestionRating - QuestionId cannot be null");
        }

        if(questionRatingRepository.findById(questionId).isPresent()) {
            QuestionRating questionRating = questionRatingRepository.findById(questionId).orElse(new QuestionRating());
            return QuestionMapper.INSTANCE.toQuestionRatingDto(questionRating);
        } else {
            throw new ServerException("Error: QuestionService.getQuestionRating -" +
                    " Failed to return question with ID " + questionId);
        }
    }

    /**Метод, обновляющий данные вопроса-рейтинга по ID*/
    public QuestionRatingDto updateQuestionRating(QuestionRatingDto questionRatingDto)
            throws ClientException {
        if(questionRatingDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionRatingDto -" +
                    " Question cannot be null");
        }

        QuestionRating questionRating = QuestionMapper.INSTANCE.toQuestionRating(questionRatingDto);
        if(questionRatingRepository.findById((Integer)questionRating.getQuestionId()).isPresent()) {
            return QuestionMapper.INSTANCE.toQuestionRatingDto(questionRatingRepository.save(questionRating));
        } else {
            throw new ClientException("Error: QuestionService.updateQuestionRatingDto - Couldn't find question" +
                    " with ID " + questionRatingDto.getQuestionId());
        }
    }

    /**Метод, удаляющий вопрос-рейтинг по ID*/
    public QuestionRatingDto deleteQuestionRating(Integer questionId) throws ClientException {
        if(questionId == null) {
            throw new ClientException("Error: QuestionService.deleteQuestionRating - The questionID " + questionId +
                    " cannot be null");
        }

        if(questionRatingRepository.findById(questionId).isPresent()) {
            QuestionRating questionRating = questionRatingRepository.findById(questionId).orElse(new QuestionRating());
            questionRatingRepository.delete(questionRating);
            return QuestionMapper.INSTANCE.toQuestionRatingDto(questionRating);
        } else {
            throw new ClientException("Error: QuestionService.deleteQuestionRating - The question ID "
                    + questionId + " is missing from the database");
        }
    }

    /**Метод, создающий новый вопрос-слайдер*/
    public QuestionSliderDto createQuestionSlider(QuestionSliderDto questionSliderDto)
            throws ServerException {
        if(questionSliderDto == null) {
            throw new ServerException("Error: QuestionService.createQuestionSlider -" +
                    " The questionDto cannot have a null value");
        }

        QuestionSlider questionSlider = QuestionMapper.INSTANCE.toQuestionSlider(questionSliderDto);
        return QuestionMapper.INSTANCE.toQuestionSliderDto(questionSliderRepository.save(questionSlider));
    }

    /**Метод, возвращающий вопрос-слайдер по ID*/
    public QuestionSliderDto getQuestionSlider(Integer questionId) throws ServerException {
        if(questionId == null) {
            throw new ServerException("Error: QuestionService.getQuestionSlider - QuestionId cannot be null");
        }
        if(questionSliderRepository.findById(questionId).isPresent()) {
            QuestionSlider questionSlider = questionSliderRepository.findById(questionId).orElse(new QuestionSlider());
            return QuestionMapper.INSTANCE.toQuestionSliderDto(questionSlider);
        } else {
            throw new ServerException("Error: QuestionService.getQuestionSlider -" +
                    " Failed to return question with ID " + questionId);
        }
    }

    /**Метод, возвращающий все вопросы-рейтинги по объекту-опросу*/
    public Set<QuestionSliderDto> getQuestionsSliderBySurvey(Survey survey) throws ServerException {
        if(survey == null) {
            throw new ServerException("Error: QuestionService.getQuestionsSliderBySurvey - Survey cannot be null");
        }

        if(!questionWithTextAnswerRepository.findBySurvey(survey).isEmpty()) {
            Set<QuestionSlider> questionsSlider = questionSliderRepository.findBySurvey(survey);
            Set<QuestionSliderDto> questionSliderDtos = new HashSet<>();
            for(QuestionSlider questionSlider : questionsSlider) {
                questionSliderDtos.add(QuestionMapper.INSTANCE.toQuestionSliderDto(questionSlider));
            }
            return questionSliderDtos;
        } else {
            throw new ServerException("Error: QuestionService.getQuestionsSliderBySurvey -" +
                    " Failed to return question with ID " + survey.getSurveyId());
        }
    }

    /**Метод, обновляющий данные вопроса-слайдера по ID*/
    public QuestionSliderDto updateQuestionSlider(QuestionSliderDto questionSliderDto) throws ClientException {
        if(questionSliderDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionSliderDto - Question cannot be null");
        }

        QuestionSlider questionSlider = QuestionMapper.INSTANCE.toQuestionSlider(questionSliderDto);
        if(questionWithTextAnswerRepository.findById((Integer)questionSlider.getQuestionId()).isPresent()) {
            return QuestionMapper.INSTANCE.toQuestionSliderDto(questionSliderRepository.save(questionSlider));
        } else {
            throw new ClientException("Error: QuestionService.updateQuestionSliderDto - Couldn't find question" +
                    " with ID " + questionSlider.getQuestionId());
        }
    }

    /**Метод, удаляющий вопрос-слайдер по ID*/
    public QuestionSliderDto deleteQuestionSlider(Integer questionId) throws ClientException {
        if(questionId == null) {
            throw new ClientException("Error: QuestionService.deleteQuestionSlider - The questionID "
                    + questionId + " cannot be null");
        }

        if(questionSliderRepository.findById(questionId).isPresent()) {
            QuestionSlider questionSlider = questionSliderRepository.findById(questionId).orElse(new QuestionSlider());
            questionSliderRepository.delete(questionSlider);
            return QuestionMapper.INSTANCE.toQuestionSliderDto(questionSlider);
        } else {
            throw new ClientException("Error: QuestionService.deleteQuestionSlider - The question ID "
                    + questionId + " is missing from the database");
        }
    }

    /**Метод, создающий новый вопрос-NPS*/
    public QuestionNPSDto createQuestionNPS(QuestionNPSDto questionNPSDto)
            throws ServerException {
        if(questionNPSDto == null) {
            throw new ServerException("Error: QuestionService.createQuestionNPS -" +
                    " The questionDto cannot have a null value");
        }
        QuestionNPS questionNPS = QuestionMapper.INSTANCE.toQuestionNPS(questionNPSDto);
        return QuestionMapper.INSTANCE.toQuestionNPSDto(questionNPSRepository.save(questionNPS));
    }

    /**Метод, возвращающий вопрос-NPS по ID*/
    public QuestionNPSDto getQuestionNPS(Integer questionId) throws ServerException {
        if(questionId == null) {
            throw new ServerException("Error: QuestionService.getQuestionNPS - QuestionId cannot be null");
        }
        if(questionNPSRepository.findById(questionId).isPresent()) {
            QuestionNPS questionNPS = questionNPSRepository.findById(questionId).orElse(new QuestionNPS());
            return QuestionMapper.INSTANCE.toQuestionNPSDto(questionNPS);
        } else {
            throw new ServerException("Error: QuestionService.getQuestionNPS -" +
                    " Failed to return question with ID " + questionId);
        }
    }

    /**Метод, возвращающий все вопросы с текстовым ответом по объекту-опросу*/
    public Set<QuestionNPSDto> getQuestionsNPSBySurvey(Survey survey) throws ServerException {
        if(survey == null) {
            throw new ServerException("Error: QuestionService.getQuestionsNPSByIDSurvey - Survey cannot be null");
        }
        if(!questionNPSRepository.findBySurvey(survey).isEmpty()) {
            Set<QuestionNPS> questionsNPS = questionNPSRepository.findBySurvey(survey);
            Set<QuestionNPSDto> questionNPSDtos = new HashSet<>();
            for(QuestionNPS questionNPS : questionsNPS) {
                questionNPSDtos.add(QuestionMapper.INSTANCE.toQuestionNPSDto(questionNPS));
            }
            return questionNPSDtos;
        } else {
            throw new ServerException("Error: QuestionService.getQuestionsNPSByIDSurvey -" +
                    " Failed to return question with ID " + survey.getSurveyId());
        }
    }

    /**Метод, обновляющий данные вопроса-NPS по ID*/
    public QuestionNPSDto updateQuestionNPS(QuestionNPSDto questionNPSDto)
            throws ClientException {
        if(questionNPSDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionNPS - Question cannot be null");
        }
        QuestionNPS questionNPS = QuestionMapper.INSTANCE.toQuestionNPS(questionNPSDto);
        if(questionWithTextAnswerRepository.findById((Integer)questionNPS.getQuestionId()).isPresent()) {
            return QuestionMapper.INSTANCE.toQuestionNPSDto(questionNPSRepository.save(questionNPS));
        } else {
            throw new ClientException("Error: QuestionService.updateQuestionNPS - Couldn't find question" +
                    " with ID " + questionNPSDto.getQuestionId());
        }
    }

    /**Метод, удаляющий вопрос-NPS по ID*/
    public QuestionNPSDto deleteQuestionNPS(Integer questionId) throws ClientException {
        if(questionId == null) {
            throw new ClientException("Error: QuestionService.deleteQuestionNPS - The questionID "
                    + questionId + " cannot be null");
        }
        if(questionNPSRepository.findById(questionId).isPresent()) {
            QuestionNPS questionNPS = questionNPSRepository.findById(questionId).orElse(new QuestionNPS());
            questionNPSRepository.delete(questionNPS);
            return QuestionMapper.INSTANCE.toQuestionNPSDto(questionNPS);
        } else {
            throw new ClientException("Error: QuestionService.deleteQuestionNPS - The question ID "
                    + questionId + " is missing from the database");
        }
    }
}
