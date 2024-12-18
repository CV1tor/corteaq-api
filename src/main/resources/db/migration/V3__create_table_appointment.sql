CREATE TABLE appointment
(
    id               UUID PRIMARY KEY     DEFAULT gen_random_uuid(),
    customer_id      UUID REFERENCES customer (id) ON DELETE CASCADE,
    barber_id        UUID REFERENCES barber (id) ON DELETE CASCADE,
    date_time        TIMESTAMP   NOT NULL,
    status           VARCHAR(50) NOT NULL DEFAULT 'PENDING',
    rating           SMALLINT,
    customer_comment VARCHAR(255)
);