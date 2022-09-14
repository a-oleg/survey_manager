CREATE TABLE IF NOT EXISTS surveys
(
    survey_id BIGSERIAL PRIMARY KEY,
    creator VARCHAR(50) NOT NULL,
    survey_name VARCHAR(50) NOT NULL,
    folder_id INTEGER NOT NULL,
    activity_status BOOLEAN NOT NULL
);
CREATE TABLE IF NOT EXISTS question_with_text_answer
(
    question_id BIGSERIAL PRIMARY KEY,
    survey_id INTEGER REFERENCES surveys(survey_id),
    question_number_in_the_survey INTEGER NOT NULL,
    type_question VARCHAR(50) NOT NULL,
    text_question VARCHAR(255) NOT NULL,
    description_text VARCHAR(255) NOT NULL,
    button_text VARCHAR(255) NOT NULL,
    prefix_text VARCHAR(255) NOT NULL,
    postfix_text VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS question_rating
(
    question_id BIGSERIAL PRIMARY KEY,
    survey_id INTEGER REFERENCES surveys(survey_id),
    question_number_in_the_survey INTEGER NOT NULL,
    type_question VARCHAR(50) NOT NULL,
    text_question VARCHAR(255) NOT NULL,
    description_text VARCHAR(255) NOT NULL,
    button_text VARCHAR(255) NOT NULL,
    count_of_scale_elements INTEGER NOT NULL,
    figure_type VARCHAR(50) NOT NULL,
    gradient_type VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS question_rating
(
    question_id BIGSERIAL PRIMARY KEY,
    survey_id INTEGER REFERENCES surveys(survey_id),
    question_number_in_the_survey INTEGER NOT NULL,
    type_question VARCHAR(50) NOT NULL,
    text_question VARCHAR(255) NOT NULL,
    description_text VARCHAR(255) NOT NULL,
    button_text VARCHAR(255) NOT NULL,
    count_of_scale_elements INTEGER NOT NULL,
    figure_type VARCHAR(50) NOT NULL,
    gradient_type VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS question_slider
(
    question_id BIGSERIAL PRIMARY KEY,
    survey_id INTEGER REFERENCES surveys(survey_id),
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