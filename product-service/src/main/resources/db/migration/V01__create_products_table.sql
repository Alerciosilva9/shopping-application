create schema if not exists products;

create table products.category (
	id bigserial primary key,
	nome varchar(100) not null
);

create table products.product (
	id bigserial primary key,
	product_identifier varchar unique not null,
	nome varchar(100) not null,
	descricao varchar not null,
	preco float not null,
	category_id bigint REFERENCES products.category(id)
);

INSERT INTO products.category(id, nome) VALUES(1, 'Eletrônico'); 
INSERT INTO products.category(id, nome) VALUES(2, 'Móveis'); 
INSERT INTO products.category(id, nome) VALUES(3, 'Brinquedos');
