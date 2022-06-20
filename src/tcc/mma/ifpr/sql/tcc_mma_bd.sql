create database tcc_mma;

use tcc_mma;

create table usuario(
id int auto_increment,
nome varchar(30) not null ,
login varchar(50) not null unique,
password varchar(255) not null,
tipo_usuario int(1) default '0',
status int(1) default '1',

primary key(id)
);


create table funcionario(
id int auto_increment,
nome varchar(255) not null,
data_admissao date not null,
data_demissao date,
rg varchar(15) not null,
cpf varchar(15) not null unique,
telefone varchar (20),
data_nascimento date,
endereco varchar(70),
pispasep varchar (14),
numero int ,
status int(1) default '1',
primary key(id)
);


create table categoria(
id int auto_increment,
categoria varchar(50) not null,
status int(1) default '1',
primary key(id)
);








CREATE TABLE `estado` (
 id int(11) auto_increment,
 nome varchar(75),
 uf varchar(5),
 primary key(id)
) ;

CREATE TABLE `cidade` (
  id int(11) auto_increment,
  estado_id int not null,
  nome varchar(120),
  primary key(id),
  foreign key(estado_id) references estado (id)
  ) ;








create table cliente (
id int auto_increment,
nome varchar(255) not null,
data_nascimento date,
cpf varchar(15) not null unique,
rg varchar(15) not null,
cidade_id int not null,
estado_id int not null,
endereco varchar(150) not null,
telefone varchar(15) not null,
email varchar(100),
data_cadastro date,
status int(1) default '1',
primary key(id),
foreign key (cidade_id) references cidade (id),
foreign key (estado_id) references estado (id)
);








create table contasreceber(
id int auto_increment,
cliente_id int not null,
valor varchar(10) not null, 
data_conta date not null,
data_validade date not null,
status int(1) default '1',
primary key(id),
foreign key (cliente_id) references cliente (id)
);


create table fornecedor(
id int auto_increment,
razao_social varchar(255) not null,
telefone varchar(20) not null,
email varchar(100),
cpfcnpj varchar(50) not null unique,
cidade_id int not null,
estado_id int not null,
endereco varchar(100) not null,
status int(1) default '1',
primary key(id),
foreign key (cidade_id) references cidade (id),
foreign key (estado_id) references estado (id));


create table mercadoria(
id int auto_increment,
categoria_id int not null,
fornecedor_id int not null,
descricao varchar(50) not null,
valor varchar (10) not null,
primary key(id),
status int(1) default '1',
foreign key(fornecedor_id) references fornecedor (id),
foreign key(categoria_id) references categoria (id)
);


create table venda (
id int auto_increment,
data_venda date not null,
funcionario_id int not null,
cliente_id int not null,
mercadoria_id int not null,
valor_total varchar(20) not null,
quantidade int not null,
desconto varchar(10) not null,
modo_pagamento varchar(15) not null,
parcelas int not null,
status int(1) not null,
primary key(id),
foreign key (funcionario_id) references funcionario (id),
foreign key (cliente_id) references cliente (id),
foreign key (mercadoria_id) references mercadoria (id)
);





create table encomenda(
id int auto_increment,
data_encomenda date not null,
funcionario_id int not null,
cliente_id int not null,
mercadoria_id int not null,
quantidade int not null,
status int(1) not null,
primary key(id),
foreign key (funcionario_id) references funcionario (id),
foreign key (cliente_id) references cliente (id),
foreign key (mercadoria_id) references mercadoria (id)

);

create table compra (
id int auto_increment,
data_compra date not null,
fornecedor_id int not null,
valor_total varchar (10) not null,
quantidade int not null,
categoria_id int not null,
modo_pagamento varchar(15) not null,
status int(1) default '1',
primary key(id),
foreign key (fornecedor_id) references fornecedor(id),
foreign key (categoria_id) references categoria (id)
);


create table contaspagar (
id int auto_increment,
fornecedor_id int not null,
valor varchar(10) not null, 
data_conta date not null,
data_validade date not null,
status int(1) default '1',
primary key(id),
foreign key (fornecedor_id) references fornecedor(id)
);


