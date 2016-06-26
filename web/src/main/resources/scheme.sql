DROP TABLE IF EXISTS "groups" CASCADE ;
CREATE TABLE "groups" (
  id BIGSERIAL PRIMARY KEY,
  number VARCHAR NOT NULL
);



DROP TABLE IF EXISTS "students" CASCADE;
CREATE TABLE "students" (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR NOT NULL,
  age INT NOT NULL,
  sex VARCHAR NOT NULL DEFAULT 'UNKNOWN',
  group_number BIGINT REFERENCES "groups"
);



DROP TABLE IF EXISTS "exams" CASCADE;
CREATE TABLE "exams" (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR NOT NULL,
  scheduled_date DATE NOT NULL,
  cabinet BIGINT NOT NULL,
  status VARCHAR NOT NULL DEFAULT 'NOT_FINISHED'
);




DROP TABLE IF EXISTS "teachers" CASCADE;
CREATE TABLE "teachers" (
  id BIGSERIAL PRIMARY KEY REFERENCES "groups",
  name VARCHAR NOT NULL,
  age VARCHAR NOT NULL,
  sex VARCHAR NOT NULL DEFAULT 'UNKNOWN',
  education VARCHAR NOT NULL DEFAULT 'Well-rounded education'
);



DROP TABLE IF EXISTS "groups_exams" CASCADE;
CREATE TABLE "groups_exams" (
  group_id BIGINT NOT NULL REFERENCES "groups",
  exam_id BIGINT REFERENCES "exams"
);




DROP TABLE IF EXISTS "teachers_students" CASCADE;
CREATE TABLE "teachers_students" (
  teacher_id BIGINT NOT NULL REFERENCES "teachers",
  student_id BIGINT REFERENCES "students"
);



DROP TABLE IF EXISTS "results" CASCADE;
CREATE TABLE "results" (
  student_id BIGINT NOT NULL REFERENCES "students",
  exam_id BIGINT REFERENCES "exams",
  mark INT NOT NULL DEFAULT 0
);