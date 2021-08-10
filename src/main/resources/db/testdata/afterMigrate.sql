set foreign_key_checks = 0;

delete from aluno;
delete from turma;
delete from turma_aluno;
delete from cidade;
delete from estado;
delete from usuario_permissao;
delete from usuario;
delete from permissao;

set foreign_key_checks = 1;

alter table aluno auto_increment = 1;
alter table turma auto_increment = 1;
alter table cidade auto_increment = 1;
alter table estado auto_increment = 1;
alter table permissao auto_increment = 1;
alter table usuario auto_increment = 1;

insert into estado (nome) values ('Acre');
insert into estado (nome) values ('Alagoas');
insert into estado (nome) values ('Amazonas');
insert into estado (nome) values ('Amapá');
insert into estado (nome) values ('Bahia');
insert into estado (nome) values ('Ceará');
insert into estado (nome) values ('Distrito Federal');
insert into estado (nome) values ('Espírito Santo');
insert into estado (nome) values ('Goiás');
insert into estado (nome) values ('Maranhão');
insert into estado (nome) values ('Minas Gerais');
insert into estado (nome) values ('Mato Grosso do Sul');
insert into estado (nome) values ('Mato Grosso');
insert into estado (nome) values ('Pará');
insert into estado (nome) values ('Paraíba');
insert into estado (nome) values ('Pernambuco');
insert into estado (nome) values ('Piauí');
insert into estado (nome) values ('Paraná');
insert into estado (nome) values ('Rio de Janeiro');
insert into estado (nome) values ('Rio Grande do Norte');
insert into estado (nome) values ('Rondônia');
insert into estado (nome) values ('Roraima');
insert into estado (nome) values ('Rio Grande do Sul');
insert into estado (nome) values ('Santa Catarina');
insert into estado (nome) values ('Sergipe');
insert into estado (nome) values ('São Paulo');
insert into estado (nome) values ('Tocantins');

insert into cidade (nome, estado_id) values ('Belo Horizonte', 11);
insert into cidade (nome, estado_id) values ('Uberlândia', 11);
insert into cidade (nome, estado_id) values ('Uberaba', 11);
insert into cidade (nome, estado_id) values ('Teófilo Otoni', 11);
insert into cidade (nome, estado_id) values ('São Paulo', 26);
insert into cidade (nome, estado_id) values ('Guarulhos', 26);
insert into cidade (nome, estado_id) values ('Campinas', 26);
insert into cidade (nome, estado_id) values ('Rio de Janeiro', 19);
insert into cidade (nome, estado_id) values ('Angra dos Reis', 19);
insert into cidade (nome, estado_id) values ('Goiânia', 9);
insert into cidade (nome, estado_id) values ('Caldas Novas', 9);
insert into cidade (nome, estado_id) values ('Rio Branco', 1);
insert into cidade (nome, estado_id) values ('Maceió', 2);
insert into cidade (nome, estado_id) values ('Manaus', 3);
insert into cidade (nome, estado_id) values ('Macapá', 4);
insert into cidade (nome, estado_id) values ('Salvador', 5);
insert into cidade (nome, estado_id) values ('Fortaleza', 6);
insert into cidade (nome, estado_id) values ('Brasilia', 7);
insert into cidade (nome, estado_id) values ('Vitória', 8);
insert into cidade (nome, estado_id) values ('São Luiz', 10);
insert into cidade (nome, estado_id) values ('Campo Grande', 12);
insert into cidade (nome, estado_id) values ('Belém', 13);
insert into cidade (nome, estado_id) values ('João Pessoa', 14);
insert into cidade (nome, estado_id) values ('Recife', 15);
insert into cidade (nome, estado_id) values ('Teresina', 16);
insert into cidade (nome, estado_id) values ('Curitiba', 17);
insert into cidade (nome, estado_id) values ('Natal', 20);
insert into cidade (nome, estado_id) values ('Porto Velho', 21);
insert into cidade (nome, estado_id) values ('Boa Vista', 22);
insert into cidade (nome, estado_id) values ('Porto Alegre', 23);
insert into cidade (nome, estado_id) values ('Florianópolis', 24);
insert into cidade (nome, estado_id) values ('Aracajú', 25);
insert into cidade (nome, estado_id) values ('Palmas', 27);

insert into turma (nome, instrutor, carga_horaria) values ('Geografia', 'José Campos', 8);
insert into turma (nome, instrutor, carga_horaria) values ('Português', 'Maria Ribeiro', 15);
insert into turma (nome, instrutor, carga_horaria) values ('História', 'Carlos Mendes', 8);
insert into turma (nome, instrutor, carga_horaria) values ('Matemática', 'Ribamar Souza', 12);
insert into turma (nome, instrutor, carga_horaria) values ('Sociologia', 'Jorge Ribeiro', 6);
insert into turma (nome, instrutor, carga_horaria) values ('Educação Fisica', 'Renata Souza', 4);

insert into aluno (nome, idade, telefone, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cep, endereco_id_cidade) values ('Ricardo Dias', '12', '11 98745-3625', 'Rua das Flores', '25', null, 'Jardim Acácia', '36256-458', 1);
insert into aluno (nome, idade, telefone, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cep, endereco_id_cidade) values ('Renato Ramos', '13', '11 92568-2578', 'Rua Maria José', '136', null, 'Jardim Santa Mena', '07145-003', 4);
insert into aluno (nome, idade, telefone, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cep, endereco_id_cidade) values ('Patricia Avelar', '11', '33 95248-2635', 'Rua Turmalina', '63', null, 'Jardim Planalto', '23658-587', 1);
insert into aluno (nome, idade, telefone, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cep, endereco_id_cidade) values ('Henrique Ramos', '12', '21 97452-3687', 'Rua Benedito Ferreira', '03A', null, 'Senador Modestino', '47859-365', 8);
insert into aluno (nome, idade, telefone, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cep, endereco_id_cidade) values ('Eliana Soares', '14', '11 99214-2358', 'Rua Palmares', '869', null, 'Roberto Dias', '09658-254', 5);
insert into aluno (nome, idade, telefone, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cep, endereco_id_cidade) values ('Roseli Ramos', '13', '11 93698-7489', 'Avenida das Caldeiras', '09', null, 'Moema', '25478-698', 6);
insert into aluno (nome, idade, telefone, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cep, endereco_id_cidade) values ('Rafael Santiago', '10', '33 91365-8875', 'Rua Teófilo', '236', null, 'Mirante', '36589-157', 4);

insert into turma_aluno (turma_id, aluno_id) values (6, 6);
insert into turma_aluno (turma_id, aluno_id) values (5, 2);

insert into usuario (nome, email, senha) values ('Administrador', 'admin@admin.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
insert into usuario (nome, email, senha) values ('Renato', 'renato@renato.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');

insert into permissao (descricao) values ('ROLE_CADASTRAR_ALUNO');
insert into permissao (descricao) values ('ROLE_CADASTRAR_TURMA');

insert into usuario_permissao (usuario_id, permissao_id) values (1, 1), (1, 2);
