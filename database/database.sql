-- Tabela Funcionarios --
create table if not exists funcionarios(
id serial not null primary key,
nome varchar(256) not null,
password varchar(256) not null,
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
-- Tabela Enderecos --
create table if not exists enderecos(
id serial not null primary key,
idCliente serial not null,
cep varchar(256) not null,
nomeRua varchar(256) not null,
numero int not null,
CONSTRAINT fk_Cliente
FOREIGN KEY (idCliente)
REFERENCES cliente(id)
);
-- Tabela Estoque Materia Prima --
create table if not exists estoqueMP(
id serial not null primary key,
nome varchar(256) not null,
qtdEstoque float not null,
lote serial not null,
fornecedor varchar(256) not null,
dataRecebimento date not null
);
-- Tabela Estoque Produto Final --
create table if not exists estoquePF(
id serial not null primary key,
nome varchar(256) not null,
qtdEstoque float not null,
lote serial not null,
idUsrProd serial not null,
CONSTRAINT fk_userProd
FOREIGN KEY (idUsrProd)
REFERENCES funcionarios(id)
);
-- Teabela Pedido Venda --
create table if not exists pedidoVenda(
id serial not null primary key,
idProduto serial not null,
idVendedor serial not null,
idCliente serial not null,
qtdVenda float not null,
dataVenda date not null,
CONSTRAINT fk_produtoF
FOREIGN KEY (idProduto)
REFERENCES estoquePF(id),
CONSTRAINT fk_vendedor
FOREIGN KEY (idVendedor)
REFERENCES funcionarios(id),
CONSTRAINT fk_cliente
FOREIGN key (idCliente)
REFERENCES cliente(id)
);
create table if not exists fornecedor(
id serial not null primary key,
nome varchar(256) not null,
contato varchar(256) not null,
produtos varchar(256) not null
);
-- Tabela Pedido Compra --
create table if not exists pedidoCompra(
id serial not null primary key,
idProduto serial not null,
idComprador serial not null,
idFornecedor serial not null,
dataCompra date not null,
CONSTRAINT fk_produtoMP
FOREIGN KEY (idProduto)
REFERENCES estoqueMP(id),
CONSTRAINT fk_comprador
FOREIGN KEY (idComprador)
REFERENCES funcionarios(id),
CONSTRAINT fk_fornecedor
FOREIGN KEY (idFornecedor)
REFERENCES fornecedor(id)
);