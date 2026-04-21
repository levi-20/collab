CREATE TABLE messages
(
    id          BIGSERIAL PRIMARY KEY,
    room_id     BIGINT      NOT NULL REFERENCES rooms (id) ON DELETE CASCADE,
    sender_name VARCHAR(50) NOT NULL,
    content     TEXT        NOT NULL,
    sent_at     TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_messages_room_id ON messages (room_id, sent_at DESC);