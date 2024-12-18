CREATE TABLE barber
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    description VARCHAR(255),
    user_id     UUID NOT NULL UNIQUE REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE customer
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL UNIQUE REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE servicing
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price       INTEGER          NOT NULL
);

CREATE TABLE barber_servicing
(
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    barber_id    UUID NOT NULL REFERENCES barber (id) ON DELETE CASCADE,
    servicing_id UUID NOT NULL REFERENCES servicing (id) ON DELETE CASCADE
);