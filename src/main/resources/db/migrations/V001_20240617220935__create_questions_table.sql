create table questions (
    id integer not null,
    enabled boolean default true,
    prompt varchar(255) not null,
    subject varchar(255) not null check (subject in ('MATHEMATICS','ENGLISH','PHYSICS','BIOLOGY','CHEMISTRY','INFORMATION_TECHNOLOGY','PRINCIPLES_OF_ACCOUNTS','PRINCIPLES_OF_BUSINESS','ECONOMICS','CARIBBEAN_HISTORY','SOCIAL_STUDIES','SPANISH','TECHNICAL_DRAWING','FRENCH','FOOD_AND_NUTRITION')),
    type varchar(255) check (type in ('MULTIPLECHOICE','MULTIPART','SINGLEVALUE')),
    sub_prompts varchar(255) array,
    primary key (id)
);