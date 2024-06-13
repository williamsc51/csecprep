insert into questions (id, prompt, subject, type) values (1, '2 + 2 =', 'mathematics', 'MULTIPLECHOICE');
insert into answers (id, value, is_correct, question_id) values (1, '2', false, 1);
insert into answers (id, value, is_correct, question_id) values (2, '3', false, 1);
insert into answers (id, value, is_correct, question_id) values (3, '4', true, 1);
insert into answers (id, value, is_correct, question_id) values (4, '5', false, 1);

insert into questions (id, prompt, subject, type) values (2, '6 = 5 - X', 'mathematics', 'SINGLEVALUE');

insert into questions (id, prompt, subject, type) values (3, 'What does the heart do?', 'biology', 'MULTIPLECHOICE');
insert into answers (id, value, is_correct, question_id) values (5, 'Bump Blood', true, 3);
insert into answers (id, value, is_correct, question_id) values (6, 'Digest Food', false, 3);
insert into answers (id, value, is_correct, question_id) values (7, 'Produce Bile', false, 3);
insert into answers (id, value, is_correct, question_id) values (8, 'Excrete Waste', false, 3);

insert into questions (id, prompt, subject, type, sub_prompts) values (4, 'Travelling at 180m/h', 'physics', 'MULTIPART', '{"Calculate the speed", "Calculate the distance"}');

insert into responses (id, question_id, answer_id) values (1, 1, 1);
insert into responses (id, question_id, answer_id) values (2, 1, 2);
insert into responses (id, question_id, answer_id) values (3, 1, 3);
insert into responses (id, question_id, answer_id) values (4, 1, 4);
