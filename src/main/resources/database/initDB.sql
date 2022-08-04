CREATE TABLE IF NOT EXISTS surveys
(
    id BIGSERIAL PRIMARY KEY,
    creator VARCHAR(50) NOT NULL,
    survey_name VARCHAR(50) NOT NULL,
    folder_id INTEGER NOT NULL,
    activity_status BOOLEAN NOT NULL
);