create table visibilidade_feed (
    visif_id serial primary key,
    visif_ds varchar (20) not null,
    visif_ultima_atualizacao TIMESTAMP DEFAULT  CURRENT_TIMESTAMP,
    visif_icuso numeric (1)

)