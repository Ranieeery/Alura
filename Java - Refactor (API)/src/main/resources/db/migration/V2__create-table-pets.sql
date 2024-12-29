CREATE TABLE pets(
    id        SERIAL        NOT NULL,
    tipo      VARCHAR(100)  NOT NULL,
    nome      VARCHAR(100)  NOT NULL,
    raca      VARCHAR(100)  NOT NULL,
    idade     int           NOT NULL,
    cor       VARCHAR(100)  NOT NULL,
    peso      decimal(4, 2) NOT NULL,
    abrigo_id BIGINT        NOT NULL,
    adotado   boolean       NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_pets_abrigo_id FOREIGN KEY (abrigo_id) REFERENCES abrigos (id)
);