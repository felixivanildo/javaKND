create table cliente_relacao_tipo (
    crtp_id serial primary key,
    crtp_dsrelacao varchar (20) not null,
    crtp_icuso numeric (1),
    crtp_ultima_atualizacao TIMESTAMP DEFAULT  CURRENT_TIMESTAMP

)