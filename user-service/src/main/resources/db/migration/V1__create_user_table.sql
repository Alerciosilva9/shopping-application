create schema if not exists users;

create table users.users(
	id bigserial not null,
	nome varchar(100) not null,
	cpf varchar(100) not null,
	endereco varchar(100) not null,
	email varchar(100) not null,
	telefone varchar(100) not null,
	data_cadastro timestamp not null,
	primary key (id)
);
