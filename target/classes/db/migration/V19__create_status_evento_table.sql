create table status_evento (
    ste_id serial primary key,
    ste_dsstatus varchar (30) not null,   
    cfrm_ultima_atualizacao TIMESTAMP DEFAULT  CURRENT_TIMESTAMP
)