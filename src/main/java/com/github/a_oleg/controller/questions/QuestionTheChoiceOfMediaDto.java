package com.github.a_oleg.controller.questions;

import com.github.a_oleg.entity.choiceoption.ChoiceImage;

import java.util.List;

public class QuestionTheChoiceOfMediaDto extends AbstractQuestionDto {
    List<ChoiceImage> listChoiceImage;
    String textInOtherField;

    public QuestionTheChoiceOfMediaDto() {
    }

    public QuestionTheChoiceOfMediaDto(int parentCode, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<ChoiceImage> listChoiceImage, String textInOtherField) {
        super(parentCode, activityStatus, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.listChoiceImage = listChoiceImage;
        this.textInOtherField = textInOtherField;
    }

    public QuestionTheChoiceOfMediaDto(int questionId, int parentCode, boolean activityStatus, int surveyId, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<ChoiceImage> listChoiceImage, String textInOtherField) {
        super(questionId, parentCode, activityStatus, surveyId, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
        this.listChoiceImage = listChoiceImage;
        this.textInOtherField = textInOtherField;
    }

    public List<ChoiceImage> getListChoiceImage() {
        return listChoiceImage;
    }

    public void setListChoiceImage(List<ChoiceImage> listChoiceImage) {
        this.listChoiceImage = listChoiceImage;
    }

    public String getTextInOtherField() {
        return textInOtherField;
    }

    public void setTextInOtherField(String textInOtherField) {
        this.textInOtherField = textInOtherField;
    }
}
