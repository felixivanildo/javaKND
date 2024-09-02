create table clie_fim_relacao_motivo (
    cfrm_id serial primary key,
    cfrm_dsmotivo varchar (30) not null,
    cfrm_icuso numeric (1) not null,
    cfrm_ultima_atualizacao TIMESTAMP DEFAULT  CURRENT_TIMESTAMP
)