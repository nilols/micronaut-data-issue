CREATE TABLE student (
    id UUID PRIMARY KEY,
    name TEXT
);

CREATE TABLE course (
    id UUID PRIMARY KEY,
    name TEXT
);

CREATE TABLE student_course (
    student_id UUID,
    course_id UUID
)