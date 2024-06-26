-- Tabela Funcionarios --
create table if not exists funcionarios(
id serial not null primary key,
nome varchar(256) not null,
cargo varchar(256) not null,
dataContratacao date not null
);
-- Tabela Cliente --
create table if not exists cliente(
id serial not null primary key,
nome varchar(256) not null,
contato varchar(256) not null,
endereco varchar(256) not null
);

-- Tabela Estoque Produto Final --
create table if not exists estoque(
id serial not null primary key,
nome varchar(256) not null,
qtdEstoque float not null,
valor float not null
);
