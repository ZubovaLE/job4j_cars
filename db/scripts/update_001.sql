CREATE TABLE IF NOT EXISTS engines
(
    id    SERIAL PRIMARY KEY,
    model VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS brands
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS models
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS brands_models
(
    id       SERIAL PRIMARY KEY,
    brand_id INT NOT NULL REFERENCES brands (id),
    model_id INT NOT NULL REFERENCES models (id)
);

CREATE TABLE IF NOT EXISTS brands_engines
(
    id       SERIAL PRIMARY KEY,
    brand_id INT NOT NULL REFERENCES brands (id),
    engine_id INT NOT NULL REFERENCES engines (id)
);

CREATE TABLE IF NOT EXISTS bodies
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS models_bodies
(
    id       SERIAL PRIMARY KEY,
    model_id INT NOT NULL REFERENCES models (id),
    body_id  INT NOT NULL REFERENCES bodies (id)

);

CREATE TABLE IF NOT EXISTS cars
(
    id        SERIAL PRIMARY KEY,
    engine_id INT NOT NULL UNIQUE REFERENCES engines (id),
    brand_id  INT NOT NULL REFERENCES brands (id),
    model_id  INT NOT NULL REFERENCES models (id),
    body_id   INT NOT NULL REFERENCES bodies (id)
);

CREATE TABLE IF NOT EXISTS driver
(
    id  SERIAL PRIMARY KEY,
    fio VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS history_owner
(
    id        SERIAL PRIMARY KEY,
    driver_id INT NOT NULL REFERENCES driver (id),
    car_id    INT NOT NULL REFERENCES cars (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(50),
    email    VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    phone    VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS posts
(
    id          SERIAL PRIMARY KEY,
    description TEXT,
    created     TIMESTAMP,
    car_id      INT NOT NULL REFERENCES cars (id),
    price       NUMERIC,
    photo       VARCHAR,
    user_id     INT NOT NULL REFERENCES users (id)
);