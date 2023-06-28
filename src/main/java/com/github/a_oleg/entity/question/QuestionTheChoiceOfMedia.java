package com.github.a_oleg.entity.question;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.choiceoption.ChoiceImage;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_the_choice_of_media")
public class QuestionTheChoiceOfMedia extends AbstractQuestion {
//    //Список изображений и подписей
//    @OneToMany(mappedBy = "choice_image_id",cascade = CascadeType.ALL)
//    List<ChoiceImage> listChoiceImage;
//    //Текст по умолчанию в поле для комментариев пользователя
//    @Column(name = "text_in_other_field")
//    String textInOtherField;
//
//    public QuestionTheChoiceOfMedia() {
//    }
//
//    public QuestionTheChoiceOfMedia(int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<ChoiceImage> listChoiceImage, String textInOtherField) {
//        super(parentCode, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
//        this.listChoiceImage = listChoiceImage;
//        this.textInOtherField = textInOtherField;
//    }
//
//    public QuestionTheChoiceOfMedia(int questionId, int parentCode, boolean activityStatus, Survey survey, int questionNumberInTheSurvey, String typeQuestion, String textQuestion, String descriptionText, String buttonText, List<ChoiceImage> listChoiceImage, String textInOtherField) {
//        super(questionId, parentCode, activityStatus, survey, questionNumberInTheSurvey, typeQuestion, textQuestion, descriptionText, buttonText);
//        this.listChoiceImage = listChoiceImage;
//        this.textInOtherField = textInOtherField;
//    }
//
//    public List<ChoiceImage> getListChoiceImage() {
//        return listChoiceImage;
//    }
//
//    public void setListChoiceImage(List<ChoiceImage> listChoiceImage) {
//        this.listChoiceImage = listChoiceImage;
//    }
//
//    public String getTextInOtherField() {
//        return textInOtherField;
//    }
//
//    public void setTextInOtherField(String textInOtherField) {
//        this.textInOtherField = textInOtherField;
//    }
}
