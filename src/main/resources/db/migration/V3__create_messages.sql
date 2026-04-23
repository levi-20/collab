CREATE TABLE messages
(
    id        BIGSERIAL NOT NULL PRIMARY KEY,
    room_id   BIGINT    NOT NULL REFERENCES rooms (id) ON DELETE CASCADE,
    sender_id UUID      NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    content   TEXT      NOT NULL,
    sent_at   TIMESTAMP NOT NULL DEFAULT NOW()
);