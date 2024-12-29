CREATE TABLE abrigos(
    id       SERIAL       NOT NULL,
    nome     VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(14)  NOT NULL UNIQUE,
    email    VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);