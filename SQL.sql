create database svv;
use svv;

create table cliente(
    nome varchar(50) not null,
    endereco varchar(70) not null,
    telefone int not null,
    cliente_id int not null,
    primary key(cliente_id)
);

create table vendedor(
    nome varchar(50) not null,
    telefone int not null,
    departamento varchar(50) not null,
    vendedor_id int not null,
    primary key(vendedor_id)
);

create table veiculo(
    marca varchar(50) not null,
    modelo varchar(50) not null,
    ano int not null,
    chassi varchar(50) not null,
    veiculo_id int not null,
    primary key(veiculo_id)
);

create table contrato(
    data_venda date,
    valor_venda float,
    cliente_id int not null,
    vendedor_id int not null,
    contrato_id int not null,
    primary key(contrato_id),
    foreign key(cliente_id) references cliente(cliente_id),
    foreign key(vendedor_id) references vendedor(vendedor_id)
);


