package com.github.a_oleg.entity.questions;

import com.github.a_oleg.entity.choiceoptions.ChoiceImage;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "question_the_choice_of_media")
public class QuestionTheChoiceOfMedia extends AbstractQuestion {
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    ArrayList<ChoiceImage> listChoiceImage = new ArrayList<>();
    @Column(name = "text_in_other_field")
    String textInOtherField;
}
