ALTER TABLE cliente 
ADD COLUMN usuario_id UUID,
ADD CONSTRAINT usuario_cliente_fk
FOREIGN KEY (usuario_id) 
REFERENCES users(id); ;