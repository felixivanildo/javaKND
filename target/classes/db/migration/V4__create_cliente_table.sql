CREATE TABLE cliente (
     cliente_id serial Primary Key,
     clie_cdclienteresponsavel varchar (40),
     nm_cliente varchar (40) not null,
     cpf_cnpj varchar (20),
     nome_mae varchar (40),
     cltp_id integer,
     foreign key (cltp_id) references client_tipo(cltp_id)
     
     
)