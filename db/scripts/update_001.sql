CREATE TABLE IF NOT EXISTS cars
(
    id        SERIAL PRIMARY KEY,
    brand     VARCHAR(255),
    model     VARCHAR(255),
    engine_id INT NOT NULL UNIQUE REFERENCES engines (id)
);

CREATE TABLE IF NOT EXISTS engines
(
    id    SERIAL PRIMARY KEY,
    model VARCHAR(255)
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