CREATE TABLE feed_mural (
    feed_id serial PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_atualizacao DATE DEFAULT CURRENT_TIMESTAMP,
    clie_responsavel integer,
    condominio_id integer not null,
    visif_id integer not null,
    status VARCHAR(50),
    FOREIGN KEY (clie_responsavel) REFERENCES cliente(cliente_id),
    FOREIGN KEY (condominio_id) REFERENCES condominio (condominio_id),
    FOREIGN KEY (visif_id) REFERENCES visibilidade_feed(visif_id)
);
