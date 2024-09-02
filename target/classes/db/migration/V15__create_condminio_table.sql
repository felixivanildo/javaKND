CREATE TABLE condominio (
    condominio_id serial PRIMARY KEY,
    nome varchar(40) NOT NULL,
    razao_social varchar(40),
    endereco VARCHAR(255) not null,
    telefone VARCHAR(20),
    email VARCHAR(100),
    data_fundacao DATE,
    cnpj varchar(20) not null
);