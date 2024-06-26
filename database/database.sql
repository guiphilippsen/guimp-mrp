-- Tabela Funcionarios --
create table if not exists funcionarios(
id serial not null primary key,
nome varchar(256) not null,
codigoAcesso int,
password varchar(256),
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
-- Teabela Pedido Venda --
create table if not exists pedidoVenda(
id serial not null primary key,
idProduto serial not null,
idVendedor serial not null,
idCliente serial not null,
qtdVenda float not null,
valor float not null,
dataVenda date not null,

CONSTRAINT fk_vendedor
FOREIGN KEY (idVendedor)
REFERENCES funcionarios(id),

CONSTRAINT fk_cliente
FOREIGN KEY (idCliente)
REFERENCES cliente(id)
);