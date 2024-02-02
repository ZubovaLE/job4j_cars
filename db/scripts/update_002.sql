INSERT INTO public.brands(name) VALUES ('BMW'), ('NISSAN'), ('AUDI');
INSERT INTO public.models(name) VALUES ('X5'), ('X6'), ('X7'), ('i7'), ('i3');
INSERT INTO public.models(name) VALUES ('Qashqai'), ('X-Trail'), ('Almera'), ('Juke'), ('Murano');
INSERT INTO public.models(name) VALUES ('RS 6'), ('A4'), ('A7'), ('SQ8'), ('Q6');

INSERT INTO public.brands_models(brand_id, model_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5);
INSERT INTO public.brands_models(brand_id, model_id) VALUES (2, 6), (2, 7), (2, 8), (2, 9), (2, 10);
INSERT INTO public.brands_models(brand_id, model_id) VALUES (3, 11), (3, 12), (3, 13), (3, 14), (3, 15);

INSERT INTO bodies(name) VALUES ('Седан'),('Хэтчбек'),('Внедорожник'),('Универсал');

INSERT INTO public.models_bodies(model_id, body_id) VALUES (1, 3);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (2, 3);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (3, 3);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (4, 1);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (5, 1), (5, 2), (5, 3);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (6, 3);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (7, 3);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (8, 1), (8, 2);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (9, 3);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (10, 3);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (11, 1), (11, 4);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (12, 1), (12, 4);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (13, 1), (13, 2);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (14, 3);
INSERT INTO public.models_bodies(model_id, body_id) VALUES (15, 3);
