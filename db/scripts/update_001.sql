CREATE TABLE IF NOT EXISTS engines
(
    id    SERIAL PRIMARY KEY,
    model VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS cars
(
    id        SERIAL PRIMARY KEY,
    brand     VARCHAR(255),
    model     VARCHAR(255),
    body_type VARCHAR(255),
    engine_id INT NOT NULL UNIQUE REFERENCES engines (id)
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
    price       NUMERIC,
    car_id      INT NOT NULL REFERENCES cars (id),
    user_id     INT NOT NULL REFERENCES users (id)
);