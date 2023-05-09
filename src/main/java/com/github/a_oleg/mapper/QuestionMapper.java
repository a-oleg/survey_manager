package com.github.a_oleg.mapper;

import com.github.a_oleg.controller.questions.QuestionNPSDto;
import com.github.a_oleg.controller.questions.QuestionRatingDto;
import com.github.a_oleg.controller.questions.QuestionSliderDto;
import com.github.a_oleg.controller.questions.QuestionWithMultipleAnswersDto;
import com.github.a_oleg.controller.questions.QuestionWithTextAnswerDto;
import com.github.a_oleg.entity.question.QuestionNPS;
import com.github.a_oleg.entity.question.QuestionRating;
import com.github.a_oleg.entity.question.QuestionSlider;
import com.github.a_oleg.entity.question.QuestionWithMultipleAnswers;
import com.github.a_oleg.entity.question.QuestionWithTextAnswer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionNPS toQuestionNPS(QuestionNPSDto questionNPSDto);
    QuestionNPSDto toQuestionNPSDto(QuestionNPS questionNPS);

    QuestionRating toQuestionRating(QuestionRatingDto questionRatingDto);
    QuestionRatingDto toQuestionRatingDto(QuestionRating questionRating);

    QuestionSlider toQuestionSlider(QuestionSliderDto questionSliderDto);
    QuestionSliderDto toQuestionSliderDto(QuestionSlider questionSlider);

    QuestionWithMultipleAnswers toQuestionWithMultipleAnswers(QuestionWithMultipleAnswersDto questionWithMultipleAnswersDto);
    QuestionWithMultipleAnswersDto toQuestionWithMultipleAnswersDto(QuestionWithMultipleAnswers questionWithMultipleAnswers);

    QuestionWithTextAnswerDto toQuestionWithTextAnswerDto(QuestionWithTextAnswer questionWithTextAnswer);
    QuestionWithTextAnswer toQuestionWithTextAnswer(QuestionWithTextAnswerDto questionWithTextAnswerDto);
}
