# Projeto Bem Estar

# Configuração do ambiente
## Criação variavel de ambiente
### Importancia
O Application.properties é muito importante para nossa aplicação, nele existem algumas configurações básicas e dados sensiveis de cada computador, como senhas e etc, para evitar que esse tipo de dado vaze e qualquer um senha acesso são utilizado váriaveis de ambente. O que seria uma váriavel de ambiente? Nada mais é que uma constante que guarda um determinado valor no seu sistema operacional, sendo só você a pessoa que consegui visualizar/modificar o que tem nela.
### Identificação
No atual momento nosso código exige o uso de 4 váriaveis de ambiente, como identifica-las?

    src\main\resources\application.properties
    # Configurações do banco de dados
    spring.datasource.url=jdbc:mysql://localhost:3306/bem_estar_database?useSSL=false&serverTimezone=UTC
    spring.datasource.username= **${MYSQL_USER}**
    spring.datasource.password= **${MYSQL_PASS}**
          
    # Configuração do Hibernate
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    spring.jpa.hibernate.ddl-auto=update
          
    # Configurações do Spring Boot
    spring.application.name=BemEstarProjectsApp
    server.port=8080
          
    #spring-boot-starter-mail properties
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username= **${EMAIL_USER}**
    spring.mail.password= **${EMAIL_PASS}**
    mail.transport.protocol=smtp
    mail.from.email=${EMAIL_USER}
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true

Os itens em negrito, como **${EMAIL_USER}** ,são o que referencia nossas váriaveis de ambiente.

### Criação
**Sistema Windows**
1. Pesquise "Variável de ambiente"
    - Abra o pesquisa que tenha algo relacionado
2.  Clique em "Variável de ambiente..."
3.  Váriaveis do sistema
- Nova
- Digite o nome da váriavel que está sendo referenciada no application.properties, como EMAIL_USER
4. Adicionar a váriavel ao path
    - Dentro de váriaveis do sistema, busque por path
    - Clique no mesmo, e procure por novo
    - Adicione a referencia a váriavel exemplo: %EMAIL_USER%
5. Abra seu coração e reinicie seu computador
6. Você está pronto para brincar 😎

**Verificação**

No prompt de command você irá digitar:

    echo %EMAIL_USER%
a saída deverá ser algo como
    
    emailcolocado@gmail.com

## Comando sql

```
CREATE DATABASE bem_estar_database;

USE bem_estar_database;

CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
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

CREATE TABLE Nutricionista (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    inscricao VARCHAR(255) NOT NULL UNIQUE,
    regiao_crn BIGINT NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO Nutricionista (name, email, inscricao, regiao_crn, password) 
VALUES ('Ana Silva', 'ana@example.com', '1234-5678', 1, 'senha123');

INSERT INTO Nutricionista (name, email, inscricao, regiao_crn, password) 
VALUES ('Lucas Santos', 'lucas@example.com', '5678-1234', 1, 'senha456');

INSERT INTO Nutricionista (name, email, inscricao, regiao_crn, password) 
VALUES ('Maria Souza', 'maria@example.com', '9876-5432', 5, 'senha789');

INSERT INTO Nutricionista (name, email, inscricao, regiao_crn, password) 
VALUES ('Pedro Oliveira', 'pedro@example.com', '6543-2198', 3, 'senhaabc');

INSERT INTO Nutricionista (name, email, inscricao, regiao_crn, password) 
VALUES ('Laura Fernandes', 'laura@example.com', '3210-8765', 3, 'senhalmn');


CREATE TABLE endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(10),
    tipo_cep VARCHAR(20),
    sub_tipo_cep VARCHAR(20),
    uf VARCHAR(2),
    cidade VARCHAR(100),
    bairro VARCHAR(100),
    endereco VARCHAR(255),
    complemento VARCHAR(255),
    codigo_ibge VARCHAR(20)
);

INSERT INTO endereco (cep, tipo_cep, sub_tipo_cep, uf, cidade, bairro, endereco, complemento, codigo_ibge)
VALUES ('60130240', 'logradouro', 'S', 'CE', 'Fortaleza', 'São João do Tauape', 'Avenida Pontes Vieira', 'De 2 Até 1550 Lado Par', '');

INSERT INTO endereco (cep, tipo_cep, sub_tipo_cep, uf, cidade, bairro, endereco, complemento, codigo_ibge)
VALUES ('12345678', 'logradouro', 'N', 'SP', 'São Paulo', 'Centro', 'Rua Principal', 'Andar 5', '123456');

INSERT INTO endereco (cep, tipo_cep, sub_tipo_cep, uf, cidade, bairro, endereco, complemento, codigo_ibge)
VALUES ('54345', 'logradouro', 'N', 'RJ', 'Rio de Janeiro', 'Fleming', 'Avenida Pontes Vieira', 'Bloco C', '789012');

CREATE TABLE mercado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cnpj VARCHAR(18) UNIQUE NOT NULL,
    email VARCHAR(255)  NOT NULL,
    endereco_id INT REFERENCES endereco(id),
    num_telefone VARCHAR(20),
    password VARCHAR(255) NOT NULL
);
INSERT INTO mercado (name, cnpj, email, endereco_id, num_telefone, password) VALUES
('Mercado A', '12345678000100', 'mercadoA@example.com', 1, '(11) 1234-5678', 'senhaA'),
('Mercado B', '98765432000100', 'mercadoB@example.com', 2, '(22) 9876-5432', 'senhaB');


```


