# Projeto Bem Estar


## Comando sql

```
CREATE DATABASE bem_estar_database;

USE bem_estar_database;

CREATE TABLE Cliente (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
cpf VARCHAR(14) NOT NULL,
password VARCHAR(255) NOT NULL
);
INSERT INTO Cliente (name, email, cpf, password) VALUES
('João Silva', 'joao@example.com', '123.456.789-00', 'senha123');

INSERT INTO Cliente (name, email, cpf, password) VALUES
('Maria Souza', 'maria@example.com', '987.654.321-00', 'senha456');

INSERT INTO Cliente (name, email, cpf, password) VALUES
('Pedro Santos', 'pedro@example.com', '456.789.123-00', 'senha789');

INSERT INTO Cliente (name, email, cpf, password) VALUES
('Ana Oliveira', 'ana@example.com', '789.123.456-00', 'senhaabc');

INSERT INTO Cliente (name, email, cpf, password) VALUES
('Luiza Ferreira', 'luiza@example.com', '654.321.987-00', 'senhalmn');
```


