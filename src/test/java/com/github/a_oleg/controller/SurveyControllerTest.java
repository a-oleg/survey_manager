package com.github.a_oleg.controller;

import com.github.a_oleg.repository.questions.QuestionNPSRepository;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

//@ExtendWith(MockitoExtension.class)
@Component
public class SurveyControllerTest {
    private final QuestionNPSRepository questionNPSRepository;

    public SurveyControllerTest(QuestionNPSRepository questionNPSRepository) {
        this.questionNPSRepository = questionNPSRepository;
    }
//    @Mock
//    SurveyService surveyService;
//    @InjectMocks
//    SurveyController surveyController;

//    @Test
//    whenCorrectPostRequest_thenReturnStatusCreated() {
//
//    }

//    @Test
//    void testRepository() {
//        System.out.println(questionNPSRepository.findBySurvey(1));
//    }
}
