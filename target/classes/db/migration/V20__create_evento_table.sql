CREATE TABLE eventos (
    id serial PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    data_inicio date NOT NULL,
    data_fim date NOT NULL,
    local VARCHAR(255),
    clie_responsavel INT,
    ste_id integer not null,
    FOREIGN KEY (clie_responsavel) REFERENCES cliente(cliente_id),
    FOREIGN KEY (ste_id) REFERENCES status_evento(ste_id)
);