create table usuario (
	id bigint(20) primary key auto_increment,
	nome varchar(100) not null,
	email varchar(50) not null,
	senha varchar(150) not null
) engine=InnoDB default charset=utf8;

create table permissao (
	id bigint(20) primary key auto_increment,
	descricao varchar(50) not null
) engine=InnoDB default charset=utf8;

create table usuario_permissao (
	usuario_id bigint(20) not null,
	permissao_id bigint(20) not null,
	primary key (usuario_id, permissao_id)
) engine=InnoDB default charset=utf8;