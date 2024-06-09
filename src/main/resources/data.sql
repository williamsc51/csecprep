insert into questions (id, prompt, subject, type) values (1, '2 + 2 =', 'mathematics', 'singleSelect');
insert into answers (id, value, is_correct, question_id) values (1, '2', false, 1);
insert into answers (id, value, is_correct, question_id) values (2, '3', false, 1);
insert into answers (id, value, is_correct, question_id) values (3, '4', true, 1);
insert into answers (id, value, is_correct, question_id) values (4, '5', false, 1);

insert into questions (id, prompt, subject, type) values (2, 'What does the heart to', 'biology', 'singleSelect');
insert into answers (id, value, is_correct, question_id) values (5, 'Bump Blood', true, 2);
insert into answers (id, value, is_correct, question_id) values (6, 'Digest Food', false, 2);
insert into answers (id, value, is_correct, question_id) values (7, 'Produce Bile', false, 2);
insert into answers (id, value, is_correct, question_id) values (8, 'Excrete Waste', false, 2);

insert into responses (id, question_id, answer_id) values (1, 1, 1);
insert into responses (id, question_id, answer_id) values (2, 1, 2);
insert into responses (id, question_id, answer_id) values (3, 1, 3);
insert into responses (id, question_id, answer_id) values (4, 1, 4);
