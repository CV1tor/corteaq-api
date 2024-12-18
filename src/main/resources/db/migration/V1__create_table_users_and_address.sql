CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE users
(
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username         VARCHAR(255) NOT NULL UNIQUE,
    password         VARCHAR(255) NOT NULL,
    first_name       VARCHAR(255) NOT NULL,
    last_name        VARCHAR(255) NOT NULL,
    telephone_number VARCHAR(20)  NOT NULL,
    user_type        VARCHAR(50)  NOT NULL
);

CREATE TABLE address
(
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id      UUID REFERENCES users (id) ON DELETE CASCADE,
    street       VARCHAR(255) NOT NULL,
    house_number VARCHAR(50),
    cep     VARCHAR(9),
    city         VARCHAR(255) NOT NULL,
    state        VARCHAR(255) NOT NULL,
    complement   VARCHAR(255)
);