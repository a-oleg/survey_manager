CREATE TABLE IF NOT EXISTS surveys
(
    survey_id BIGSERIAL PRIMARY KEY,
    creator VARCHAR(50) NOT NULL,
    survey_name VARCHAR(50) NOT NULL,
    folder_id INTEGER NOT NULL,
    activity_status BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS question_nps
(
    question_id BIGSERIAL PRIMARY KEY,
    parent_id BIGINTEGER NOT NULL,
    activity_status BOOLEAN NOT NULL,
    survey_id BIGINTEGER REFERENCES surveys(survey_id),
    question_number_in_the_survey INTEGER NOT NULL,
    type_question VARCHAR(50) NOT NULL,
    text_question VARCHAR(255) NOT NULL,
    description_text VARCHAR(255) NOT NULL,
    button_text VARCHAR(255) NOT NULL,
    have_button_i_find_it_difficult_to_answer BOOLEAN NOT NULL,
    text_in_comment_field VARCHAR(255) NOT NULL,
    figure_type VARCHAR(50) NOT NULL,
    gradient_type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS question_rating
(
    question_id BIGSERIAL PRIMARY KEY,
    parent_id BIGINTEGER NOT NULL,
    activity_status BOOLEAN NOT NULL,
    survey_id BIGINTEGER REFERENCES surveys(survey_id),
    question_number_in_the_survey INTEGER NOT NULL,
    type_question VARCHAR(50) NOT NULL,
    text_question VARCHAR(255) NOT NULL,
    description_text VARCHAR(255) NOT NULL,
    button_text VARCHAR(255) NOT NULL,
    count_of_scale_elements INTEGER NOT NULL,
    figure_type VARCHAR(50) NOT NULL,
    gradient_type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS question_scale_of_opinion
(
    question_id BIGSERIAL PRIMARY KEY,
    parent_id BIGINTEGER NOT NULL,
    activity_status BOOLEAN NOT NULL,
    survey_id BIGINTEGER REFERENCES surveys(survey_id),
    question_number_in_the_survey INTEGER NOT NULL,
    type_question VARCHAR(50) NOT NULL,
    text_question VARCHAR(255) NOT NULL,
    description_text VARCHAR(255) NOT NULL,
    button_text VARCHAR(255) NOT NULL,
    description_of_assessment VARCHAR(255) NOT NULL,
    have_button_i_find_it_difficult_to_answer BOOLEAN NOT NULL,
    rating_for_entering_comment INTEGER NOT NULL,
    text_in_comment_field VARCHAR(255) NOT NULL,
    figure_type VARCHAR(50) NOT NULL,
    gradient_type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS question_slider
(
    question_id BIGSERIAL PRIMARY KEY,
    parent_id BIGINTEGER NOT NULL,
    activity_status BOOLEAN NOT NULL,
    survey_id BIGINTEGER REFERENCES surveys(survey_id),
    question_number_in_the_survey INTEGER NOT NULL,
    type_question VARCHAR(50) NOT NULL,
    text_question VARCHAR(255) NOT NULL,
    description_text VARCHAR(255) NOT NULL,
    button_text VARCHAR(255) NOT NULL,
    type_slider VARCHAR(50) NOT NULL,
    count_of_scale_elements INTEGER NOT NULL,
    default_scale_element_number INTEGER NOT NULL,
    figure_type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS question_the_choice_of_media
(
    question_id BIGSERIAL PRIMARY KEY,
    parent_id BIGINTEGER NOT NULL,
    activity_status BOOLEAN NOT NULL,
    survey_id BIGINTEGER REFERENCES surveys(survey_id),
    question_number_in_the_survey INTEGER NOT NULL,
    type_question VARCHAR(50) NOT NULL,
    text_question VARCHAR(255) NOT NULL,
    description_text VARCHAR(255) NOT NULL,
    button_text VARCHAR(255) NOT NULL,
    choice_image_id INTEGER REFERENCES choice_image(choice_id),
    text_in_comment_field VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS choice_image
(
    choice_id BIGSERIAL PRIMARY KEY,
    image BLOB NOT NULL,
    question_id BIGINTEGER REFERENCES question_the_choice_of_media(question_id),
    text VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS question_with_multiple_answers
(
    question_id BIGSERIAL PRIMARY KEY,
    parent_id BIGINTEGER NOT NULL,
    activity_status BOOLEAN NOT NULL,
    survey_id BIGINTEGER REFERENCES surveys(survey_id),
    question_number_in_the_survey INTEGER NOT NULL,
    type_question VARCHAR(50) NOT NULL,
    text_question VARCHAR(255) NOT NULL,
    description_text VARCHAR(255) NOT NULL,
    button_text VARCHAR(255) NOT NULL,
    answer_options VARCHAR(50) NOT NULL,
    multiple_choice_of_answers BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS question_with_text_answer
(
    question_id BIGSERIAL PRIMARY KEY,
    parent_id BIGINTEGER NOT NULL,
    activity_status BOOLEAN NOT NULL,
    survey_id BIGINTEGER REFERENCES surveys(survey_id),
    question_number_in_the_survey INTEGER NOT NULL,
    type_question VARCHAR(50) NOT NULL,
    text_question VARCHAR(255) NOT NULL,
    description_text VARCHAR(255) NOT NULL,
    button_text VARCHAR(255) NOT NULL,
    answer_options VARCHAR(50) NOT NULL,
    subquestion REFERENCES surveys(survey_id)
);

CREATE TABLE IF NOT EXISTS subquestion_with_text_answer
(
    subquestion_id BIGSERIAL PRIMARY KEY,
    subquestion_text VARCHAR(255) NOT NULL,
    prefix_text VARCHAR(255) NOT NULL,
    postfix_text VARCHAR(255) NOT NULL,
    question_id BIGINTEGER REFERENCES question_with_text_answer(question_id)
);