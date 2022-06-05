INSERT INTO public.users (id, email, firstname, lastname, password) VALUES (1, 'abc@mail.com', 'fn', 'ln', '$2a$10$dJ4g7a1W7Kqc15i5ZuYV6.CpbcNHAt8UD3icDq8aJuWd8zkCvR3Te');
INSERT INTO public.users (id, email, firstname, lastname, password) VALUES (2, 'def@mail.com', 'fn', 'ln', '$2a$10$nr8I68OrvyNK5.B2gMTRt.YvNkNQt9II1p6gUbOe3TJosfGZpABgG');
INSERT INTO public.groups (id, description, name) VALUES (1, '3d0aea8e-7beb-46d2-a082-64901af5a6b0', 'abc');
INSERT INTO public.groups (id, description, name) VALUES (2, 'd65cbdff-6ce5-4684-97ff-c398411990a9', 'def');
INSERT INTO public.registrations (id, created_at, role, group_id, user_id) VALUES (1, '2022-06-05 14:42:58.194000', 'ADMIN', 1, 1);
INSERT INTO public.registrations (id, created_at, role, group_id, user_id) VALUES (2, '2022-06-05 14:43:02.852000', 'ADMIN', 2, 1);
