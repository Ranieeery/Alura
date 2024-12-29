CREATE TABLE tutores(
    id       SERIAL       NOT NULL,
    nome     VARCHAR(100) NOT NULL,
    telefone VARCHAR(14)  NOT NULL unique,
    email    VARCHAR(100) NOT NULL unique,
    PRIMARY KEY (id)
);