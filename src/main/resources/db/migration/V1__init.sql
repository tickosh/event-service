-- V1: Создание начальной схемы базы данных для сервиса событий

-- Таблица для типов событий (например: Концерт, Театр, Спорт)
-- Создается первой, так как на нее ссылаются другие таблицы.
CREATE TABLE event_type
(
    id      BIGSERIAL PRIMARY KEY,
    name_kz VARCHAR(255),
    name_ru VARCHAR(255),
    name_en VARCHAR(255)
);

-- Таблица для типов дополнительной информации о событии (например: Артист, Место, Возрастное ограничение)
CREATE TABLE event_info_types
(
    id            BIGSERIAL PRIMARY KEY,
    name_kz       VARCHAR(255),
    name_ru       VARCHAR(255),
    name_en       VARCHAR(255),
    event_type_id BIGINT,
    data_type     VARCHAR(255),
    prefix        VARCHAR(255),
    CONSTRAINT fk_event_info_types_on_event_type FOREIGN KEY (event_type_id) REFERENCES event_type (id)
);

-- Основная таблица для событий
CREATE TABLE events
(
    id                BIGSERIAL PRIMARY KEY,
    created_at        TIMESTAMP,
    updated_at        TIMESTAMP,
    name              VARCHAR(255),
    description       TEXT,
    location          VARCHAR(255),
    age_restriction   VARCHAR(255),
    event_type_id     BIGINT NOT NULL,
    CONSTRAINT fk_events_on_event_type FOREIGN KEY (event_type_id) REFERENCES event_type (id)
);

-- Таблица для хранения конкретных значений дополнительной информации
-- (например: для события "Концерт Metallica", здесь будет запись {event_id: 1, info_type_id: 1 (Артист), value: "Metallica"})
CREATE TABLE event_info
(
    id                 BIGSERIAL PRIMARY KEY,
    event_id           BIGINT,
    event_info_type_id BIGINT,
    value              VARCHAR(255),
    CONSTRAINT fk_event_info_on_event FOREIGN KEY (event_id) REFERENCES events (id) ON DELETE CASCADE,
    CONSTRAINT fk_event_info_on_event_info_type FOREIGN KEY (event_info_type_id) REFERENCES event_info_types (id)
);

-- Добавление начальных данных для типов событий, чтобы система была готова к работе
INSERT INTO event_type (name_ru, name_kz, name_en) VALUES
                                                       ('Концерты', 'Концерттер', 'Concerts'),
                                                       ('Театр', 'Театр', 'Theatre'),
                                                       ('Спорт', 'Спорт', 'Sport'),
                                                       ('Выставки', 'Көрмелер', 'Exhibitions');
