ALTER TABLE houses
ADD COLUMN ic_exclusao NUMERIC(1),
add COLUMN condominio_id integer,
ADD CONSTRAINT condominio_fk
FOREIGN KEY (condominio_id) 
REFERENCES condominio (condominio_id);
