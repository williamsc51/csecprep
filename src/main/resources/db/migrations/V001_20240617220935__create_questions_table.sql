create table questions (
    id bigint not null,
    enabled boolean default true,
    prompt varchar(255) not null,
    subject varchar(255) not null check (subject in ('MATHEMATICS','ENGLISH','PHYSICS','BIOLOGY','CHEMISTRY','INFORMATION_TECHNOLOGY','PRINCIPLES_OF_ACCOUNTS','PRINCIPLES_OF_BUSINESS','ECONOMICS','CARIBBEAN_HISTORY','SOCIAL_STUDIES','SPANISH','TECHNICAL_DRAWING','FRENCH','FOOD_AND_NUTRITION')),
    year varchar(4),
    type varchar(255) check (type in ('MULTIPLECHOICE','MULTIPART','SINGLEVALUE')),
    correct_answer varchar(255),
    imagePath varchar(255),
    primary key (id)
);