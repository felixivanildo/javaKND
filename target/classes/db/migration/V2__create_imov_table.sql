

CREATE TABLE houses  (
    imovel_id serial Primary Key,
    rua varchar (100) not null,
    numero_casa varchar (100) not null,
    bloco varchar (100) not null,
    descricao varchar (200) not null,
    created_at TIMESTAMP not null,
    andar VARCHAR (50) NOT NULL
);