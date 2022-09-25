package com.github.a_oleg.service;

import com.github.a_oleg.dto.questions.*;
import com.github.a_oleg.entity.questions.*;
import com.github.a_oleg.exceptions.ClientException;
import com.github.a_oleg.exceptions.ServerException;
import com.github.a_oleg.repository.questions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionWithTextAnswerRepository questionWithTextAnswerRepository;
    private final QuestionRatingRepository questionRatingRepository;
    private final QuestionSliderRepository questionSliderRepository;
    private final QuestionScaleOfOpinionRepository questionScaleOfOpinionRepository;
    private final QuestionNPSRepository questionNPSRepository;
    private final ConversionService conversionService;

    @Autowired
    public QuestionService(QuestionWithTextAnswerRepository questionWithTextAnswerRepository,
                           QuestionRatingRepository questionRatingRepository,
                           QuestionSliderRepository questionSliderRepository,
                           QuestionScaleOfOpinionRepository questionScaleOfOpinionRepository,
                           QuestionNPSRepository questionNPSRepository,
                           ConversionService conversionService) {
        this.questionWithTextAnswerRepository = questionWithTextAnswerRepository;
        this.questionRatingRepository = questionRatingRepository;
        this.questionSliderRepository = questionSliderRepository;
        this.questionScaleOfOpinionRepository = questionScaleOfOpinionRepository;
        this.questionNPSRepository = questionNPSRepository;
        this.conversionService = conversionService;
    }

    /**Метод, создающий новый вопрос с текстовым ответом*/
    public QuestionWithTextAnswerDto createQuestionWithTextAnswer(QuestionWithTextAnswerDto questionWithTextAnswerDto)
            throws ServerException {
        if(questionWithTextAnswerDto == null) {
            throw new ServerException("Error: QuestionService.createQuestionWithTextAnswer -" +
                    " The questionDto cannot have a null value");
        }
        QuestionWithTextAnswer questionWithTextAnswer = conversionService.convert(questionWithTextAnswerDto,
                QuestionWithTextAnswer.class);
        return conversionService.convert(questionWithTextAnswerRepository.save(questionWithTextAnswer),
                QuestionWithTextAnswerDto.class);
    }

    /**Метод, возвращающий вопрос с текстовым ответом*/
    public QuestionWithTextAnswerDto getQuestionWithTextAnswer(Integer questionId) throws ServerException {
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
    public QuestionWithTextAnswerDto updateQuestionWithTextAnswer(QuestionWithTextAnswerDto questionWithTextAnswerDto)
            throws ClientException {
        if(questionWithTextAnswerDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionWithTextAnswerDto -" +
                    " Question cannot be null");
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
    public QuestionRatingDto updateQuestionRating(QuestionRatingDto questionRatingDto)
            throws ClientException {
        if(questionRatingDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionRatingDto -" +
                    " Question cannot be null");
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

    /**Метод, создающий новый вопрос-слайдер*/
    public QuestionSliderDto createQuestionSlider(QuestionSliderDto questionSliderDto)
            throws ServerException {
        if(questionSliderDto == null) {
            throw new ServerException("Error: QuestionService.createQuestionSlider -" +
                    " The questionDto cannot have a null value");
        }
        QuestionSlider questionSlider = conversionService.convert(questionSliderDto, QuestionSlider.class);
        return conversionService.convert(questionSliderRepository.save(questionSlider), QuestionSliderDto.class);
    }

    /**Метод, возвращающий вопрос-слайдер*/
    public QuestionSliderDto getQuestionSlider(Integer questionId) throws ServerException {
        if(questionId == null) {
            throw new ServerException("Error: QuestionService.getQuestionSlider - QuestionId cannot be null");
        }
        if(questionSliderRepository.findById(questionId).isPresent()) {
            QuestionSlider questionSlider = questionSliderRepository.findById(questionId).orElse(new QuestionSlider());
            return conversionService.convert(questionSlider, QuestionSliderDto.class);
        } else {
            throw new ServerException("Error: QuestionService.getQuestionSlider -" +
                    " Failed to return question with ID " + questionId);
        }
    }

    /**Метод, обновляющий данные вопроса-слайдера*/
    public QuestionSliderDto updateQuestionSlider(QuestionSliderDto questionSliderDto) throws ClientException {
        if(questionSliderDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionSliderDto - Question cannot be null");
        }
        QuestionSlider questionSlider = conversionService.convert(questionSliderDto,
                QuestionSlider.class);
        if(questionWithTextAnswerRepository.findById((Integer)questionSlider.getQuestionId()).isPresent()) {
            return conversionService.convert(questionSliderRepository.save(questionSlider), QuestionSliderDto.class);
        } else {
            throw new ClientException("Error: QuestionService.updateQuestionSliderDto - Couldn't find question" +
                    " with ID " + questionSlider.getQuestionId());
        }
    }

    /**Метод, удаляющий вопрос-слайдер*/
    public QuestionSliderDto deleteQuestionSlider(Integer questionId) throws ClientException {
        if(questionId == null) {
            throw new ClientException("Error: QuestionService.deleteQuestionSlider - The questionID "
                    + questionId + " cannot be null");
        }
        if(questionSliderRepository.findById(questionId).isPresent()) {
            QuestionSlider questionSlider = questionSliderRepository.findById(questionId).orElse(new QuestionSlider());
            questionSliderRepository.delete(questionSlider);
            return conversionService.convert(questionSlider, QuestionSliderDto.class);
        } else {
            throw new ClientException("Error: QuestionService.deleteQuestionSlider - The question ID "
                    + questionId + " is missing from the database");
        }
    }

    /**Метод, создающий новый вопрос-шкалу мнений*/
    public QuestionScaleOfOpinionDto createQuestionScaleOfOpinion(QuestionScaleOfOpinionDto questionScaleOfOpinionDto)
            throws ServerException {
        if(questionScaleOfOpinionDto == null) {
            throw new ServerException("Error: QuestionService.createQuestionScaleOfOpinion -" +
                    " The questionScaleOfOpinionDto cannot have a null value");
        }
        QuestionScaleOfOpinion questionScaleOfOpinion = conversionService.convert(questionScaleOfOpinionDto,
                QuestionScaleOfOpinion.class);
        return conversionService.convert(questionScaleOfOpinionRepository.save(questionScaleOfOpinion),
                QuestionScaleOfOpinionDto.class);
    }

    /**Метод, возвращающий вопрос-шкалу мнений*/
    public QuestionScaleOfOpinionDto getQuestionScaleOfOpinion(Integer questionId) throws ServerException {
        if(questionId == null) {
            throw new ServerException("Error: QuestionService.getQuestionScaleOfOpinion - QuestionId cannot be null");
        }
        if(questionScaleOfOpinionRepository.findById(questionId).isPresent()) {
            QuestionScaleOfOpinion questionScaleOfOpinion = questionScaleOfOpinionRepository.
                    findById(questionId).orElse(new QuestionScaleOfOpinion());
            return conversionService.convert(questionScaleOfOpinion, QuestionScaleOfOpinionDto.class);
        } else {
            throw new ServerException("Error: QuestionService.getQuestionScaleOfOpinion -" +
                    " Failed to return question with ID " + questionId);
        }
    }

    /**Метод, обновляющий данные вопроса-шкалы мнений*/
    public QuestionScaleOfOpinionDto updateQuestionScaleOfOpinion(QuestionScaleOfOpinionDto questionScaleOfOpinionDto)
            throws ClientException {
        if(questionScaleOfOpinionDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionScaleOfOpinionDto -" +
                    " Question cannot be null");
        }
        QuestionScaleOfOpinion questionScaleOfOpinion = conversionService.convert(questionScaleOfOpinionDto,
                QuestionScaleOfOpinion.class);
        if(questionScaleOfOpinionRepository.findById((Integer)questionScaleOfOpinion.getQuestionId()).isPresent()) {
            return conversionService.convert(questionScaleOfOpinionRepository.save(questionScaleOfOpinion),
                    QuestionScaleOfOpinionDto.class);
        } else {
            throw new ClientException("Error: QuestionService.updateQuestionScaleOfOpinionDto - Couldn't find question" +
                    " with ID " + questionScaleOfOpinionDto.getQuestionId());
        }
    }

    /**Метод, удаляющий вопрос-шкалу мнения*/
    public QuestionScaleOfOpinionDto deleteQuestionScaleOfOpinion(Integer questionId) throws ClientException {
        if(questionId == null) {
            throw new ClientException("Error: QuestionService.deleteQuestionScaleOfOpinion - The questionID "
                    + questionId + " cannot be null");
        }
        if(questionScaleOfOpinionRepository.findById(questionId).isPresent()) {
            QuestionScaleOfOpinion questionScaleOfOpinion = questionScaleOfOpinionRepository.findById(questionId).orElse(new QuestionScaleOfOpinion());
            questionScaleOfOpinionRepository.delete(questionScaleOfOpinion);
            return conversionService.convert(questionScaleOfOpinion, QuestionScaleOfOpinionDto.class);
        } else {
            throw new ClientException("Error: QuestionService.deleteQuestionScaleOfOpinion - The question ID "
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
        QuestionNPS questionNPS = conversionService.convert(questionNPSDto,
                QuestionNPS.class);
        return conversionService.convert(questionNPSRepository.save(questionNPS), QuestionNPSDto.class);
    }

    /**Метод, возвращающий вопрос-NPS*/
    public QuestionNPSDto getQuestionNPS(Integer questionId) throws ServerException {
        if(questionId == null) {
            throw new ServerException("Error: QuestionService.getQuestionNPS - QuestionId cannot be null");
        }
        if(questionNPSRepository.findById(questionId).isPresent()) {
            QuestionNPS questionNPS = questionNPSRepository.findById(questionId).orElse(new QuestionNPS());
            return conversionService.convert(questionNPS, QuestionNPSDto.class);
        } else {
            throw new ServerException("Error: QuestionService.getQuestionNPS -" +
                    " Failed to return question with ID " + questionId);
        }
    }

    /**Метод, обновляющий данные вопроса-NPS*/
    public QuestionNPSDto updateQuestionNPS(QuestionNPSDto questionNPSDto)
            throws ClientException {
        if(questionNPSDto == null) {
            throw new ClientException("Error: QuestionService.updateQuestionNPS - Question cannot be null");
        }
        QuestionNPS questionNPS = conversionService.convert(questionNPSDto,
                QuestionNPS.class);
        if(questionWithTextAnswerRepository.findById((Integer)questionNPS.getQuestionId()).isPresent()) {
            return conversionService.convert(questionNPSRepository.save(questionNPS),
                    QuestionNPSDto.class);
        } else {
            throw new ClientException("Error: QuestionService.updateQuestionNPS - Couldn't find question" +
                    " with ID " + questionNPSDto.getQuestionId());
        }
    }

    /**Метод, удаляющий вопрос-NPS*/
    public QuestionNPSDto deleteQuestionNPS(Integer questionId) throws ClientException {
        if(questionId == null) {
            throw new ClientException("Error: QuestionService.deleteQuestionNPS - The questionID "
                    + questionId + " cannot be null");
        }
        if(questionNPSRepository.findById(questionId).isPresent()) {
            QuestionNPS questionNPS = questionNPSRepository.findById(questionId).orElse(new QuestionNPS());
            questionNPSRepository.delete(questionNPS);
            return conversionService.convert(questionNPS, QuestionNPSDto.class);
        } else {
            throw new ClientException("Error: QuestionService.deleteQuestionNPS - The question ID "
                    + questionId + " is missing from the database");
        }
    }
}
