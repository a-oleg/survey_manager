package com.github.a_oleg.entity.questions;

import com.github.a_oleg.entity.choiceoption.ChoiceImage;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_the_choice_of_media")
public class QuestionTheChoiceOfMedia extends AbstractQuestion {
    @OneToMany(mappedBy = "questionTheChoiceOfMedia",cascade = CascadeType.ALL)
    List<ChoiceImage> listChoiceImage;
    @Column(name = "text_in_other_field")
    String textInOtherField;
}
