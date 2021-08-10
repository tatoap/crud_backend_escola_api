create table estado (
	id bigint(20) primary key auto_increment,
	nome varchar(60) not null
) engine=InnoDB default charset=utf8;

create table cidade (
	id bigInt(20) primary key auto_increment,
	nome varchar(60) not null,
	estado_id bigint(20) not null
) engine=InnoDB default charset=utf8;

alter table cidade add constraint fk_cidade_estado
foreign key (estado_id) references estado (id);

create table turma (
	id bigint(20) primary key auto_increment,
	nome varchar(30) not null,
	instrutor varchar(100) not null
) engine=InnoDB default charset=utf8;

create table aluno (
	id bigint(20) primary key auto_increment,
	nome varchar(100) not null,
	idade bigint(20) not null,
	telefone varchar(14),
	endereco_logradouro varchar(255),
	endereco_numero varchar(5),
	endereco_complemento varchar(100),
	endereco_bairro varchar(60),
	endereco_cep varchar(10),
	endereco_id_cidade bigint(20)
) engine=InnoDB default charset=utf8;

create table turma_aluno (
	turma_id bigint(20) not null,
	aluno_id bigint(20) not null
) engine=InnoDB default charset=utf8;

alter table turma_aluno add constraint fk_turma_aluno
foreign key (turma_id) references turma (id);

alter table turma_aluno add constraint fk_aluno_turma
foreign key (aluno_id) references aluno (id);

alter table aluno add constraint fk_endereco_cidade
foreign key (endereco_id_cidade) references cidade (id);
