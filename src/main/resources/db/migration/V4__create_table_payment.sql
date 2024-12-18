CREATE TABLE payment
(
    id             UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    appointment_id UUID         NOT NULL REFERENCES appointment (id) ON DELETE CASCADE,
    value          INTEGER      NOT NULL,
    method         VARCHAR(255) NOT NULL,
    status         VARCHAR(255) NOT NULL DEFAULT 'PENDING'
);