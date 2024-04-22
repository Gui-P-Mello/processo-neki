CREATE SEQUENCE id_pessoa_sequence
    INCREMENT 1
    START 1
    MINVALUE 1;
   
CREATE SEQUENCE id_skill_sequence
    INCREMENT 1
    START 1
    MINVALUE 1;

CREATE SEQUENCE id_pessoa_skill_sequence
    INCREMENT 1
    START 1
    MINVALUE 1;

create table pessoas(
	id_pessoa integer primary key default nextval('id_pessoa_sequence'),
	nome_pesoa varchar(50) not null,
	login varchar(20) unique not null,
	senha varchar(16) not null
);

create table skills(
	id_skill integer primary key default nextval('id_skill_sequence'),	
	nome_skill varchar(50) unique not null
);

create table pessoa_skill(
	id_pessoa_skill integer primary key default nextval('id_pessoa_skill_sequence'),
	id_pessoa_f_key integer not null,
	id_skill_f_key integer not null,
	foreign key (id_pessoa_f_key) references pessoas(id_pessoa),
    foreign key (id_skill_f_key) references skills(id_skill),
	nivel varchar(20) not null
);