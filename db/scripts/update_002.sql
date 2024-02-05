INSERT INTO brands(name)
VALUES ('BMW'),
       ('NISSAN'),
       ('AUDI');

--for BMW
INSERT INTO models(name)
VALUES ('X5'),
       ('X6'),
       ('X7'),
       ('i7'),
       ('i3');

--for NISSAN
INSERT INTO models(name)
VALUES ('Qashqai'),
       ('X-Trail'),
       ('Almera'),
       ('Juke'),
       ('Murano');

--for AUDI
INSERT INTO models(name)
VALUES ('RS 6'),
       ('A4'),
       ('A7'),
       ('SQ8'),
       ('Q6');

INSERT INTO brands_models(brand_id, model_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5);
INSERT INTO brands_models(brand_id, model_id)
VALUES (2, 6),
       (2, 7),
       (2, 8),
       (2, 9),
       (2, 10);
INSERT INTO brands_models(brand_id, model_id)
VALUES (3, 11),
       (3, 12),
       (3, 13),
       (3, 14),
       (3, 15);

INSERT INTO bodies(name)
VALUES ('Седан'),
       ('Хэтчбек'),
       ('Внедорожник'),
       ('Универсал');

INSERT INTO models_bodies(model_id, body_id)
VALUES (1, 3),
       (2, 3),
       (3, 3),
       (4, 1),
       (5, 1),
       (5, 2),
       (5, 3),
       (6, 3),
       (7, 3),
       (8, 1),
       (8, 2),
       (9, 3),
       (10, 3),
       (11, 1),
       (11, 4),
       (12, 1),
       (12, 4),
       (13, 1),
       (13, 2),
       (14, 3),
       (15, 3);

--for BMW
INSERT INTO engines(model)
VALUES ('R3'),
       ('R4'),
       ('R6'),
       ('V8'),
       ('V12');

--for NISSAN
INSERT INTO engines(model)
VALUES ('HR'),
       ('MR'),
       ('QR'),
       ('RB'),
       ('CA'),
       ('CD');

--for AUDI
INSERT INTO engines(model)
VALUES ('EA111'),
       ('EA113'),
       ('EA211'),
       ('EA398'),
       ('EA824'),
       ('EA827'),
       ('EA828'),
       ('EA835'),
       ('EA837'),
       ('EA839'),
       ('EA855'),
       ('EA888');

INSERT INTO brands_engines(brand_id, engine_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),

       (2, 6),
       (2, 7),
       (2, 8),
       (2, 9),
       (2, 10),
       (2, 11),

       (3, 12),
       (3, 13),
       (3, 14),
       (3, 15),
       (3, 16),
       (3, 17),
       (3, 18),
       (3, 19),
       (3, 20),
       (3, 21),
       (3, 22),
       (3, 23);