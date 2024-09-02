create table cliente_imovel (
    climov_id serial primary key,
    cliente_id integer not null,
    imovel_id integer not null,
    climov_dtiniciorelacao date not null,
    climov_dtinfimrelacao date,
    cfrm_id integer,
    crtp_id integer not null,
    clie_icnomeconta numeric(1),
    climov_ultima_atualizacao TIMESTAMP DEFAULT  CURRENT_TIMESTAMP,
    foreign key (cfrm_id) references clie_fim_relacao_motivo(cfrm_id),
    foreign key (cliente_id) references cliente(cliente_id),
    foreign key (crtp_id) references cliente_relacao_tipo(crtp_id),
    foreign key (imovel_id) references houses(imovel_id)
)