CREATE TABLE client_tipo (
    cltp_id serial Primary key,
    dstipo varchar (40) not null,
    icpessoajuridica numeric(1) not null,
    icuso numeric(1) not null
)